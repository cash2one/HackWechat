package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.wallet_core.c.p;
import com.tencent.mm.plugin.wallet_core.model.x;

class WalletSwitchWalletCurrencyUI$1 implements OnItemClickListener {
    final /* synthetic */ WalletSwitchWalletCurrencyUI sWC;

    WalletSwitchWalletCurrencyUI$1(WalletSwitchWalletCurrencyUI walletSwitchWalletCurrencyUI) {
        this.sWC = walletSwitchWalletCurrencyUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x zt = WalletSwitchWalletCurrencyUI.a(this.sWC).zt(i);
        WalletSwitchWalletCurrencyUI.a(this.sWC, WalletSwitchWalletCurrencyUI.a(this.sWC).sWD);
        if (zt == null) {
            return;
        }
        if (WalletSwitchWalletCurrencyUI.b(this.sWC) == null || !WalletSwitchWalletCurrencyUI.b(this.sWC).field_wallet_tpa_country.equals(zt.field_wallet_tpa_country)) {
            WalletSwitchWalletCurrencyUI.b(this.sWC, zt);
            WalletSwitchWalletCurrencyUI walletSwitchWalletCurrencyUI = this.sWC;
            String str = zt.field_wallet_tpa_country;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doSetUserWallet walletid = " + str);
            walletSwitchWalletCurrencyUI.r(new p(str));
        }
    }
}
