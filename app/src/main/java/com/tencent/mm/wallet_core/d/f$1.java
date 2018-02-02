package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class f$1 implements OnClickListener {
    final /* synthetic */ WalletBaseUI sEm;

    f$1(WalletBaseUI walletBaseUI) {
        this.sEm = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.sEm.aYf()) {
            this.sEm.finish();
        }
    }
}
