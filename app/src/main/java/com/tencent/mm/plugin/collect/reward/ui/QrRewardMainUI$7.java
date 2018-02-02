package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class QrRewardMainUI$7 implements a {
    final /* synthetic */ QrRewardMainUI lkA;

    QrRewardMainUI$7(QrRewardMainUI qrRewardMainUI) {
        this.lkA = qrRewardMainUI;
    }

    public final void aze() {
        x.d("MicroMsg.QrRewardMainUI", "go to: %s", new Object[]{QrRewardMainUI.q(this.lkA)});
        e.l(this.lkA.mController.xIM, QrRewardMainUI.q(this.lkA), false);
        g.pQN.h(14721, new Object[]{Integer.valueOf(1), Integer.valueOf(6)});
    }
}
