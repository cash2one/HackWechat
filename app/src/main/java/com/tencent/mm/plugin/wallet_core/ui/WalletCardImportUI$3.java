package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletCardImportUI$3 implements OnClickListener {
    final /* synthetic */ WalletCardImportUI sSH;

    WalletCardImportUI$3(WalletCardImportUI walletCardImportUI) {
        this.sSH = walletCardImportUI;
    }

    public final void onClick(View view) {
        this.sSH.showDialog(1);
    }
}
