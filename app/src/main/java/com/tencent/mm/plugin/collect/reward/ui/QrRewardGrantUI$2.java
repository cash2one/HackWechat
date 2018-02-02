package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.r;

class QrRewardGrantUI$2 extends r {
    final /* synthetic */ QrRewardGrantUI lkb;

    QrRewardGrantUI$2(QrRewardGrantUI qrRewardGrantUI) {
        this.lkb = qrRewardGrantUI;
    }

    public final void ayX() {
        if (QrRewardGrantUI.a(this.lkb, (int) Math.round(bh.getDouble(QrRewardGrantUI.a(this.lkb).getText(), 0.0d) * 100.0d))) {
            QrRewardGrantUI.b(this.lkb);
        }
    }
}
