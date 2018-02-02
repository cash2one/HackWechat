package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView.g;

class MMSlideDelView$a extends g implements Runnable {
    final /* synthetic */ MMSlideDelView yds;

    private MMSlideDelView$a(MMSlideDelView mMSlideDelView) {
        this.yds = mMSlideDelView;
        super(mMSlideDelView, (byte) 0);
    }

    public final void run() {
        Object obj = (this.yds.hasWindowFocus() && MMSlideDelView.c(this.yds) == this.ydt) ? 1 : null;
        if (obj != null && !MMSlideDelView.d(this.yds)) {
            x.i("MicroMsg.MMSlideDelView", "is long press");
            if (this.yds.getParent() != null) {
                MMSlideDelView.e(this.yds);
                this.yds.performLongClick();
            }
        }
    }
}
