package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.17;
import com.tencent.mm.plugin.wallet_core.model.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.wallet_core.ui.e;

class WalletBalanceFetchUI$17$2 implements d {
    final /* synthetic */ 17 szO;

    WalletBalanceFetchUI$17$2(17 17) {
        this.szO = 17;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int itemId = menuItem.getItemId();
        if (this.szO.szN.sKN.sKP != null && itemId < this.szO.szN.sKN.sKP.length) {
            c cVar = this.szO.szN.sKN.sKP[itemId];
            x.i("MicroMsg.WalletBalanceFetchUI", "jump type: %s, url: %s", new Object[]{Integer.valueOf(cVar.szZ), cVar.kLB});
            switch (cVar.szZ) {
                case 1:
                    e.l(this.szO.szH.mController.xIM, cVar.kLB, true);
                    return;
                default:
                    return;
            }
        }
    }
}
