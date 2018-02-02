package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Timer;

public class DexClassLoaderProvider extends DexClassLoader {
    private static final String IS_FIRST_LOAD_DEX_FLAG_FILE = "is_first_load_dex_flag_file";
    private static final String LAST_DEX_NAME = "tbs_jars_fusion_dex.jar";
    private static final long LOAD_DEX_DELAY = 3000;
    private static final String LOGTAG = "dexloader";
    protected static DexClassLoader mClassLoaderOriginal = null;
    private static Context mContext = null;
    private static boolean mForceLoadDexFlag = false;
    private static DexClassLoaderProvider mInstance = null;
    private static String mRealDexPath = null;
    protected static Service mService = null;
    private SpeedyDexClassLoader mClassLoader = null;

    private DexClassLoaderProvider(String str, String str2, String str3, ClassLoader classLoader, boolean z) {
        super(str, str2, str3, classLoader);
        if (z) {
            this.mClassLoader = new SpeedyDexClassLoader(mRealDexPath, null, str3, classLoader);
        } else {
            this.mClassLoader = null;
        }
    }

    public static DexClassLoader createDexClassLoader(String str, String str2, String str3, ClassLoader classLoader, Context context) {
        mContext = context.getApplicationContext();
        mRealDexPath = str;
        int lastIndexOf = str.lastIndexOf("/");
        String str4 = str.substring(0, lastIndexOf + 1) + "fake_dex.jar";
        String substring = str.substring(lastIndexOf + 1);
        if (is_first_load_tbs_dex(str2, substring)) {
            mInstance = new DexClassLoaderProvider(str4, str2, str3, classLoader, true);
            doAsyncDexLoad(substring, str, str2, str3, classLoader);
        } else {
            mInstance = new DexClassLoaderProvider(str, str2, str3, classLoader, false);
        }
        return mInstance;
    }

    private static void doAsyncDexLoad(String str, String str2, String str3, String str4, ClassLoader classLoader) {
        if (shouldSkipAsyncDexLoad()) {
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(0, str);
            arrayList.add(1, str2);
            arrayList.add(2, str3);
            arrayList.add(3, str4);
            Intent intent = new Intent(mContext, DexClassLoaderProviderService.class);
            intent.putStringArrayListExtra("dex2oat", arrayList);
            mContext.startService(intent);
            return;
        }
        new Timer().schedule(new 1(str2, str3, str4, classLoader, str), LOAD_DEX_DELAY);
    }

    private static boolean is_first_load_tbs_dex(String str, String str2) {
        return mForceLoadDexFlag || !new File(str, str2 + "_is_first_load_dex_flag_file").exists();
    }

    static void setForceLoadDexFlag(boolean z, Service service) {
        mForceLoadDexFlag = z;
        mService = service;
    }

    private static void set_first_load_tbs_dex(String str, String str2) {
        File file = new File(str, str2 + "_is_first_load_dex_flag_file");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable th) {
            }
        }
    }

    private static boolean shouldSkipAsyncDexLoad() {
        return !mForceLoadDexFlag && VERSION.SDK_INT == 21;
    }

    private boolean useSelfClassloader() {
        return this.mClassLoader == null;
    }

    public void clearAssertionStatus() {
        if (useSelfClassloader()) {
            super.clearAssertionStatus();
        } else {
            this.mClassLoader.clearAssertionStatus();
        }
    }

    protected Package definePackage(String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url) {
        return useSelfClassloader() ? super.definePackage(str, str2, str3, str4, str5, str6, str7, url) : this.mClassLoader.definePackage(str, str2, str3, str4, str5, str6, str7, url);
    }

    protected Class<?> findClass(String str) {
        return useSelfClassloader() ? super.findClass(str) : this.mClassLoader.findClass(str);
    }

    public String findLibrary(String str) {
        return useSelfClassloader() ? super.findLibrary(str) : this.mClassLoader.findLibrary(str);
    }

    protected URL findResource(String str) {
        return useSelfClassloader() ? super.findResource(str) : this.mClassLoader.findResource(str);
    }

    protected Enumeration<URL> findResources(String str) {
        return useSelfClassloader() ? super.findResources(str) : this.mClassLoader.findResources(str);
    }

    protected synchronized Package getPackage(String str) {
        return useSelfClassloader() ? super.getPackage(str) : this.mClassLoader.getPackage(str);
    }

    protected Package[] getPackages() {
        return useSelfClassloader() ? super.getPackages() : this.mClassLoader.getPackages();
    }

    public URL getResource(String str) {
        return useSelfClassloader() ? super.getResource(str) : this.mClassLoader.getResource(str);
    }

    public InputStream getResourceAsStream(String str) {
        return useSelfClassloader() ? getResourceAsStream(str) : this.mClassLoader.getResourceAsStream(str);
    }

    public Enumeration<URL> getResources(String str) {
        return useSelfClassloader() ? super.getResources(str) : this.mClassLoader.getResources(str);
    }

    public Class<?> loadClass(String str) {
        return useSelfClassloader() ? super.loadClass(str) : this.mClassLoader.loadClass(str);
    }

    protected Class<?> loadClass(String str, boolean z) {
        return useSelfClassloader() ? super.loadClass(str, z) : this.mClassLoader.loadClass(str, z);
    }

    public void setClassAssertionStatus(String str, boolean z) {
        if (useSelfClassloader()) {
            super.setClassAssertionStatus(str, z);
        } else {
            this.mClassLoader.setClassAssertionStatus(str, z);
        }
    }

    public void setDefaultAssertionStatus(boolean z) {
        if (useSelfClassloader()) {
            super.setDefaultAssertionStatus(z);
        } else {
            this.mClassLoader.setDefaultAssertionStatus(z);
        }
    }

    public void setPackageAssertionStatus(String str, boolean z) {
        if (useSelfClassloader()) {
            super.setPackageAssertionStatus(str, z);
        } else {
            this.mClassLoader.setPackageAssertionStatus(str, z);
        }
    }

    public String toString() {
        return useSelfClassloader() ? super.toString() : this.mClassLoader.toString();
    }
}
