package com.tencent.mm.plugin.address.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class WalletAddAddressUI$6 implements OnClickListener {
    final /* synthetic */ WalletAddAddressUI inY;

    WalletAddAddressUI$6(WalletAddAddressUI walletAddAddressUI) {
        this.inY = walletAddAddressUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.inY.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
