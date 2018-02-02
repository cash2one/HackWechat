package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.widget.Toast;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.4;
import com.tencent.mm.plugin.wxpay.a.i;

class WalletLqtDetailUI$4$1 implements Runnable {
    final /* synthetic */ 4 sAP;

    WalletLqtDetailUI$4$1(4 4) {
        this.sAP = 4;
    }

    public final void run() {
        if (WalletLqtDetailUI.a(this.sAP.sAM) != null) {
            WalletLqtDetailUI.a(this.sAP.sAM).dismiss();
        }
        Toast.makeText(this.sAP.sAM, this.sAP.sAM.getString(i.uSr), 1).show();
        this.sAP.sAM.finish();
    }
}
