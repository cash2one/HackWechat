package com.tencent.mm.plugin.offline.ui;

import android.widget.TextView;
import com.tencent.mm.g.a.st;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class WalletOfflineCoinPurseUI$4 implements Runnable {
    final /* synthetic */ st lni;
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;

    WalletOfflineCoinPurseUI$4(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, st stVar) {
        this.oYH = walletOfflineCoinPurseUI;
        this.lni = stVar;
    }

    public final void run() {
        if (bh.ov(this.lni.fKB.fKD)) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "no bulletin data");
        } else {
            e.a((TextView) this.oYH.findViewById(f.ufy), this.lni.fKB.fKD, this.lni.fKB.content, this.lni.fKB.url);
        }
    }
}
