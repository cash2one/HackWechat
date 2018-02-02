package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SnsSightPlayerUI$1 implements OnTouchListener {
    final /* synthetic */ SnsSightPlayerUI rGv;

    SnsSightPlayerUI$1(SnsSightPlayerUI snsSightPlayerUI) {
        this.rGv = snsSightPlayerUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.rGv.avV();
        return true;
    }
}
