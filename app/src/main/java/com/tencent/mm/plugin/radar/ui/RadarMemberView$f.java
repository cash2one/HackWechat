package com.tencent.mm.plugin.radar.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import b.c.b.e;

final class RadarMemberView$f implements OnTouchListener {
    final /* synthetic */ RadarMemberView pyq;

    RadarMemberView$f(RadarMemberView radarMemberView) {
        this.pyq = radarMemberView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (view != RadarMemberView.b(this.pyq)) {
            e.h(motionEvent, "event");
            if (motionEvent.getAction() == 1 && this.pyq.isShowing()) {
                this.pyq.dismiss();
            }
        }
        return true;
    }
}
