package com.tencent.mm.ui;

public final class ag {
    private static a xNe;
    private static a xNf;

    static {
        a 1 = new 1();
        xNe = 1;
        xNf = 1;
    }

    public static void k(String str, Object... objArr) {
        if (xNf != null) {
            String.format(str, objArr);
        }
    }
}
