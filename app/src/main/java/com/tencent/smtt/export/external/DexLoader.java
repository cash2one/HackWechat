package com.tencent.smtt.export.external;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import dalvik.system.DexClassLoader;
import dalvik.system.VMStack;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class DexLoader {
    private static final String JAVACORE_PACKAGE_PREFIX = "org.chromium";
    private static final String TAG = "DexLoader";
    private static final String TBS_FUSION_DEX = "tbs_jars_fusion_dex";
    private static final String TBS_WEBVIEW_DEX = "webview_dex";
    private static boolean mUseTbsCorePrivateClassLoader = false;
    private DexClassLoader mClassLoader;

    public DexLoader(Context context, String str, String str2) {
        this(context, new String[]{str}, str2);
    }

    public DexLoader(Context context, String[] strArr, String str) {
        this(null, context, strArr, str);
    }

    public DexLoader(Context context, String[] strArr, String str, DexLoader dexLoader) {
        ClassLoader classLoader = dexLoader.getClassLoader();
        for (String createDexClassLoader : strArr) {
            classLoader = createDexClassLoader(createDexClassLoader, str, context.getApplicationInfo().nativeLibraryDir, classLoader, context);
            this.mClassLoader = classLoader;
        }
    }

    public DexLoader(Context context, String[] strArr, String str, String str2) {
        ClassLoader classLoader = context.getClassLoader();
        String str3 = context.getApplicationInfo().nativeLibraryDir;
        if (!TextUtils.isEmpty(str2)) {
            str3 = str3 + File.pathSeparator + str2;
        }
        for (String createDexClassLoader : strArr) {
            classLoader = createDexClassLoader(createDexClassLoader, str, str3, classLoader, context);
            this.mClassLoader = classLoader;
        }
    }

    public DexLoader(String str, Context context, String[] strArr, String str2) {
        this(str, context, strArr, str2, null);
    }

    public DexLoader(String str, Context context, String[] strArr, String str2, Map<String, Object> map) {
        initTbsSettings(map);
        ClassLoader callingClassLoader = VMStack.getCallingClassLoader();
        if (callingClassLoader == null) {
            callingClassLoader = context.getClassLoader();
        }
        ClassLoader classLoader = callingClassLoader;
        for (String createDexClassLoader : strArr) {
            classLoader = createDexClassLoader(createDexClassLoader, str2, str, classLoader, context);
            this.mClassLoader = classLoader;
        }
    }

    private DexClassLoader createDexClassLoader(String str, String str2, String str3, ClassLoader classLoader, Context context) {
        return shouldUseTbsCorePrivateClassLoader(str) ? new TbsCorePrivateClassLoader(str, str2, str3, classLoader) : VERSION.SDK_INT >= 21 ? DexClassLoaderProvider.createDexClassLoader(str, str2, str3, classLoader, context) : new DexClassLoader(str, str2, str3, classLoader);
    }

    public static void initTbsSettings(Map<String, Object> map) {
        if (map != null) {
            try {
                Object obj = map.get(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER);
                if (obj instanceof Boolean) {
                    mUseTbsCorePrivateClassLoader = ((Boolean) obj).booleanValue();
                }
            } catch (Throwable th) {
            }
        }
    }

    private boolean shouldUseTbsCorePrivateClassLoader(String str) {
        return !mUseTbsCorePrivateClassLoader ? false : str.contains(TBS_FUSION_DEX) || str.contains(TBS_WEBVIEW_DEX);
    }

    public DexClassLoader getClassLoader() {
        return this.mClassLoader;
    }

    public Object getStaticField(String str, String str2) {
        Object obj = null;
        try {
            Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            obj = field.get(null);
        } catch (Throwable th) {
            getClass().getSimpleName();
            new StringBuilder("'").append(str).append("' get field '").append(str2).append("' failed");
        }
        return obj;
    }

    public Object invokeMethod(Object obj, String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (Throwable th) {
            getClass().getSimpleName();
            new StringBuilder("'").append(str).append("' invoke method '").append(str2).append("' failed");
            return null;
        }
    }

    public Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            return method.invoke(null, objArr);
        } catch (Throwable th) {
            if (str2 == null || !str2.equalsIgnoreCase("initTesRuntimeEnvironment")) {
                getClass().getSimpleName();
                new StringBuilder("'").append(str).append("' invoke static method '").append(str2).append("' failed");
                return null;
            }
            getClass().getSimpleName();
            new StringBuilder("'").append(str).append("' invoke static method '").append(str2).append("' failed");
            return th;
        }
    }

    public Class<?> loadClass(String str) {
        try {
            return this.mClassLoader.loadClass(str);
        } catch (Throwable th) {
            getClass().getSimpleName();
            new StringBuilder("loadClass '").append(str).append("' failed");
            return null;
        }
    }

    public Object newInstance(String str) {
        try {
            return this.mClassLoader.loadClass(str).newInstance();
        } catch (Throwable th) {
            getClass().getSimpleName();
            new StringBuilder("create ").append(str).append(" instance failed");
            return null;
        }
    }

    public Object newInstance(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return this.mClassLoader.loadClass(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable th) {
            if ("com.tencent.smtt.webkit.adapter.X5WebViewAdapter".equalsIgnoreCase(str)) {
                getClass().getSimpleName();
                new StringBuilder("'newInstance ").append(str).append(" failed");
                return th;
            }
            getClass().getSimpleName();
            new StringBuilder("create '").append(str).append("' instance failed");
            return null;
        }
    }

    public void setStaticField(String str, String str2, Object obj) {
        try {
            Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            field.set(null, obj);
        } catch (Throwable th) {
            getClass().getSimpleName();
            new StringBuilder("'").append(str).append("' set field '").append(str2).append("' failed");
        }
    }
}
