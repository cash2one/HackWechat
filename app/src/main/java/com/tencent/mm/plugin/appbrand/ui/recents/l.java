package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.z;

final class l extends z {
    private final LinearLayoutManager jRo;
    private final int jRp = 3000;
    private final int jRq;

    l(Context context, LinearLayoutManager linearLayoutManager) {
        super(context);
        this.jRo = linearLayoutManager;
        this.jRq = Math.round(((float) context.getResources().getDisplayMetrics().heightPixels) * 0.75f);
    }

    protected final int bg(int i) {
        return super.bg(Math.max(this.jRq, Math.min(this.jRp, i)));
    }

    public final PointF bd(int i) {
        return this.jRo.bd(i);
    }
}
