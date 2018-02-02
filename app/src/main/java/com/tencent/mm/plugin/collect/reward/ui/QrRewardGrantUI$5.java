package com.tencent.mm.plugin.collect.reward.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.collect.reward.a.a$a;
import com.tencent.mm.plugin.collect.reward.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class QrRewardGrantUI$5 implements a$a {
    final /* synthetic */ QrRewardGrantUI lkb;
    final /* synthetic */ e lkc;

    QrRewardGrantUI$5(QrRewardGrantUI qrRewardGrantUI, e eVar) {
        this.lkb = qrRewardGrantUI;
        this.lkc = eVar;
    }

    public final void i(k kVar) {
        QrRewardGrantUI.a(this.lkb, this.lkc.ljw.fwY);
        QrRewardGrantUI.b(this.lkb, this.lkc.ljw.vUn);
        QrRewardGrantUI.c(this.lkb, this.lkc.ljw.vHr);
        QrRewardGrantUI.d(this.lkb, this.lkc.ljw.vUl);
        QrRewardGrantUI.e(this.lkb, this.lkc.ljw.vUk);
        x.i("MicroMsg.QrRewardGrantUI", "remind str: %s", new Object[]{this.lkc.ljw.vUv});
        if (bh.ov(this.lkc.ljw.vUv)) {
            QrRewardGrantUI.c(this.lkb);
        } else {
            h.a(this.lkb.mController.xIM, this.lkc.ljw.vUv, "", this.lkb.getString(i.uNf), this.lkb.getString(i.dEn), new 1(this), new OnClickListener(this) {
                final /* synthetic */ QrRewardGrantUI$5 lkd;

                {
                    this.lkd = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }
}
