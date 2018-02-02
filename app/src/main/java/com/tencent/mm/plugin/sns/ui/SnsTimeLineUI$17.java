package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i.j;

class SnsTimeLineUI$17 implements Runnable {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$17(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
    }

    public final void run() {
        this.rIN.cmX();
        SnsTimeLineUI.n(this.rIN);
        this.rIN.setMMTitle(this.rIN.getString(j.qMv));
        SnsTimeLineUI.o(this.rIN);
        SnsTimeLineUI.b(this.rIN, SnsTimeLineUI.h(this.rIN).nKG.getFirstVisiblePosition());
    }
}
