package com.tencent.mm.ui.base;

import android.content.Context;
import android.text.Layout;

public final class ab {
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    static boolean a(Layout layout, int i) {
        return i > 0 && layout.getLineForOffset(i) == layout.getLineForOffset(i - 1) + 1;
    }
}
