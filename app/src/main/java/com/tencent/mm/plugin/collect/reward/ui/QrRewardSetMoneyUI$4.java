package com.tencent.mm.plugin.collect.reward.ui;

import android.content.Intent;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.collect.reward.a.a$a;
import com.tencent.mm.plugin.collect.reward.a.g;

class QrRewardSetMoneyUI$4 implements a$a {
    final /* synthetic */ QrRewardSetMoneyUI llg;
    final /* synthetic */ g llh;

    QrRewardSetMoneyUI$4(QrRewardSetMoneyUI qrRewardSetMoneyUI, g gVar) {
        this.llg = qrRewardSetMoneyUI;
        this.llh = gVar;
    }

    public final void i(k kVar) {
        QrRewardSetMoneyUI.a(this.llg, this.llh.ljy.pKb);
        QrRewardSetMoneyUI.b(this.llg, this.llh.ljy.desc);
        Intent intent = new Intent();
        intent.putExtra("key_desc", this.llh.ljy.desc);
        intent.putExtra("key_photo_url", this.llh.ljy.pKb);
        intent.putExtra("key_photo_aeskey", this.llh.ljy.vTW);
        intent.putExtra("key_photo_width", this.llh.ljy.vUb);
        intent.putExtra("key_icon_width", this.llh.ljy.vTX);
        intent.putExtra("key_return_from_first", QrRewardSetMoneyUI.c(this.llg));
        this.llg.setResult(-1, intent);
        this.llg.finish();
    }
}
