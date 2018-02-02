package com.tencent.mm.plugin.wallet_core.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class a$1 implements OnClickListener {
    final /* synthetic */ WalletBaseUI sEm;
    final /* synthetic */ a sIe;

    a$1(a aVar, WalletBaseUI walletBaseUI) {
        this.sIe = aVar;
        this.sEm = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.sIe.b(this.sEm, this.sIe.msB);
        if (this.sEm.aYf()) {
            this.sEm.finish();
        }
        WalletBaseUI.cCa();
    }
}
