package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;

class QrRewardMainUI$3 implements a {
    final /* synthetic */ QrRewardMainUI lkA;
    final /* synthetic */ h lkB;

    QrRewardMainUI$3(QrRewardMainUI qrRewardMainUI, h hVar) {
        this.lkA = qrRewardMainUI;
        this.lkB = hVar;
    }

    public final void i(k kVar) {
        x.i("MicroMsg.QrRewardMainUI", "set succ: %s, %s", new Object[]{this.lkB.kHm, QrRewardMainUI.l(this.lkA).getText()});
        if (this.lkB.kHm.equals(QrRewardMainUI.m(this.lkA))) {
            g.Dj().CU().a(w.a.xwR, QrRewardMainUI.m(this.lkA));
            QrRewardMainUI.i(this.lkA);
        }
    }
}
