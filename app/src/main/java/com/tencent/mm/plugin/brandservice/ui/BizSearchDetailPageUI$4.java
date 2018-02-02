package com.tencent.mm.plugin.brandservice.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class BizSearchDetailPageUI$4 implements OnTouchListener {
    final /* synthetic */ BizSearchDetailPageUI kFp;

    BizSearchDetailPageUI$4(BizSearchDetailPageUI bizSearchDetailPageUI) {
        this.kFp = bizSearchDetailPageUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (BizSearchDetailPageUI.f(this.kFp) != null) {
            BizSearchDetailPageUI.f(this.kFp).clearFocus();
        }
        this.kFp.aWs();
        return false;
    }
}
