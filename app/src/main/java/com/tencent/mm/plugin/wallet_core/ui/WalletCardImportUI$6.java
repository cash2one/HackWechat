package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class WalletCardImportUI$6 implements OnClickListener {
    final /* synthetic */ WalletCardImportUI sSH;

    WalletCardImportUI$6(WalletCardImportUI walletCardImportUI) {
        this.sSH = walletCardImportUI;
    }

    public final void onClick(View view) {
        this.sSH.startActivityForResult(new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true), 2);
    }
}
