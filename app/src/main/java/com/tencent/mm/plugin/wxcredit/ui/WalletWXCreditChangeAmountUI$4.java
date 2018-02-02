package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletWXCreditChangeAmountUI$4 implements OnClickListener {
    final /* synthetic */ WalletWXCreditChangeAmountUI tZW;

    WalletWXCreditChangeAmountUI$4(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        this.tZW = walletWXCreditChangeAmountUI;
    }

    public final void onClick(View view) {
        WalletWXCreditChangeAmountUI.a(this.tZW, false);
        WalletWXCreditChangeAmountUI.a(this.tZW);
        this.tZW.showDialog(1);
    }
}
