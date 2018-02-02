package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.ae;

class SnsTimeLineUI$15 implements Runnable {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$15(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
    }

    public final void run() {
        if (SnsTimeLineUI.a(this.rIN) != null && SnsTimeLineUI.m(this.rIN)) {
            ae.bvs().pause();
        }
    }
}
