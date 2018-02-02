package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.mm.plugin.appbrand.q$e;

public final class a {
    public static int ci(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return context.getResources().getDimensionPixelSize(q$e.buF);
        }
        return context.getResources().getDimensionPixelSize(q$e.buG);
    }
}
