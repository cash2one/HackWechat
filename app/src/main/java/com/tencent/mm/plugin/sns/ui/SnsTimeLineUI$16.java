package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.platformtools.x;

class SnsTimeLineUI$16 implements Runnable {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$16(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
    }

    public final void run() {
        if (SnsTimeLineUI.a(this.rIN) != null && !SnsTimeLineUI.m(this.rIN)) {
            x.v("MicroMsg.SnsTimeLineUI", "zeustest update onFling notify resume %s", new Object[]{Integer.valueOf(SnsTimeLineUI.h(this.rIN).nKG.getFirstVisiblePosition() - SnsTimeLineUI.h(this.rIN).nKG.getHeaderViewsCount())});
            ae.bvs().start();
            SnsTimeLineUI.a(this.rIN).rJu.bBC();
        }
    }
}
