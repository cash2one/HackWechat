package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.EditText;

class WalletBaseUI$5 implements OnClickListener {
    final /* synthetic */ WalletBaseUI zJd;

    WalletBaseUI$5(WalletBaseUI walletBaseUI) {
        this.zJd = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        View findFocus = WalletBaseUI.a(this.zJd) == null ? null : WalletBaseUI.b(this.zJd).findFocus();
        if (findFocus != null && (findFocus instanceof EditText)) {
            this.zJd.showVKB();
        }
    }
}
