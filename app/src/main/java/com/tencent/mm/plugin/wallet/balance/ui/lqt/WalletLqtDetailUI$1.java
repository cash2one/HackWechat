package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.a;

class WalletLqtDetailUI$1 implements a {
    final /* synthetic */ WalletLqtDetailUI sAM;

    WalletLqtDetailUI$1(WalletLqtDetailUI walletLqtDetailUI) {
        this.sAM = walletLqtDetailUI;
    }

    public final void aW(Object obj) {
        if (WalletLqtDetailUI.a(this.sAM) != null) {
            WalletLqtDetailUI.a(this.sAM).dismiss();
        }
        x.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed: %s", new Object[]{obj});
        if (obj != null) {
            CharSequence obj2;
            if (obj instanceof String) {
                obj2 = obj.toString();
            } else {
                obj2 = this.sAM.getString(i.uSN);
            }
            Toast.makeText(this.sAM, obj2, 1).show();
        }
    }
}
