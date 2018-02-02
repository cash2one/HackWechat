package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class QrRewardSelectMoneyUI$5 implements a {
    final /* synthetic */ QrRewardSelectMoneyUI lkR;
    final /* synthetic */ f lkS;

    QrRewardSelectMoneyUI$5(QrRewardSelectMoneyUI qrRewardSelectMoneyUI, f fVar) {
        this.lkR = qrRewardSelectMoneyUI;
        this.lkS = fVar;
    }

    public final void i(k kVar) {
        x.d("MicroMsg.QrRewardSelectMoneyUI", "callback succ");
        QrRewardSelectMoneyUI.a(this.lkR, this.lkS.ljx.vUo);
        QrRewardSelectMoneyUI.b(this.lkR, this.lkS.ljx.pKT);
        QrRewardSelectMoneyUI.a(this.lkR, this.lkS.ljx.vUa);
        QrRewardSelectMoneyUI.c(this.lkR, this.lkS.ljx.vUl);
        QrRewardSelectMoneyUI.d(this.lkR, this.lkS.ljx.desc);
        QrRewardSelectMoneyUI.e(this.lkR, this.lkS.ljx.vUt);
        QrRewardSelectMoneyUI.f(this.lkR, this.lkS.ljx.vUu);
        QrRewardSelectMoneyUI.g(this.lkR, this.lkS.ljx.vUr);
        QrRewardSelectMoneyUI.h(this.lkR, this.lkS.ljx.vUw);
        QrRewardSelectMoneyUI.a(this.lkR, this.lkS.ljx.vTY);
        if (QrRewardSelectMoneyUI.a(this.lkR) == null) {
            x.i("MicroMsg.QrRewardSelectMoneyUI", "amt_list is null");
            QrRewardSelectMoneyUI.a(this.lkR, new LinkedList());
        }
        QrRewardSelectMoneyUI.b(this.lkR);
    }
}
