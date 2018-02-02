package com.tencent.mm.plugin.search.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class FTSBaseVoiceSearchUI$1 implements OnTouchListener {
    final /* synthetic */ FTSBaseVoiceSearchUI qce;

    FTSBaseVoiceSearchUI$1(FTSBaseVoiceSearchUI fTSBaseVoiceSearchUI) {
        this.qce = fTSBaseVoiceSearchUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        FTSBaseVoiceSearchUI.a(this.qce).clearFocus();
        this.qce.aWs();
        return false;
    }
}
