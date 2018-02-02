package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.z;
import android.util.DisplayMetrics;

class e$1 extends z {
    final /* synthetic */ e kfS;

    e$1(e eVar, Context context) {
        this.kfS = eVar;
        super(context);
    }

    protected final int fd() {
        return -1;
    }

    protected final float a(DisplayMetrics displayMetrics) {
        return 80.0f / ((float) displayMetrics.densityDpi);
    }

    public final PointF bd(int i) {
        return ((LinearLayoutManager) this.kfS.Va.TV).bd(i);
    }
}
