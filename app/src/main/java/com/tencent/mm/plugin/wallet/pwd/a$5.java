package com.tencent.mm.plugin.wallet.pwd;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class a$5 implements OnClickListener {
    final /* synthetic */ WalletBaseUI sEm;
    final /* synthetic */ a sGp;

    a$5(a aVar, WalletBaseUI walletBaseUI) {
        this.sGp = aVar;
        this.sEm = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.sGp.b(this.sEm, a.f(this.sGp));
        if (this.sEm.aYf()) {
            this.sEm.finish();
        }
        WalletBaseUI.cCa();
    }
}
