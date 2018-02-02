package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.a.a;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;

class WalletLqtSaveFetchUI$4 implements a {
    final /* synthetic */ WalletLqtSaveFetchUI sBv;
    final /* synthetic */ ArrayList sBw;

    WalletLqtSaveFetchUI$4(WalletLqtSaveFetchUI walletLqtSaveFetchUI, ArrayList arrayList) {
        this.sBv = walletLqtSaveFetchUI;
        this.sBw = arrayList;
    }

    public final void WO() {
        g gVar = new g(this.sBv, g.ztp, false);
        gVar.rKC = new c(this) {
            final /* synthetic */ WalletLqtSaveFetchUI$4 sBx;

            {
                this.sBx = r1;
            }

            public final void a(n nVar) {
                Iterator it = this.sBx.sBw.iterator();
                int i = 0;
                while (it.hasNext()) {
                    nVar.add(0, i, 0, ((String) it.next()).split("\\|\\|")[0]);
                    i++;
                }
            }
        };
        gVar.rKD = new d(this) {
            final /* synthetic */ WalletLqtSaveFetchUI$4 sBx;

            {
                this.sBx = r1;
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                int itemId = menuItem.getItemId();
                if (itemId < this.sBx.sBw.size()) {
                    e.l(this.sBx.sBv, ((String) this.sBx.sBw.get(itemId)).split("\\|\\|")[1], false);
                }
            }
        };
        gVar.bUk();
    }
}
