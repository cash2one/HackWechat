package org.xwalk.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedList;
import junit.framework.Assert;

public class XWalkCoreWrapper {
    private static final String BRIDGE_PACKAGE = "org.xwalk.core.internal";
    private static final String TAG = "XWalkLib";
    private static final String WRAPPER_PACKAGE = "org.xwalk.core";
    private static XWalkCoreWrapper sInstance;
    private static XWalkCoreWrapper sProvisionalInstance;
    private static HashMap<String, LinkedList<ReservedAction>> sReservedActions = new HashMap();
    private static LinkedList<String> sReservedActivities = new LinkedList();
    private int mApiVersion = 8;
    private int mApkVersion;
    private Context mBridgeContext;
    private ClassLoader mBridgeLoader;
    private int mCoreStatus;
    private int mMinApiVersion;
    private Context mWrapperContext;
    DexClassLoader sBridgeLoader;

    public static XWalkCoreWrapper getInstance() {
        return sInstance;
    }

    public static int getCoreStatus() {
        if (sInstance != null) {
            return sInstance.mCoreStatus;
        }
        if (sProvisionalInstance == null) {
            return 0;
        }
        return sProvisionalInstance.mCoreStatus;
    }

    public static void handlePreInit(String str) {
        if (sInstance == null) {
            Log.d(TAG, "Pre init xwalk core in " + str);
            if (sReservedActions.containsKey(str)) {
                sReservedActions.remove(str);
            } else {
                sReservedActivities.add(str);
            }
            sReservedActions.put(str, new LinkedList());
        }
    }

    public static void reserveReflectObject(Object obj) {
        String str = (String) sReservedActivities.getLast();
        Log.d(TAG, "Reserve object " + obj.getClass() + " to " + str);
        ((LinkedList) sReservedActions.get(str)).add(new ReservedAction(obj));
    }

    public static void reserveReflectClass(Class<?> cls) {
        String str = (String) sReservedActivities.getLast();
        Log.d(TAG, "Reserve class " + cls.toString() + " to " + str);
        ((LinkedList) sReservedActions.get(str)).add(new ReservedAction(cls));
    }

    public static void reserveReflectMethod(ReflectMethod reflectMethod) {
        String str = (String) sReservedActivities.getLast();
        Log.d(TAG, "Reserve method " + reflectMethod.toString() + " to " + str);
        ((LinkedList) sReservedActions.get(str)).add(new ReservedAction(reflectMethod));
    }

    public static void handlePostInit(String str) {
        Log.d(TAG, "Post init xwalk core in " + str);
        if (sReservedActions.containsKey(str)) {
            LinkedList linkedList = (LinkedList) sReservedActions.get(str);
            while (linkedList.size() != 0) {
                ReservedAction reservedAction = (ReservedAction) linkedList.pop();
                if (reservedAction.mObject != null) {
                    Log.d(TAG, "Init reserved object: " + reservedAction.mObject.getClass());
                    new ReflectMethod(reservedAction.mObject, "reflectionInit", new Class[0]).invoke(new Object[0]);
                } else if (reservedAction.mClass != null) {
                    Log.d(TAG, "Init reserved class: " + reservedAction.mClass.toString());
                    new ReflectMethod(reservedAction.mClass, "reflectionInit", new Class[0]).invoke(new Object[0]);
                } else {
                    Log.d(TAG, "Call reserved method: " + reservedAction.mMethod.toString());
                    Object[] objArr = reservedAction.mArguments;
                    if (objArr != null) {
                        for (int i = 0; i < objArr.length; i++) {
                            if (objArr[i] instanceof ReflectMethod) {
                                objArr[i] = ((ReflectMethod) objArr[i]).invokeWithArguments();
                            }
                        }
                    }
                    reservedAction.mMethod.invoke(objArr);
                }
            }
            sReservedActions.remove(str);
            sReservedActivities.remove(str);
        }
    }

    public static void handleRuntimeError(RuntimeException runtimeException) {
        Log.e(TAG, "This API is incompatible with the Crosswalk runtime library");
    }

    public DexClassLoader getBridgeLoader() {
        if (this.sBridgeLoader != null) {
            return this.sBridgeLoader;
        }
        String extractedCoreDir = XWalkEnvironment.getExtractedCoreDir(this.mApkVersion);
        String classDexFilePath = XWalkEnvironment.getClassDexFilePath(this.mApkVersion);
        if (!new File(classDexFilePath).exists()) {
            return null;
        }
        this.sBridgeLoader = new DexClassLoader(classDexFilePath, XWalkEnvironment.getOptimizedDexDir(this.mApkVersion), extractedCoreDir, ClassLoader.getSystemClassLoader());
        return this.sBridgeLoader;
    }

    public int getApkVersion() {
        DexClassLoader bridgeLoader = getBridgeLoader();
        if (bridgeLoader == null) {
            return 0;
        }
        try {
            Class loadClass = bridgeLoader.loadClass("org.xwalk.core.internal.XWalkCoreVersion");
            if (loadClass == null) {
                return 0;
            }
            int intValue;
            try {
                intValue = ((Integer) new ReflectField(loadClass, "XWALK_APK_VERSION").get()).intValue();
            } catch (RuntimeException e) {
                intValue = 0;
            }
            return intValue;
        } catch (ClassNotFoundException e2) {
            return 0;
        }
    }

    public boolean isDownLoadCoreAvailable() {
        DexClassLoader bridgeLoader = getBridgeLoader();
        if (bridgeLoader == null) {
            return false;
        }
        try {
            if (bridgeLoader.loadClass("org.xwalk.core.internal.XWalkCoreVersion") != null) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static int attachXWalkCore(int i) {
        Assert.assertFalse(sReservedActivities.isEmpty());
        Assert.assertNull(sInstance);
        Log.d(TAG, "Attach xwalk core");
        if (i == -1) {
            Log.i(TAG, "version = -1, no xwalk");
            return 10;
        }
        sProvisionalInstance = new XWalkCoreWrapper(XWalkEnvironment.getApplicationContext(), 1, i);
        if (!XWalkEnvironment.isDownloadMode()) {
            return sProvisionalInstance.mCoreStatus;
        }
        sProvisionalInstance.findDownloadedCore();
        return sProvisionalInstance.mCoreStatus;
    }

    public static void dockXWalkCore() {
        Assert.assertNotNull(sProvisionalInstance);
        Assert.assertNull(sInstance);
        Log.d(TAG, "Dock xwalk core");
        sInstance = sProvisionalInstance;
        sProvisionalInstance = null;
        sInstance.initCoreBridge();
    }

    public static void initEmbeddedMode() {
        if (sInstance == null && sReservedActivities.isEmpty()) {
            throw new RuntimeException("royle:downloadmode should not goto this");
        }
    }

    private XWalkCoreWrapper(Context context, int i, int i2) {
        if (i <= 0 || i > this.mApiVersion) {
            i = this.mApiVersion;
        }
        this.mMinApiVersion = i;
        this.mCoreStatus = 0;
        this.mWrapperContext = context;
        this.mApkVersion = i2;
    }

    private void initCoreBridge() {
        Log.d(TAG, "Init core bridge");
        new ReflectMethod(getBridgeClass("XWalkCoreBridge"), "init", new Class[]{Context.class, Object.class}).invoke(new Object[]{this.mBridgeContext, this});
    }

    private void initXWalkView() {
        Log.d(TAG, "Init xwalk view");
        new ReflectMethod(getBridgeClass("XWalkViewDelegate"), "init", new Class[]{Context.class, Context.class}).invoke(new Object[]{this.mBridgeContext, this.mWrapperContext});
    }

    private boolean findDownloadedCore() {
        this.mBridgeLoader = getBridgeLoader();
        if (this.mBridgeLoader != null && checkCoreVersion() && checkCoreArchitecture() && checkCoreApk()) {
            Log.d(TAG, "Running in downloaded mode");
            this.mCoreStatus = 1;
            return true;
        }
        this.mBridgeLoader = null;
        return false;
    }

    public boolean checkCoreVersion() {
        Log.d(TAG, "[Environment] SDK:" + VERSION.SDK_INT);
        Log.d(TAG, "[App Version] build:24.53.595.0, api:" + this.mApiVersion + ", min_api:" + this.mMinApiVersion);
        try {
            Class bridgeClass = getBridgeClass("XWalkCoreVersion");
            String str = "";
            try {
                str = (String) new ReflectField(bridgeClass, "XWALK_BUILD_VERSION").get();
            } catch (RuntimeException e) {
            }
            int intValue = ((Integer) new ReflectField(bridgeClass, "API_VERSION").get()).intValue();
            int intValue2 = ((Integer) new ReflectField(bridgeClass, "MIN_API_VERSION").get()).intValue();
            Log.d(TAG, "[Lib Version] build:" + str + ", api:" + intValue + ", min_api:" + intValue2);
            if (XWalkEnvironment.isDownloadMode() && XWalkEnvironment.isDownloadModeUpdate() && !str.isEmpty() && !str.equals(XWalkAppVersion.XWALK_BUILD_VERSION)) {
                this.mCoreStatus = 8;
                return false;
            } else if (this.mMinApiVersion > intValue) {
                this.mCoreStatus = 3;
                return false;
            } else if (this.mApiVersion < intValue2) {
                this.mCoreStatus = 4;
                return false;
            } else {
                Log.d(TAG, "XWalk core version matched");
                return true;
            }
        } catch (RuntimeException e2) {
            Log.d(TAG, "XWalk core not found");
            this.mCoreStatus = 2;
            return false;
        }
    }

    private boolean checkCoreArchitecture() {
        try {
            boolean booleanValue;
            ReflectMethod reflectMethod = new ReflectMethod(getBridgeClass("XWalkViewDelegate"), "loadXWalkLibrary", new Class[]{Context.class, String.class});
            String str = null;
            if (this.mBridgeContext != null) {
                if (VERSION.SDK_INT < 17) {
                    str = "/data/data/" + this.mBridgeContext.getPackageName() + "/lib";
                }
                booleanValue = ((Boolean) reflectMethod.invoke(new Object[]{this.mBridgeContext, str})).booleanValue();
            } else if (this.mWrapperContext != null) {
                str = XWalkEnvironment.getExtractedCoreDir(this.mApkVersion);
                booleanValue = ((Boolean) reflectMethod.invoke(new Object[]{this.mBridgeContext, str})).booleanValue();
            } else {
                booleanValue = false;
            }
            if (booleanValue) {
                Log.d(TAG, "XWalk core architecture matched");
                return true;
            }
            Log.d(TAG, "Mismatch of CPU architecture");
            this.mCoreStatus = 6;
            return false;
        } catch (RuntimeException e) {
            Log.d(TAG, e.getLocalizedMessage());
            if (e.getCause() instanceof UnsatisfiedLinkError) {
                this.mCoreStatus = 6;
                return false;
            }
            this.mCoreStatus = 5;
            return false;
        }
    }

    private boolean checkCorePackage(String str) {
        try {
            this.mBridgeContext = this.mWrapperContext.createPackageContext(str, 3);
            Log.d(TAG, "Created package context for " + str);
            return true;
        } catch (NameNotFoundException e) {
            Log.d(TAG, str + " not found");
            return false;
        }
    }

    private boolean checkCoreApk() {
        if (new File(XWalkEnvironment.getDownloadApkPath(this.mApkVersion)).exists()) {
            Log.i(TAG, "XWalk checkCoreApk matched");
            return true;
        }
        Log.e(TAG, "checkCoreApk apk not exists");
        this.mCoreStatus = 9;
        return false;
    }

    private boolean verifyPackageInfo(PackageInfo packageInfo, String str, String str2) {
        if (packageInfo.signatures == null) {
            Log.e(TAG, "No signature in package info");
            return false;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            byte[] hexStringToByteArray = hexStringToByteArray(str2);
            if (hexStringToByteArray == null) {
                throw new IllegalArgumentException("Invalid hash code");
            }
            for (int i = 0; i < packageInfo.signatures.length; i++) {
                Log.d(TAG, "Checking signature " + i);
                if (MessageDigest.isEqual(instance.digest(packageInfo.signatures[i].toByteArray()), hexStringToByteArray)) {
                    Log.d(TAG, "Signature passed verification");
                    return true;
                }
                Log.e(TAG, "Hash code does not match");
            }
            return false;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("Invalid hash algorithm");
        } catch (NullPointerException e2) {
            throw new IllegalArgumentException("Invalid hash algorithm");
        }
    }

    private byte[] hexStringToByteArray(String str) {
        if (str == null || str.isEmpty() || str.length() % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length(); i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public boolean isSharedMode() {
        return this.mBridgeContext != null;
    }

    public Object getBridgeObject(Object obj) {
        try {
            return new ReflectMethod(obj, "getBridge", new Class[0]).invoke(new Object[0]);
        } catch (RuntimeException e) {
            return null;
        }
    }

    public Object getWrapperObject(Object obj) {
        try {
            return new ReflectMethod(obj, "getWrapper", new Class[0]).invoke(new Object[0]);
        } catch (RuntimeException e) {
            return null;
        }
    }

    public Class<?> getBridgeClass(String str) {
        try {
            return this.mBridgeLoader.loadClass("org.xwalk.core.internal." + str);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
