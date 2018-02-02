package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.11;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;
import java.util.List;

class WalletBalanceFetchUI$11$1 implements d {
    final /* synthetic */ List szL;
    final /* synthetic */ 11 szM;

    WalletBalanceFetchUI$11$1(11 11, List list) {
        this.szM = 11;
        this.szL = list;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (i < this.szL.size()) {
            WalletBalanceFetchUI.a(this.szM.szH, (Bankcard) this.szL.get(i));
            x.i("MicroMsg.WalletBalanceFetchUI", "bankcard: %s", new Object[]{WalletBalanceFetchUI.c(this.szM.szH).field_desc});
        } else {
            x.i("MicroMsg.WalletBalanceFetchUI", "add new card");
            WalletBalanceFetchUI.a(this.szM.szH, null);
            WalletBalanceFetchUI.d(this.szM.szH);
        }
        WalletBalanceFetchUI.a(this.szM.szH);
    }
}
