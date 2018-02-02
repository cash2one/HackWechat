package com.tencent.mm.plugin.wallet_ecard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class WalletECardElementInputUI$2 implements OnClickListener {
    final /* synthetic */ WalletECardElementInputUI sZQ;

    WalletECardElementInputUI$2(WalletECardElementInputUI walletECardElementInputUI) {
        this.sZQ = walletECardElementInputUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletECardElementInputUI", "goto next: %s", new Object[]{WalletECardElementInputUI.b(this.sZQ).oZz});
        this.sZQ.cCd().k(new Object[]{WalletECardElementInputUI.b(this.sZQ)});
    }
}
