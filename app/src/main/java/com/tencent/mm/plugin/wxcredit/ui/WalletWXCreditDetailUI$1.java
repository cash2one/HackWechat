package com.tencent.mm.plugin.wxcredit.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wxcredit.a.i;

class WalletWXCreditDetailUI$1 implements OnClickListener {
    final /* synthetic */ WalletWXCreditDetailUI uad;

    WalletWXCreditDetailUI$1(WalletWXCreditDetailUI walletWXCreditDetailUI) {
        this.uad = walletWXCreditDetailUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.uad.cCh().a(new i(WalletWXCreditDetailUI.a(this.uad).field_bankcardType, WalletWXCreditDetailUI.a(this.uad).sLa), true, 1);
    }
}
