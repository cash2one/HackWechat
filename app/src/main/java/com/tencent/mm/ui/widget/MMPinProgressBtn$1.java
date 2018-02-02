package com.tencent.mm.ui.widget;

import com.tencent.mm.sdk.platformtools.x;

class MMPinProgressBtn$1 implements Runnable {
    final /* synthetic */ MMPinProgressBtn zug;

    MMPinProgressBtn$1(MMPinProgressBtn mMPinProgressBtn) {
        this.zug = mMPinProgressBtn;
    }

    public final void run() {
        if (this.zug.getVisibility() != 0) {
            x.i("MicroMsg.MMPinProgressBtn", "cur progress bar not visiable, stop auto pregress");
            return;
        }
        MMPinProgressBtn.a(this.zug, MMPinProgressBtn.a(this.zug) + 1);
        if (MMPinProgressBtn.a(this.zug) >= MMPinProgressBtn.b(this.zug)) {
            MMPinProgressBtn.a(this.zug, MMPinProgressBtn.a(this.zug) - 1);
            x.i("MicroMsg.MMPinProgressBtn", "match auto progress max, return");
            return;
        }
        this.zug.invalidate();
        this.zug.postDelayed(MMPinProgressBtn.c(this.zug), 200);
    }
}
