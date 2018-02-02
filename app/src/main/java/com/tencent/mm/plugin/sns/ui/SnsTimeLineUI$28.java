package com.tencent.mm.plugin.sns.ui;

class SnsTimeLineUI$28 implements Runnable {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$28(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
    }

    public final void run() {
        if (SnsTimeLineUI.g(this.rIN) != null) {
            SnsTimeLineUI.g(this.rIN).rrx.rzE = SnsTimeLineUI.h(this.rIN).nKG.getBottom();
            SnsTimeLineUI.g(this.rIN).rrx.rMP = SnsTimeLineUI.h(this.rIN).onH.getTop();
            SnsTimeLineUI.z(this.rIN).rJf = SnsTimeLineUI.h(this.rIN).raX.getTop();
        }
    }
}
