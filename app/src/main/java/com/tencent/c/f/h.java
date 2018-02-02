package com.tencent.c.f;

public final class h {
    private static boolean zUO;
    private static g zUP;

    static {
        zUO = false;
        zUP = new k();
        zUO = false;
        zUP = new k();
    }

    public static void k(Throwable th) {
        cu(th);
    }

    public static void cu(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Exception) {
            new StringBuilder().append(obj);
        } else {
            obj.toString();
        }
    }

    public static void cv(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Exception) {
            new StringBuilder().append(obj);
        } else {
            obj.toString();
        }
    }

    public static void aaW(String str) {
        cw(str);
    }

    public static void aaX(String str) {
        cw(str);
    }

    public static void cw(Object obj) {
        if (obj != null) {
            obj.toString();
        }
    }
}
