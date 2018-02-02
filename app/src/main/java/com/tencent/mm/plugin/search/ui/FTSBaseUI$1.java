package com.tencent.mm.plugin.search.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class FTSBaseUI$1 implements OnTouchListener {
    final /* synthetic */ FTSBaseUI qcb;

    FTSBaseUI$1(FTSBaseUI fTSBaseUI) {
        this.qcb = fTSBaseUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        FTSBaseUI.a(this.qcb).zet.yig.clearFocus();
        this.qcb.aWs();
        return false;
    }
}
