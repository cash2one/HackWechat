package com.google.android.gms.c;

import android.content.Context;
import java.util.regex.Pattern;

public final class t {
    private static Pattern aXM = null;

    public static boolean P(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static int dq(int i) {
        return i / 1000;
    }

    public static boolean dr(int i) {
        return (i % 1000) / 100 == 3;
    }
}
