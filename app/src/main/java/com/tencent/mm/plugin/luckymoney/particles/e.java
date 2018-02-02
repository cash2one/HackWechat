package com.tencent.mm.plugin.luckymoney.particles;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.animation.Interpolator;

public final class e {
    private static final Paint oeK;
    private static Interpolator oeL;

    static {
        Paint paint = new Paint();
        oeK = paint;
        paint.setStyle(Style.FILL);
    }

    public static Interpolator aXo() {
        if (oeL == null) {
            oeL = new 1();
        }
        return oeL;
    }
}
