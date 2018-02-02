package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.aq.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.sdk.platformtools.bh;

class CardGiftVideoUI$4 implements Runnable {
    final /* synthetic */ String icE;
    final /* synthetic */ CardGiftVideoUI kTl;

    CardGiftVideoUI$4(CardGiftVideoUI cardGiftVideoUI, String str) {
        this.kTl = cardGiftVideoUI;
        this.icE = str;
    }

    public final void run() {
        if (bh.ov(CardGiftVideoUI.a(this.kTl))) {
            CardGiftVideoUI.f(this.kTl).setVisibility(0);
            a aVar = new a();
            aVar.hDD = e.bnF;
            o.PB();
            aVar.hDW = null;
            aVar.hDC = m.wk(this.icE);
            aVar.hDF = 1;
            aVar.hDA = true;
            aVar.hDy = true;
            o.PA().a(this.icE, CardGiftVideoUI.f(this.kTl), aVar.PK());
        }
    }
}
