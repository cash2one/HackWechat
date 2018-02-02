package com.tencent.mm.plugin.wallet.pay;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$7 implements OnClickListener {
    final /* synthetic */ b sEl;
    final /* synthetic */ WalletBaseUI sEm;

    b$7(b bVar, WalletBaseUI walletBaseUI) {
        this.sEl = bVar;
        this.sEm = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.sEl.b(this.sEm, b.B(this.sEl));
        if (this.sEm.aYf()) {
            this.sEm.finish();
        }
    }
}
