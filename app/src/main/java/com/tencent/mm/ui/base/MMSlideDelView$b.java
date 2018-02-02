package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.x;

class MMSlideDelView$b implements Runnable {
    final /* synthetic */ MMSlideDelView yds;

    MMSlideDelView$b(MMSlideDelView mMSlideDelView) {
        this.yds = mMSlideDelView;
    }

    public final void run() {
        x.v("MicroMsg.MMSlideDelView", "checkfortap");
        this.yds.setPressed(true);
    }
}
