package com.google.android.gms.common;

import android.content.Context;
import android.content.Intent;

public final class b {
    public static final int aJG = e.aJG;
    private static final b aJH = new b();

    b() {
    }

    public static int C(Context context) {
        int C = e.C(context);
        return e.l(context, C) ? 18 : C;
    }

    public static void D(Context context) {
        e.D(context);
    }

    public static Intent dd(int i) {
        return e.de(i);
    }

    public static boolean l(Context context, int i) {
        return e.l(context, i);
    }

    public static b nR() {
        return aJH;
    }
}
