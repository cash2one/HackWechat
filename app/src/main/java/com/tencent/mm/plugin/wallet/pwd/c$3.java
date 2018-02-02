package com.tencent.mm.plugin.wallet.pwd;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class c$3 implements OnClickListener {
    final /* synthetic */ WalletBaseUI sEm;
    final /* synthetic */ c sGs;

    c$3(c cVar, WalletBaseUI walletBaseUI) {
        this.sGs = cVar;
        this.sEm = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.sGs.b(this.sEm, c.f(this.sGs));
        if (this.sEm.aYf()) {
            this.sEm.finish();
        }
        WalletBaseUI.cCa();
    }
}
