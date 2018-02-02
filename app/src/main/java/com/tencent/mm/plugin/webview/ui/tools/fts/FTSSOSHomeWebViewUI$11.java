package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class FTSSOSHomeWebViewUI$11 implements OnTouchListener {
    final /* synthetic */ FTSSOSHomeWebViewUI tDo;

    FTSSOSHomeWebViewUI$11(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        this.tDo = fTSSOSHomeWebViewUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.tDo.bTy().yig.clearFocus();
        this.tDo.aWs();
        return false;
    }
}
