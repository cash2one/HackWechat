package com.tencent.mm.ui.e.b;

import android.graphics.drawable.Drawable;

public final class c {
    private static b zbF = null;

    public static void a(b bVar) {
        zbF = bVar;
    }

    public static Drawable fP(String str, String str2) {
        if (zbF == null) {
            return null;
        }
        a cf = zbF.cf(str, str2);
        if (cf instanceof Drawable) {
            return (Drawable) cf;
        }
        return null;
    }
}
