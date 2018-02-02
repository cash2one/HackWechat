package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.j.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.app.a.b;

class SnsTimeLineUI$19 implements b<c.b> {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$19(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
    }

    public final /* synthetic */ void aX(Object obj) {
        c.b bVar = (c.b) obj;
        if (bVar.rRY > 0) {
            SnsTimeLineUI.a(this.rIN, bVar);
            SnsTimeLineUI.v(this.rIN).findViewById(f.qFa).setVisibility(0);
        } else {
            SnsTimeLineUI.v(this.rIN).findViewById(f.qFa).setVisibility(8);
        }
        if (SnsTimeLineUI.h(this.rIN).raX != null && SnsTimeLineUI.h(this.rIN).raX.bAU()) {
            SnsTimeLineUI.v(this.rIN).setVisibility(0);
        } else if (bVar.rRY == 0) {
            SnsTimeLineUI.v(this.rIN).setVisibility(8);
        }
        if (SnsTimeLineUI.a(this.rIN) != null && SnsTimeLineUI.w(this.rIN).hasDrawed()) {
            SnsTimeLineUI.a(this.rIN).rJv.notifyVendingDataChange();
            x.i("MicroMsg.SnsTimeLineUI", "has not show view, pass");
        }
    }
}
