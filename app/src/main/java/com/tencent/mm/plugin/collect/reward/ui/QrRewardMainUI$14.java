package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.b;
import com.tencent.mm.sdk.platformtools.x;

class QrRewardMainUI$14 implements a {
    final /* synthetic */ QrRewardMainUI lkA;
    final /* synthetic */ b lkF;

    QrRewardMainUI$14(QrRewardMainUI qrRewardMainUI, b bVar) {
        this.lkA = qrRewardMainUI;
        this.lkF = bVar;
    }

    public final void i(k kVar) {
        x.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[]{kVar});
        if (!this.lkF.ljt) {
            QrRewardMainUI.a(this.lkA, false);
        }
    }
}
