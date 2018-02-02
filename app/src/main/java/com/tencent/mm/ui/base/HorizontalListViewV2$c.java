package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.widget.Scroller;

@TargetApi(14)
final class HorizontalListViewV2$c {
    static {
        if (VERSION.SDK_INT < 14) {
            throw new RuntimeException("sdk is >= 14!");
        }
    }

    public static float b(Scroller scroller) {
        return scroller.getCurrVelocity();
    }
}
