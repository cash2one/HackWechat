package com.tencent.mm.ui;

import android.content.Context;
import android.util.SparseIntArray;

public final class ah {
    private static float density = -1.0f;
    private static float gOa = 0.0f;
    private static SparseIntArray xbr = new SparseIntArray();

    public static int ab(Context context, int i) {
        if (context == null) {
            ag.k("get dimension pixel size, resId %d, but context is null" + i, new Object[0]);
            return 0;
        }
        int i2 = xbr.get(i, 0);
        if (i2 != 0) {
            return i2;
        }
        i2 = context.getResources().getDimensionPixelSize(i);
        xbr.put(i, i2);
        return i2;
    }
}
