package com.tencent.magicbrush;

import com.tencent.magicbrush.a.c.f;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class a {
    private static String bnj = "";
    private static String bnk = null;

    public static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static void loadLibrary(String str) {
        String str2 = null;
        if (bnk != null) {
            str2 = bnk + "/lib" + str + ".so";
        }
        if (str2 == null || !new File(str2).exists()) {
            f.d("MagicBrush.Utils", "System.loadLibrary(%s)", new Object[]{str});
            System.loadLibrary(str);
            return;
        }
        f.d("MagicBrush.Utils", "System.load(%s)", new Object[]{str2});
        try {
            ClassLoader classLoader = a.class.getClassLoader();
            Runtime runtime = Runtime.getRuntime();
            Method declaredMethod = runtime.getClass().getDeclaredMethod("load", new Class[]{String.class, ClassLoader.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(runtime, new Object[]{str2, classLoader});
        } catch (Exception e) {
            f.e("MagicBrush.Utils", "loadLibrary Exception", new Object[]{e});
        }
    }
}
