package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.x;

class MMSlideDelView$2 implements Runnable {
    final /* synthetic */ MMSlideDelView yds;

    MMSlideDelView$2(MMSlideDelView mMSlideDelView) {
        this.yds = mMSlideDelView;
    }

    public final void run() {
        this.yds.setPressed(false);
        x.v("MicroMsg.MMSlideDelView", "onClick");
        MMSlideDelView.b(this.yds).t(this.yds, MMSlideDelView.a(this.yds));
        this.yds.cpA();
    }
}
