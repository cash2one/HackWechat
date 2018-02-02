package com.tencent.mm.plugin.collect.reward.ui;

import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class QrRewardMainUI$15 implements a {
    final /* synthetic */ QrRewardMainUI lkA;
    final /* synthetic */ b lkF;

    QrRewardMainUI$15(QrRewardMainUI qrRewardMainUI, b bVar) {
        this.lkA = qrRewardMainUI;
        this.lkF = bVar;
    }

    public final void i(k kVar) {
        x.e("MicroMsg.QrRewardMainUI", "get code error: %s, %s", Integer.valueOf(this.lkF.ljs.liH), this.lkF.ljs.liI);
        if (!bh.ov(this.lkF.ljs.liI)) {
            Toast.makeText(this.lkA, this.lkF.ljs.liI, 0).show();
        }
        if (!this.lkF.ljt) {
            QrRewardMainUI.a(this.lkA, false);
        }
    }
}
