package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.pay.a.a;
import com.tencent.mm.plugin.wallet.pay.a.a.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class WalletResetInfoUI$1 implements OnClickListener {
    final /* synthetic */ WalletResetInfoUI sDa;

    WalletResetInfoUI$1(WalletResetInfoUI walletResetInfoUI) {
        this.sDa = walletResetInfoUI;
    }

    public final void onClick(View view) {
        if (WalletResetInfoUI.a(this.sDa)) {
            if (WalletResetInfoUI.b(this.sDa).getVisibility() == 0) {
                WalletResetInfoUI.c(this.sDa).sKx = WalletResetInfoUI.b(this.sDa).getText();
            }
            if (WalletResetInfoUI.d(this.sDa).getVisibility() == 0) {
                WalletResetInfoUI.c(this.sDa).sKy = bh.az(WalletResetInfoUI.d(this.sDa).getText(), "");
            }
            if (WalletResetInfoUI.e(this.sDa).getVisibility() == 0) {
                WalletResetInfoUI.c(this.sDa).sIF = bh.az(WalletResetInfoUI.e(this.sDa).getText(), "");
                this.sDa.vf.putString("key_mobile", e.aaB(WalletResetInfoUI.c(this.sDa).sIF));
            }
            x.d("Micromsg.WalletResetInfoUI", "tft: bank_type: %s, bank_serial: %s", new Object[]{WalletResetInfoUI.c(this.sDa).oZz, WalletResetInfoUI.c(this.sDa).oZA});
            WalletResetInfoUI.c(this.sDa).sKr = 1;
            if (this.sDa.vf.getBoolean("key_is_changing_balance_phone_num", false)) {
                this.sDa.l(new c(WalletResetInfoUI.c(this.sDa), WalletResetInfoUI.f(this.sDa), this.sDa.vf.getBoolean("key_isbalance", false)));
                return;
            }
            k a = a.a(WalletResetInfoUI.c(this.sDa), WalletResetInfoUI.f(this.sDa), false);
            if (a != null) {
                this.sDa.l(a);
                return;
            }
            return;
        }
        x.w("Micromsg.WalletResetInfoUI", "input format illegal!");
    }
}
