package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class WalletPayUI$5 implements OnClickListener {
    final /* synthetic */ WalletPayUI sGh;

    WalletPayUI$5(WalletPayUI walletPayUI) {
        this.sGh = walletPayUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.WalletPayUI", "click cancel pay");
        this.sGh.finish();
    }
}
