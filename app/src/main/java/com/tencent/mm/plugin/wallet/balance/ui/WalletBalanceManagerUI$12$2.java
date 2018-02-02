package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.12;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.wallet_core.ui.e;

class WalletBalanceManagerUI$12$2 implements d {
    final /* synthetic */ 12 szY;

    WalletBalanceManagerUI$12$2(12 12) {
        this.szY = 12;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        a aVar = (a) this.szY.nbC.get(menuItem.getItemId());
        if (aVar.szZ == 1) {
            e.l(this.szY.szV.mController.xIM, aVar.sAa, false);
        } else if (aVar.szZ == 2) {
            b qpVar = new qp();
            qpVar.fIi.userName = aVar.sAb;
            qpVar.fIi.fIk = bh.az(aVar.sAc, "");
            qpVar.fIi.scene = 1061;
            qpVar.fIi.fIl = 0;
            com.tencent.mm.sdk.b.a.xef.m(qpVar);
        } else if (aVar.szZ == 7) {
            Intent intent = new Intent();
            com.tencent.mm.bm.d.y(this.szY.szV.mController.xIM, "wallet_ecard", ".ui.WalletECardLogoutUI");
        }
    }
}
