package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.z;
import android.util.DisplayMetrics;

class g$1 extends z {
    final /* synthetic */ g mUT;

    g$1(g gVar, Context context) {
        this.mUT = gVar;
        super(context);
    }

    public final PointF bd(int i) {
        return this.mUT.bd(i);
    }

    protected final float a(DisplayMetrics displayMetrics) {
        return 50.0f / ((float) displayMetrics.densityDpi);
    }
}
