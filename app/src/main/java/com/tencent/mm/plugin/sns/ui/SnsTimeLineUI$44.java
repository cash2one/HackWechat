package com.tencent.mm.plugin.sns.ui;

class SnsTimeLineUI$44 implements Runnable {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$44(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
    }

    public final void run() {
        if (SnsTimeLineUI.a(this.rIN) != null) {
            SnsTimeLineUI.a(this.rIN).rJv.notifyVendingDataChange();
        }
        SnsTimeLineUI.J(this.rIN);
    }
}
