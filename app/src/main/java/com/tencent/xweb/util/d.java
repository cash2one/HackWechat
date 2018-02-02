package com.tencent.xweb.util;

import android.os.Build.VERSION;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import org.xwalk.core.Log;

public final class d {
    public static Object gd(String str, String str2) {
        Object obj = null;
        try {
            obj = Class.forName(str).getMethod(str2, new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th) {
        }
        return obj;
    }

    public static Object g(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        try {
            Method method;
            Class cls = obj.getClass();
            if (VERSION.SDK_INT > 10) {
                method = cls.getMethod(str, null);
            } else {
                method = cls.getDeclaredMethod(str, null);
            }
            method.setAccessible(true);
            return method.invoke(obj, null);
        } catch (Throwable th) {
            if (th.getCause() != null && th.getCause().toString().contains("AuthenticationFail")) {
                return new String("AuthenticationFail");
            }
            if (str.equalsIgnoreCase("canLoadX5Core") || str.equalsIgnoreCase("initTesRuntimeEnvironment")) {
                return null;
            }
            Writer stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            Log.e("ReflectionUtils", "invokeInstance -- exceptions:" + stringWriter.toString());
            return null;
        }
    }
}
