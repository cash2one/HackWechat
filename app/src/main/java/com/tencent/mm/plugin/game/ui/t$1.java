package com.tencent.mm.plugin.game.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

class t$1 implements OnGlobalLayoutListener {
    final /* synthetic */ TextView nuV;
    final /* synthetic */ TextView nuW;
    final /* synthetic */ t nuX;

    t$1(t tVar, TextView textView, TextView textView2) {
        this.nuX = tVar;
        this.nuV = textView;
        this.nuW = textView2;
    }

    public final void onGlobalLayout() {
        if (this.nuV.getLineCount() > 1) {
            this.nuV.setMaxLines(2);
            this.nuW.setMaxLines(1);
            return;
        }
        this.nuW.setMaxLines(2);
    }
}
