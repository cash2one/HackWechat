package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.vending.c.a;

class SnsTimeLineUI$14 implements a<Void, Void> {
    final /* synthetic */ SnsTimeLineUI rIN;
    final /* synthetic */ String rIQ;

    SnsTimeLineUI$14(SnsTimeLineUI snsTimeLineUI, String str) {
        this.rIN = snsTimeLineUI;
        this.rIQ = str;
    }

    public final /* synthetic */ Object call(Object obj) {
        Void voidR = (Void) obj;
        ax a = SnsTimeLineUI.a(this.rIN);
        if (a != null) {
            a.rJv.rwz = this.rIQ;
            a.rJv.bBr();
            a.rJv.notifyVendingDataChange();
        }
        return voidR;
    }
}
