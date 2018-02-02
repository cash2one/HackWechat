package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsoluteLayout;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.d.d.c;

class FTSSOSHomeWebViewUI$13 implements OnTouchListener {
    final /* synthetic */ FTSSOSHomeWebViewUI tDo;
    final /* synthetic */ AbsoluteLayout tlJ;

    FTSSOSHomeWebViewUI$13(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, AbsoluteLayout absoluteLayout) {
        this.tDo = fTSSOSHomeWebViewUI;
        this.tlJ = absoluteLayout;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.tDo.bTy().yig.clearFocus();
        this.tDo.aWs();
        d a = FTSSOSHomeWebViewUI.a(this.tDo);
        c cVar = a.xiR;
        if (cVar != null) {
            cVar.sendMessage(Message.obtain(a.xiR, 15, motionEvent));
        }
        return this.tlJ.onTouchEvent(motionEvent);
    }
}
