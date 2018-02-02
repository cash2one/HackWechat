package com.tencent.mm.compatible.d;

import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Method;

public final class y {
    private static Class<?> gGH;
    private static Method gGI;
    private static Method gGJ;

    static {
        gGH = null;
        gGI = null;
        gGJ = null;
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            gGH = cls;
            gGI = cls.getDeclaredMethod("get", new Class[]{String.class});
            gGJ = gGH.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE});
            gGI.setAccessible(true);
            gGJ.setAccessible(true);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SystemProperties", e, "", new Object[0]);
        }
    }

    public static String get(String str) {
        try {
            return (String) gGI.invoke(null, new Object[]{str});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SystemProperties", e, "", new Object[0]);
            return null;
        }
    }
}
