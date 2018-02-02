package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet_core.id_verify.a;

class WalletBankcardIdUI$8 implements OnClickListener {
    final /* synthetic */ WalletBankcardIdUI sRo;

    WalletBankcardIdUI$8(WalletBankcardIdUI walletBankcardIdUI) {
        this.sRo = walletBankcardIdUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ((a) this.sRo.cCc()).d(this.sRo, 0);
        this.sRo.finish();
    }
}
