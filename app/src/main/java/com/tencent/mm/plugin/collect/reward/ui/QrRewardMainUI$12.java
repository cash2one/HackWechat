package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.sdk.platformtools.x;

class QrRewardMainUI$12 implements a {
    final /* synthetic */ QrRewardMainUI lkA;

    QrRewardMainUI$12(QrRewardMainUI qrRewardMainUI) {
        this.lkA = qrRewardMainUI;
    }

    public final void aze() {
        x.i("MicroMsg.QrRewardMainUI", "click save code");
        QrRewardMainUI.b(this.lkA);
        g.pQN.h(14721, Integer.valueOf(1), Integer.valueOf(5));
    }
}
