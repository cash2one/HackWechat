package com.tencent.mm.plugin.wxcredit.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;

class WalletWXCreditChangeAmountUI$3 implements OnClickListener {
    final /* synthetic */ WalletWXCreditChangeAmountUI tZW;

    WalletWXCreditChangeAmountUI$3(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        this.tZW = walletWXCreditChangeAmountUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c ag = a.ag(this.tZW);
        if (ag != null) {
            ag.b(this.tZW, this.tZW.vf);
        } else {
            this.tZW.finish();
        }
    }
}
