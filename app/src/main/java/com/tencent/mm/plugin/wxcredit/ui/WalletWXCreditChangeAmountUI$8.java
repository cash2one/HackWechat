package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class WalletWXCreditChangeAmountUI$8 implements OnItemClickListener {
    final /* synthetic */ WalletWXCreditChangeAmountUI tZW;

    WalletWXCreditChangeAmountUI$8(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        this.tZW = walletWXCreditChangeAmountUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.tZW.dismissDialog(2);
        if (WalletWXCreditChangeAmountUI.l(this.tZW)) {
            if (i == 0) {
                WalletWXCreditChangeAmountUI.c(this.tZW).ocF = "Y";
            } else {
                WalletWXCreditChangeAmountUI.c(this.tZW).ocF = "N";
            }
        } else if (i == 0) {
            WalletWXCreditChangeAmountUI.f(this.tZW).ocF = "Y";
        } else {
            WalletWXCreditChangeAmountUI.f(this.tZW).ocF = "N";
        }
        WalletWXCreditChangeAmountUI.k(this.tZW);
    }
}
