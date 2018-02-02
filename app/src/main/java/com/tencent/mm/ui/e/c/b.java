package com.tencent.mm.ui.e.c;

import android.content.Context;

public final class b {
    private static a zbG = null;

    public static void a(a aVar) {
        zbG = aVar;
    }

    public static CharSequence a(Context context, CharSequence charSequence, int i) {
        if (zbG != null) {
            return zbG.a(context, charSequence, i);
        }
        return charSequence;
    }

    public static CharSequence c(Context context, CharSequence charSequence, float f) {
        if (zbG != null) {
            return zbG.c(context, charSequence, f);
        }
        return charSequence;
    }

    public static int q(Context context, String str, int i) {
        if (zbG != null) {
            return zbG.bb(str, i);
        }
        return i;
    }
}
