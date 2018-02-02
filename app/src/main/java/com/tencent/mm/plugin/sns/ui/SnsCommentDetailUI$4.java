package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SnsCommentDetailUI$4 implements OnTouchListener {
    final /* synthetic */ SnsCommentDetailUI rAr;

    SnsCommentDetailUI$4(SnsCommentDetailUI snsCommentDetailUI) {
        this.rAr = snsCommentDetailUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (SnsCommentDetailUI.q(this.rAr) != null) {
            SnsCommentDetailUI.q(this.rAr).bwm();
        }
        return false;
    }
}
