package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.aa.ui.PaylistAAUI.13;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p$c;
import com.tencent.mm.z.q;

class PaylistAAUI$13$1 implements p$c {
    final /* synthetic */ 13 iku;

    PaylistAAUI$13$1(13 13) {
        this.iku = 13;
    }

    public final void a(n nVar) {
        nVar.add(0, 1, 1, i.uMx);
        if (!bh.ov(PaylistAAUI.g(this.iku.ikp)) && PaylistAAUI.g(this.iku.ikp).equals(q.FS()) && this.iku.ikt.state == a.ifN && this.iku.ikt.vDy < this.iku.ikt.vDw) {
            nVar.add(0, 2, 1, i.uGR);
        }
    }
}
