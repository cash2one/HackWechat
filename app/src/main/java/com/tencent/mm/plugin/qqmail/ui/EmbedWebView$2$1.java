package com.tencent.mm.plugin.qqmail.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.qqmail.ui.EmbedWebView.2;

class EmbedWebView$2$1 implements OnTouchListener {
    final /* synthetic */ 2 psj;

    EmbedWebView$2$1(2 2) {
        this.psj = 2;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 2) {
            this.psj.psi.onTouchEvent(motionEvent);
        }
        return false;
    }
}
