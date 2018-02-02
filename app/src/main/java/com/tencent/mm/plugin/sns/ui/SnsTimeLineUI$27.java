package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.x;

class SnsTimeLineUI$27 implements OnTouchListener {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$27(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.rIN.bzr();
            if (SnsTimeLineUI.h(this.rIN).nKG != null && SnsTimeLineUI.h(this.rIN).nKG.getFirstVisiblePosition() == 0) {
                x.d("MicroMsg.SnsTimeLineUI", "refreshIv onTouch set refreshIv visible");
                SnsTimeLineUI.l(this.rIN).setVisibility(0);
            }
            SnsTimeLineUI.z(this.rIN).bBT();
        }
        if (motionEvent.getAction() == 0) {
            if (SnsTimeLineUI.h(this.rIN).nKG != null && SnsTimeLineUI.h(this.rIN).nKG.getFirstVisiblePosition() == 0) {
                SnsTimeLineUI.l(this.rIN).setVisibility(0);
            }
            SnsTimeLineUI.g(this.rIN).bze();
            SnsTimeLineUI.g(this.rIN).rrx.bCm();
        }
        if (this.rIN.rzU != null) {
            this.rIN.rzU.btY();
        }
        return false;
    }
}
