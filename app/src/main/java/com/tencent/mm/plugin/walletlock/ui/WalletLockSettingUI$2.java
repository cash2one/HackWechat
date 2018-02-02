package com.tencent.mm.plugin.walletlock.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletLockSettingUI$2 implements OnClickListener {
    final /* synthetic */ WalletLockSettingUI thE;

    WalletLockSettingUI$2(WalletLockSettingUI walletLockSettingUI) {
        this.thE = walletLockSettingUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        WalletLockSettingUI.b(this.thE);
    }
}
