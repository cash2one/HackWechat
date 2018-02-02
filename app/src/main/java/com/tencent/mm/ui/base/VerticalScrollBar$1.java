package com.tencent.mm.ui.base;

import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.bv.a;

class VerticalScrollBar$1 implements Runnable {
    final /* synthetic */ int nJp;
    final /* synthetic */ int nJq;
    final /* synthetic */ VerticalScrollBar yhF;

    VerticalScrollBar$1(VerticalScrollBar verticalScrollBar, int i, int i2) {
        this.yhF = verticalScrollBar;
        this.nJp = i;
        this.nJq = i2;
    }

    public final void run() {
        if (this.yhF.nJi.length > 0) {
            int measureText = ((int) VerticalScrollBar.a(this.yhF).measureText(this.yhF.nJi[this.yhF.nJi.length - 1])) + a.fromDPToPix(this.yhF.getContext(), 8);
            if (measureText > this.nJp) {
                LayoutParams layoutParams = this.yhF.getLayoutParams();
                layoutParams.width = measureText;
                layoutParams.height = this.nJq;
                this.yhF.setLayoutParams(layoutParams);
            }
        }
    }
}
