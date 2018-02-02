package com.tencent.mm.plugin.appbrand.widget;

import android.graphics.Path;
import android.support.v4.view.b.e;
import android.view.animation.Interpolator;

class CircleProgressDrawable$c {
    public static final Interpolator jUZ = e.b(jVb);
    private static final Path jVb;

    static {
        Path path = new Path();
        jVb = path;
        path.lineTo(0.5f, 0.0f);
        jVb.cubicTo(0.7f, 0.0f, 0.6f, 1.0f, 1.0f, 1.0f);
    }
}
