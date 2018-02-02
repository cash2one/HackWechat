package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.rf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p$c;
import com.tencent.mm.ui.widget.g;
import java.util.Iterator;

class WalletLqtDetailUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ WalletLqtDetailUI sAM;

    WalletLqtDetailUI$2(WalletLqtDetailUI walletLqtDetailUI) {
        this.sAM = walletLqtDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g gVar = new g(this.sAM, g.ztp, false);
        gVar.rKC = new p$c(this) {
            final /* synthetic */ WalletLqtDetailUI$2 sAN;

            {
                this.sAN = r1;
            }

            public final void a(n nVar) {
                if (WalletLqtDetailUI.c(this.sAN.sAM).wGJ != null && WalletLqtDetailUI.c(this.sAN.sAM).wGJ.size() > 0) {
                    Iterator it = WalletLqtDetailUI.c(this.sAN.sAM).wGJ.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        rf rfVar = (rf) it.next();
                        if (!(bh.ov(rfVar.title) || bh.ov(rfVar.vZl))) {
                            nVar.add(0, i, 0, rfVar.title);
                        }
                        i++;
                    }
                }
                if (!WalletLqtDetailUI.c(this.sAN.sAM).wGQ) {
                    nVar.add(0, -1, 0, i.uSq);
                }
            }
        };
        gVar.rKD = new 2(this);
        gVar.bUk();
        return false;
    }
}
