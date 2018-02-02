package org.xwalk.core.resource;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;
import android.view.ViewStub;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;

public class XWalkContextWrapper extends ContextWrapper {
    private static final String GENERATED_RESOURCE_CLASS = "org.xwalk.core.R";
    private static final String TAG = "XWalkLib";
    private static String mPackageName = null;
    private static HashMap<Long, Integer> mResourcessKeyIdMap;
    public int apkVersion = 0;
    public String extractedCoreDir;
    private ApplicationInfo mApplicationInfo;
    private Context mContext;
    private boolean mHasAddFilterResources = false;
    private final LayoutInflater mLayoutInflater;
    private Resources mResources;
    private Theme mTheme;

    private static final class XWalkLayoutInflaterFactory implements Factory {
        LayoutInflater layoutInflater;

        private XWalkLayoutInflaterFactory() {
        }

        public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
            View view = null;
            try {
                view = inflateView(str, context, attributeSet);
                if ((view instanceof ViewStub) && VERSION.SDK_INT >= 21) {
                    ((ViewStub) view).setLayoutInflater(this.layoutInflater);
                }
            } catch (ClassNotFoundException e) {
                Log.w(XWalkContextWrapper.TAG, String.format("[XWalkContextWrapper] class not found. name:%s. Use default Inflate.", new Object[]{str}));
            } catch (InflateException e2) {
                Log.w(XWalkContextWrapper.TAG, String.format("[XWalkContextWrapper] Inflate failed. name:%s. Use default Inflate.", new Object[]{str}));
            }
            return view;
        }

        public final View inflateView(String str, Context context, AttributeSet attributeSet) {
            View view = null;
            if (str.indexOf(".") != -1) {
                return this.layoutInflater.createView(str, null, attributeSet);
            }
            if (str.equals("WebView")) {
                view = createView(str, "android.webkit.", attributeSet);
            }
            if (view == null) {
                view = createView(str, "android.widget.", attributeSet);
            }
            if (view == null) {
                return createView(str, "android.view.", attributeSet);
            }
            return view;
        }

        private View createView(String str, String str2, AttributeSet attributeSet) {
            View view = null;
            try {
                view = this.layoutInflater.createView(str, str2, attributeSet);
            } catch (InflateException e) {
            } catch (ClassNotFoundException e2) {
            }
            return view;
        }
    }

    public XWalkContextWrapper(Context context, int i) {
        super(context);
        this.apkVersion = i;
        String downloadApkPath = XWalkEnvironment.getDownloadApkPath(i);
        this.extractedCoreDir = XWalkEnvironment.getExtractedCoreDir(i);
        this.mContext = context;
        this.mLayoutInflater = ((LayoutInflater) context.getSystemService("layout_inflater")).cloneInContext(this);
        Factory xWalkLayoutInflaterFactory = new XWalkLayoutInflaterFactory();
        xWalkLayoutInflaterFactory.layoutInflater = this.mLayoutInflater;
        try {
            Field declaredField = LayoutInflater.class.getDeclaredField("mFactorySet");
            declaredField.setAccessible(true);
            declaredField.setBoolean(this.mLayoutInflater, false);
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "XWalkContextWrapper mFactorySet" + e.getMessage());
        } catch (IllegalAccessException e2) {
            Log.e(TAG, "XWalkContextWrapper mFactorySet" + e2.getMessage());
        }
        this.mLayoutInflater.setFactory(xWalkLayoutInflaterFactory);
        this.mResources = getResources(context, downloadApkPath);
        if (this.mResources != null && this.mApplicationInfo != null) {
            this.mTheme = this.mResources.newTheme();
            if (getPackageInfo(context, downloadApkPath) != null) {
                Theme theme = context.getTheme();
                if (theme != null) {
                    this.mTheme.setTo(theme);
                }
                this.mTheme.applyStyle(this.mApplicationInfo.theme, true);
            }
        }
    }

    private Resources getResources(Context context, String str) {
        if (checkResApkExist(str)) {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
            if (packageArchiveInfo != null) {
                mPackageName = packageArchiveInfo.packageName;
                this.mApplicationInfo = packageArchiveInfo.applicationInfo;
                if (this.mApplicationInfo != null) {
                    this.mApplicationInfo.sourceDir = str;
                    this.mApplicationInfo.publicSourceDir = str;
                    try {
                        Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(this.mApplicationInfo);
                        if (resourcesForApplication != null) {
                            return resourcesForApplication;
                        }
                    } catch (NameNotFoundException e) {
                    } catch (Throwable th) {
                    }
                    Log.i(TAG, "XWalkContextWrapper try getResourcesNotWithReflect failed, use getResourcesWithReflect");
                }
            }
            return getResourcesWithReflect(context, str);
        }
        Log.i(TAG, "XWalkContextWrapper checkResApkExist false");
        return null;
    }

    private Resources getResourcesWithReflect(Context context, String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", new Class[]{String.class}).invoke(assetManager, new Object[]{str});
            Resources resources = super.getResources();
            return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
        } catch (Exception e) {
            Log.e(TAG, "XWalkContextWrapper getResourcesWithReflect error:" + e.getMessage());
            return null;
        }
    }

    private boolean checkResApkExist(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return true;
        }
        return false;
    }

    private PackageInfo getPackageInfo(Context context, String str) {
        return context.getPackageManager().getPackageArchiveInfo(str, 0);
    }

    public HashMap<Long, Integer> getResourcesKeyIdMap(Resources resources) {
        if (mResourcessKeyIdMap != null) {
            return (HashMap) mResourcessKeyIdMap.clone();
        }
        Log.i(TAG, "getResourcesKeyIdMap start");
        HashMap hashMap = new HashMap();
        try {
            for (Class cls : getClassLoader().loadClass(GENERATED_RESOURCE_CLASS).getClasses()) {
                if (cls.getSimpleName().equals("drawable")) {
                    for (Field field : cls.getFields()) {
                        if (Modifier.isFinal(field.getModifiers())) {
                            field.setAccessible(true);
                        }
                        int i = 0;
                        try {
                            TypedValue typedValue = new TypedValue();
                            i = field.getInt(null);
                            resources.getValue(i, typedValue, true);
                            long j = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
                            hashMap.put(Long.valueOf(j), Integer.valueOf(i));
                            Log.d(TAG, "name:" + field.getName() + ",id:" + i + ",key:" + j);
                        } catch (IllegalAccessException e) {
                            Log.w(TAG, field.getName() + " is not accessable.");
                        } catch (IllegalArgumentException e2) {
                            Log.w(TAG, field.getName() + " is not int.");
                        } catch (NotFoundException e3) {
                            Log.w(TAG, field.getName() + " is not found." + Integer.toHexString(i));
                        }
                        if (Modifier.isFinal(field.getModifiers())) {
                            field.setAccessible(false);
                        }
                    }
                    continue;
                }
            }
        } catch (ClassNotFoundException e4) {
            Log.e(TAG, "org.xwalk.core.Ris not found.");
        } catch (Exception e5) {
            Log.e(TAG, e5.getMessage());
        }
        mResourcessKeyIdMap = hashMap;
        Log.i(TAG, "getResourcesKeyIdMap end, size:" + mResourcessKeyIdMap.keySet().size());
        return (HashMap) mResourcessKeyIdMap.clone();
    }

    private Intent getRealIntent(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            intent.setComponent(new ComponentName(getBaseContext(), component.getClassName()));
        }
        return intent;
    }

    public Context getApplicationContext() {
        return this.mContext.getApplicationContext();
    }

    public AssetManager getAssets() {
        AssetManager assets = getResources().getAssets();
        if (assets != null) {
            return assets;
        }
        return super.getAssets();
    }

    public Context getBaseContext() {
        return this.mContext;
    }

    public LayoutInflater getLayoutInflater() {
        return this.mLayoutInflater;
    }

    public String getPackageName() {
        return this.mContext.getPackageName();
    }

    public Context getPlatformContext() {
        return this.mContext;
    }

    public Resources getResources() {
        if (!this.mHasAddFilterResources) {
            if (WebViewExtension.addFilterResources(this.mResources, getResourcesKeyIdMap(this.mResources))) {
                this.mHasAddFilterResources = true;
            } else {
                Log.e(TAG, "mHasAddFilterResources = false");
            }
        }
        Resources resources = this.mResources;
        return resources != null ? resources : super.getResources();
    }

    public Object getSystemService(String str) {
        if (str.equals("layout_inflater")) {
            return getLayoutInflater();
        }
        return this.mContext.getSystemService(str);
    }

    public Theme getTheme() {
        if (this.mTheme != null) {
            return this.mTheme;
        }
        return super.getTheme();
    }

    public void setTheme(int i) {
        if (this.mContext.getTheme() != null) {
            this.mContext.getTheme().applyStyle(i, true);
        } else {
            super.setTheme(i);
        }
    }

    public void startActivity(Intent intent) {
        super.startActivity(getRealIntent(intent));
    }

    public ComponentName startService(Intent intent) {
        return super.startService(getRealIntent(intent));
    }

    public ClassLoader getClassLoader() {
        XWalkCoreWrapper instance = XWalkCoreWrapper.getInstance();
        if (instance != null) {
            return instance.getBridgeLoader();
        }
        return super.getClassLoader();
    }
}
