package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.g;
import java.util.List;

class WalletLqtSaveFetchUI$12 implements d {
    final /* synthetic */ g nal;
    final /* synthetic */ List oYY;
    final /* synthetic */ WalletLqtSaveFetchUI sBv;

    WalletLqtSaveFetchUI$12(WalletLqtSaveFetchUI walletLqtSaveFetchUI, g gVar, List list) {
        this.sBv = walletLqtSaveFetchUI;
        this.nal = gVar;
        this.oYY = list;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (this.nal != null) {
            this.nal.bxh();
            if (i < this.oYY.size()) {
                WalletLqtSaveFetchUI.a(this.sBv, ((Bankcard) this.oYY.get(i)).field_bindSerial);
                WalletLqtSaveFetchUI.f(this.sBv);
            } else if (WalletLqtSaveFetchUI.e(this.sBv) == 1) {
                WalletLqtSaveFetchUI.g(this.sBv);
            } else if (WalletLqtSaveFetchUI.e(this.sBv) == 2) {
                WalletLqtSaveFetchUI.g(this.sBv);
            }
        }
    }
}
