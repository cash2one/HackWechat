package com.tencent.mm.plugin.sns.ui;

class SnsTimeLineUI$1 implements Runnable {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$1(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
    }

    public final void run() {
        ax a = SnsTimeLineUI.a(this.rIN);
        if (a != null) {
            a.rJv.bBr();
            a.rJv.notifyVendingDataChange();
        }
    }
}
