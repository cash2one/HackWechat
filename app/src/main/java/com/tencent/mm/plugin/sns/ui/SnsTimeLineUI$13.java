package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class SnsTimeLineUI$13 implements a<Void, Void> {
    final /* synthetic */ SnsTimeLineUI rIN;
    final /* synthetic */ boolean rIO;

    SnsTimeLineUI$13(SnsTimeLineUI snsTimeLineUI, boolean z) {
        this.rIN = snsTimeLineUI;
        this.rIO = z;
    }

    public final /* synthetic */ Object call(Object obj) {
        Void voidR = (Void) obj;
        SnsTimeLineUI.h(this.rIN).rLh = this.rIO;
        x.d("MicroMsg.SnsTimeLineUI", "onNpSize %s", new Object[]{Boolean.valueOf(this.rIO)});
        if (this.rIO) {
            SnsTimeLineUI.h(this.rIN).iE(false);
        }
        return voidR;
    }
}
