package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bh;

class WalletOrderInfoNewUI$17 implements OnClickListener {
    final /* synthetic */ WalletOrderInfoNewUI sUp;

    WalletOrderInfoNewUI$17(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        this.sUp = walletOrderInfoNewUI;
    }

    public final void onClick(View view) {
        if (!bh.ov(WalletOrderInfoNewUI.j(this.sUp))) {
            if (this.sUp.sTU.contains(WalletOrderInfoNewUI.j(this.sUp))) {
                this.sUp.sTU.remove(WalletOrderInfoNewUI.j(this.sUp));
                WalletOrderInfoNewUI.k(this.sUp).setChecked(false);
                return;
            }
            this.sUp.sTU.add(WalletOrderInfoNewUI.j(this.sUp));
            WalletOrderInfoNewUI.k(this.sUp).setChecked(true);
        }
    }
}
