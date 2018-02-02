package com.tencent.mm.compatible.util;

import android.os.Build.VERSION;

public final class d {
    public static boolean fM(int i) {
        return VERSION.SDK_INT >= i;
    }

    public static boolean fN(int i) {
        return VERSION.SDK_INT < i;
    }

    public static boolean fO(int i) {
        return VERSION.SDK_INT > i;
    }
}
