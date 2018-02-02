package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletWXCreditChangeAmountUI$1 implements OnClickListener {
    final /* synthetic */ WalletWXCreditChangeAmountUI tZW;

    WalletWXCreditChangeAmountUI$1(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        this.tZW = walletWXCreditChangeAmountUI;
    }

    public final void onClick(View view) {
        WalletWXCreditChangeAmountUI.a(this.tZW, true);
        WalletWXCreditChangeAmountUI.a(this.tZW);
        this.tZW.showDialog(1);
    }
}
