package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.n;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.ak.b.a;

class QrRewardSelectMoneyUI$6 implements a {
    final /* synthetic */ QrRewardSelectMoneyUI lkR;
    final /* synthetic */ long lkU;

    QrRewardSelectMoneyUI$6(QrRewardSelectMoneyUI qrRewardSelectMoneyUI, long j) {
        this.lkR = qrRewardSelectMoneyUI;
        this.lkU = j;
    }

    public final void v(String str, boolean z) {
        if (z) {
            x.v("MicroMsg.QrRewardSelectMoneyUI", "getContact suc; cost=" + (bh.Wp() - this.lkU) + " ms");
            b.I(str, 3);
            n.JS().iY(str);
        } else {
            x.w("MicroMsg.QrRewardSelectMoneyUI", "getContact failed");
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(QrRewardSelectMoneyUI.c(this.lkR), str, 0.03f, false);
        QrRewardSelectMoneyUI.d(this.lkR).setText(i.a(this.lkR.mController.xIM, e.gu(str)));
    }
}
