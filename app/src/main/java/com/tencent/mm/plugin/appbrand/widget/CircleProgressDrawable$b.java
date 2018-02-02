package com.tencent.mm.plugin.appbrand.widget;

import android.graphics.Path;
import android.support.v4.view.b.e;
import android.view.animation.Interpolator;

class CircleProgressDrawable$b {
    public static final Interpolator jUZ = e.b(jVa);
    private static final Path jVa;

    static {
        Path path = new Path();
        jVa = path;
        path.cubicTo(0.2f, 0.0f, 0.1f, 1.0f, 0.5f, 1.0f);
        jVa.lineTo(1.0f, 1.0f);
    }
}
