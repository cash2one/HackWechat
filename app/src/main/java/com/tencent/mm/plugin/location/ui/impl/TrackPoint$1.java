package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnLongClickListener;

class TrackPoint$1 implements OnLongClickListener {
    final /* synthetic */ TrackPoint nYs;

    TrackPoint$1(TrackPoint trackPoint) {
        this.nYs = trackPoint;
    }

    public final boolean onLongClick(View view) {
        if (TrackPoint.a(this.nYs).getVisibility() == 0) {
            TrackPoint.a(this.nYs).setVisibility(4);
        } else {
            TrackPoint.a(this.nYs).setVisibility(0);
        }
        return false;
    }
}
