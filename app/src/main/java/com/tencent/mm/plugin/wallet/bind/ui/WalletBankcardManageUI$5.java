package com.tencent.mm.plugin.wallet.bind.ui;

import android.widget.TextView;
import com.tencent.mm.g.a.st;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class WalletBankcardManageUI$5 implements Runnable {
    final /* synthetic */ st lni;
    final /* synthetic */ WalletBankcardManageUI sCF;

    WalletBankcardManageUI$5(WalletBankcardManageUI walletBankcardManageUI, st stVar) {
        this.sCF = walletBankcardManageUI;
        this.lni = stVar;
    }

    public final void run() {
        if (bh.ov(this.lni.fKB.fKD)) {
            x.i("MicroMsg.WalletBankcardManageUI", "no bulletin data");
        } else {
            e.a((TextView) this.sCF.findViewById(f.ufy), this.lni.fKB.fKD, this.lni.fKB.content, this.lni.fKB.url);
        }
    }
}
