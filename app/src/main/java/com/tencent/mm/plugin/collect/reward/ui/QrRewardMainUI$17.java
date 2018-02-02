package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;

class QrRewardMainUI$17 implements a {
    final /* synthetic */ QrRewardMainUI lkA;

    QrRewardMainUI$17(QrRewardMainUI qrRewardMainUI) {
        this.lkA = qrRewardMainUI;
    }

    public final void i(k kVar) {
        x.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[]{kVar});
        QrRewardMainUI.a(this.lkA, (String) g.Dj().CU().get(w.a.xwR, ""));
        QrRewardMainUI.c(this.lkA, QrRewardMainUI.k(this.lkA));
        QrRewardMainUI.l(this.lkA).setText("");
        QrRewardMainUI.i(this.lkA);
    }
}
