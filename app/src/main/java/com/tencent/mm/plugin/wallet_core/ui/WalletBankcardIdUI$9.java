package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.EditText;

class WalletBankcardIdUI$9 implements OnClickListener {
    final /* synthetic */ WalletBankcardIdUI sRo;

    WalletBankcardIdUI$9(WalletBankcardIdUI walletBankcardIdUI) {
        this.sRo = walletBankcardIdUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        View findFocus = WalletBankcardIdUI.d(this.sRo) == null ? null : WalletBankcardIdUI.e(this.sRo).findFocus();
        if (findFocus != null && (findFocus instanceof EditText)) {
            this.sRo.showVKB();
        }
    }
}
