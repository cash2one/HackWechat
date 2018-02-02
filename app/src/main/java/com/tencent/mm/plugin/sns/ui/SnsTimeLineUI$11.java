package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class SnsTimeLineUI$11 implements a<Void, Void> {
    final /* synthetic */ SnsTimeLineUI rIN;
    final /* synthetic */ String rIQ;

    SnsTimeLineUI$11(SnsTimeLineUI snsTimeLineUI, String str) {
        this.rIN = snsTimeLineUI;
        this.rIQ = str;
    }

    public final /* synthetic */ Object call(Object obj) {
        Void voidR = (Void) obj;
        ax a = SnsTimeLineUI.a(this.rIN);
        if (a != null) {
            a.rJv.rwz = this.rIQ;
            aw awVar = a.rJv;
            awVar.looperCheckForVending();
            x.i("MicroMsg.SnsTimeLineVendingSide", "resetSize %s", new Object[]{Boolean.valueOf(awVar.rJo)});
            if (!awVar.rJo) {
                synchronized (awVar.rJp) {
                    awVar.maQ = awVar.q(0, awVar.maQ);
                }
            }
            a.rJv.notifyVendingDataChange();
        }
        return voidR;
    }
}
