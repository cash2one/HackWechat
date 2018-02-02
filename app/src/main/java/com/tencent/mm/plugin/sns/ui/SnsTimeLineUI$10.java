package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.vending.c.a;

class SnsTimeLineUI$10 implements a<Void, Void> {
    final /* synthetic */ SnsTimeLineUI rIN;
    final /* synthetic */ boolean rIO;
    final /* synthetic */ boolean rIP;

    SnsTimeLineUI$10(SnsTimeLineUI snsTimeLineUI, boolean z, boolean z2) {
        this.rIN = snsTimeLineUI;
        this.rIO = z;
        this.rIP = z2;
    }

    public final /* synthetic */ Object call(Object obj) {
        Void voidR = (Void) obj;
        SnsTimeLineUI.h(this.rIN).rLh = this.rIO;
        if (this.rIO) {
            SnsTimeLineUI.h(this.rIN).iE(false);
        } else if (this.rIP) {
            SnsTimeLineUI.k(this.rIN).rRV.b("@__weixintimtline", SnsTimeLineUI.i(this.rIN), SnsTimeLineUI.j(this.rIN), 0);
        }
        return voidR;
    }
}
