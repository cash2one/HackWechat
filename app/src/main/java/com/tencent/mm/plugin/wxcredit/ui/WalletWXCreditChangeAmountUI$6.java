package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxcredit.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.u;
import java.util.ArrayList;
import java.util.List;

class WalletWXCreditChangeAmountUI$6 implements OnClickListener {
    final /* synthetic */ WalletWXCreditChangeAmountUI tZW;

    WalletWXCreditChangeAmountUI$6(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        this.tZW = walletWXCreditChangeAmountUI;
    }

    public final void onClick(View view) {
        if (WalletWXCreditChangeAmountUI.b(this.tZW)) {
            if (WalletWXCreditChangeAmountUI.c(this.tZW).tZx == null) {
                WalletWXCreditChangeAmountUI.c(this.tZW).ocF = WalletWXCreditChangeAmountUI.e(this.tZW).getText().toString();
            } else if (WalletWXCreditChangeAmountUI.d(this.tZW).getVisibility() == 0) {
                WalletWXCreditChangeAmountUI.c(this.tZW).tZx.ocF = WalletWXCreditChangeAmountUI.d(this.tZW).getText().toString();
            }
            if (WalletWXCreditChangeAmountUI.f(this.tZW).tZx == null) {
                WalletWXCreditChangeAmountUI.f(this.tZW).ocF = WalletWXCreditChangeAmountUI.h(this.tZW).getText().toString();
            } else if (WalletWXCreditChangeAmountUI.g(this.tZW).getVisibility() == 0) {
                WalletWXCreditChangeAmountUI.f(this.tZW).tZx.ocF = WalletWXCreditChangeAmountUI.g(this.tZW).getText().toString();
            }
            List arrayList = new ArrayList();
            arrayList.add(WalletWXCreditChangeAmountUI.c(this.tZW));
            arrayList.add(WalletWXCreditChangeAmountUI.f(this.tZW));
            String string = this.tZW.vf.getString("kreq_token");
            this.tZW.vf.getString("key_bank_type");
            this.tZW.r(new c(arrayList, string));
            return;
        }
        u.makeText(this.tZW.mController.xIM, i.uYf, 0).show();
    }
}
