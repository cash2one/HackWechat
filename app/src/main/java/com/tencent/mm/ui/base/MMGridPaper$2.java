package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.x;

class MMGridPaper$2 implements Runnable {
    final /* synthetic */ MMGridPaper ybh;

    MMGridPaper$2(MMGridPaper mMGridPaper) {
        this.ybh = mMGridPaper;
    }

    public final void run() {
        x.w("MicroMsg.MMGridPaper", "post do setDotView");
        MMGridPaper.a(this.ybh);
    }
}
