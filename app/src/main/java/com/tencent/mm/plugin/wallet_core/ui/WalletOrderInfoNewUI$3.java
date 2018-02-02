package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class WalletOrderInfoNewUI$3 implements OnClickListener {
    final /* synthetic */ WalletOrderInfoNewUI sUp;

    WalletOrderInfoNewUI$3(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        this.sUp = walletOrderInfoNewUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletOrderInfoNewUI", "click activity layout");
        WalletOrderInfoNewUI.p(this.sUp);
    }
}
