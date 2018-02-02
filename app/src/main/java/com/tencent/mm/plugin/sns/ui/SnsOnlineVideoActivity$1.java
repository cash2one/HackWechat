package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SnsOnlineVideoActivity$1 implements OnTouchListener {
    final /* synthetic */ SnsOnlineVideoActivity rEF;

    SnsOnlineVideoActivity$1(SnsOnlineVideoActivity snsOnlineVideoActivity) {
        this.rEF = snsOnlineVideoActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.rEF.avV();
        return true;
    }
}
