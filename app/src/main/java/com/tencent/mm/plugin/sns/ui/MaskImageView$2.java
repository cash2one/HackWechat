package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MaskImageView$2 implements OnTouchListener {
    final /* synthetic */ MaskImageView ruq;

    MaskImageView$2(MaskImageView maskImageView) {
        this.ruq = maskImageView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (MaskImageView.a(this.ruq)) {
            return this.ruq.c(view, motionEvent);
        }
        return false;
    }
}
