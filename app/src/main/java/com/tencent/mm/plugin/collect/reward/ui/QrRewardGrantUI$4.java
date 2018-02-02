package com.tencent.mm.plugin.collect.reward.ui;

import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.collect.reward.a.a$a;
import com.tencent.mm.plugin.collect.reward.a.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class QrRewardGrantUI$4 implements a$a {
    final /* synthetic */ QrRewardGrantUI lkb;
    final /* synthetic */ e lkc;

    QrRewardGrantUI$4(QrRewardGrantUI qrRewardGrantUI, e eVar) {
        this.lkb = qrRewardGrantUI;
        this.lkc = eVar;
    }

    public final void i(k kVar) {
        x.e("MicroMsg.QrRewardGrantUI", "place order error: %s, %s", new Object[]{Integer.valueOf(this.lkc.ljw.liH), this.lkc.ljw.liI});
        if (!bh.ov(this.lkc.ljw.liI)) {
            Toast.makeText(this.lkb, this.lkc.ljw.liI, 0).show();
        }
    }
}
