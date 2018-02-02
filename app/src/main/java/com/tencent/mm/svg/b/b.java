package com.tencent.mm.svg.b;

import java.lang.reflect.Field;

public final class b {
    private static boolean gSX = false;
    private static String mPackageName = "";
    private static boolean xCR = false;
    private static boolean xCS = false;

    public static void cu(String str) {
        mPackageName = str;
    }

    public static final boolean clg() {
        return xCS;
    }

    public static final void lK(boolean z) {
        xCS = z;
    }

    private static final Object Yj(String str) {
        try {
            Class cls = Class.forName(mPackageName + ".svg.SVGBuildConfig");
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(cls);
        } catch (Throwable e) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e, "NoSuchFieldException", new Object[0]);
            return null;
        } catch (Throwable e2) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e2, "IllegalArgumentException", new Object[0]);
            return null;
        } catch (Throwable e22) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e22, "ClassNotFoundException", new Object[0]);
            return null;
        } catch (Throwable e222) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e222, "IllegalAccessException", new Object[0]);
            return null;
        }
    }

    public static final boolean clh() {
        if (!gSX) {
            Object Yj = Yj("WxSVGCode");
            if (Yj == null) {
                xCR = false;
            } else {
                xCR = ((Boolean) Yj).booleanValue();
            }
            c.i("MicroMSG.WeChatSVGConfig", "Initialized mUsingWeChatSVGCode %s", Boolean.valueOf(xCR));
            gSX = true;
        }
        if (xCR) {
            return false;
        }
        return true;
    }

    public static final Class<?> cli() {
        Object Yj = Yj("WxSVGRawClass");
        if (Yj != null) {
            return (Class) Yj;
        }
        return null;
    }

    public static long clj() {
        return System.nanoTime();
    }

    public static long fT(long j) {
        return (System.nanoTime() - j) / 1000;
    }
}
