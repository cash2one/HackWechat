package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class WalletOrderInfoNewUI$2 implements OnClickListener {
    final /* synthetic */ WalletOrderInfoNewUI sUp;

    WalletOrderInfoNewUI$2(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        this.sUp = walletOrderInfoNewUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletOrderInfoNewUI", "click activity button");
        WalletOrderInfoNewUI.p(this.sUp);
    }
}
