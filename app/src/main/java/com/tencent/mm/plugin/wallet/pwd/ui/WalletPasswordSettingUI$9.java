package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WalletPasswordSettingUI$9 implements OnCancelListener {
    final /* synthetic */ WalletPasswordSettingUI sHq;

    WalletPasswordSettingUI$9(WalletPasswordSettingUI walletPasswordSettingUI) {
        this.sHq = walletPasswordSettingUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (WalletPasswordSettingUI.g(this.sHq) != null) {
            WalletPasswordSettingUI.g(this.sHq).dismiss();
        }
    }
}
