package com.tencent.mm.plugin.wxcredit.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletWXCreditChangeAmountUI$10 implements OnClickListener {
    final /* synthetic */ WalletWXCreditChangeAmountUI tZW;

    WalletWXCreditChangeAmountUI$10(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        this.tZW = walletWXCreditChangeAmountUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.tZW.showVKB();
    }
}
