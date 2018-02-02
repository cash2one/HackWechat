package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletLqtCheckPwdInputDialogUI$1 implements OnClickListener {
    final /* synthetic */ WalletLqtCheckPwdInputDialogUI sAp;

    WalletLqtCheckPwdInputDialogUI$1(WalletLqtCheckPwdInputDialogUI walletLqtCheckPwdInputDialogUI) {
        this.sAp = walletLqtCheckPwdInputDialogUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.sAp.finish();
    }
}
