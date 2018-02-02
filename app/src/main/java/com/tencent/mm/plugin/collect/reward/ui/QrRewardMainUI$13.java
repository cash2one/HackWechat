package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.sdk.platformtools.x;

class QrRewardMainUI$13 implements a {
    final /* synthetic */ QrRewardMainUI lkA;

    QrRewardMainUI$13(QrRewardMainUI qrRewardMainUI) {
        this.lkA = qrRewardMainUI;
    }

    public final void aze() {
        x.i("MicroMsg.QrRewardMainUI", "click set code, %s", new Object[]{Boolean.valueOf(QrRewardMainUI.c(this.lkA))});
        QrRewardMainUI.a(this.lkA, false);
    }
}
