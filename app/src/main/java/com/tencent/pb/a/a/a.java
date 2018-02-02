package com.tencent.pb.a.a;

import com.tencent.pb.common.c.g;

public final class a {
    private static String TAG = "AccountEngine";
    private static int zQo = 0;
    private static String zQp = "";

    public static String cCV() {
        return zQp;
    }

    public static void aaK(String str) {
        if (str == null) {
            str = "";
        }
        zQp = str;
    }

    public static void HK(int i) {
        zQo = i;
    }

    public static boolean cCW() {
        return !g.AA(zQp);
    }
}
