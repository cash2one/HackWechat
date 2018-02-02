package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.ex;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;

class WalletLqtSaveFetchUI$6 implements OnClickListener {
    final /* synthetic */ WalletLqtSaveFetchUI sBv;

    WalletLqtSaveFetchUI$6(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        this.sBv = walletLqtSaveFetchUI;
    }

    public final void onClick(View view) {
        if (bh.bA(WalletLqtSaveFetchUI.o(this.sBv)) < 800) {
            x.d("MicroMsg.WalletLqtSaveFetchUI", "saveButton click too soon");
            WalletLqtSaveFetchUI.a(this.sBv, bh.Wq());
            return;
        }
        WalletLqtSaveFetchUI.a(this.sBv, bh.Wq());
        int ez = WalletLqtSaveFetchUI.ez(WalletLqtSaveFetchUI.c(this.sBv).getText(), "100");
        if (ez <= 0) {
            return;
        }
        if (WalletLqtSaveFetchUI.e(this.sBv) == 1) {
            x.i("MicroMsg.WalletLqtSaveFetchUI", "click save lqt");
            a aVar = WalletLqtSaveFetchUI.q(this.sBv).syZ;
            int p = WalletLqtSaveFetchUI.p(this.sBv);
            g.a(Integer.valueOf(ez), Integer.valueOf(p), WalletLqtSaveFetchUI.j(this.sBv)).b(aVar).e(new 2(this, ez)).a(new 1(this));
        } else if (WalletLqtSaveFetchUI.e(this.sBv) == 2) {
            x.i("MicroMsg.WalletLqtSaveFetchUI", "click fetch lqt");
            Object obj = null;
            if (!(WalletLqtSaveFetchUI.j(this.sBv) == null || WalletLqtSaveFetchUI.j(this.sBv).bKP())) {
                obj = new ex();
                obj.nBM = WalletLqtSaveFetchUI.j(this.sBv).field_bankName;
                obj.oZz = WalletLqtSaveFetchUI.j(this.sBv).field_bankcardType;
                obj.vKH = WalletLqtSaveFetchUI.j(this.sBv).field_bindSerial;
                obj.pay = WalletLqtSaveFetchUI.j(this.sBv).field_bankcardTail;
            }
            g.a(Integer.valueOf(ez), Integer.valueOf(WalletLqtSaveFetchUI.p(this.sBv)), obj).b(WalletLqtSaveFetchUI.q(this.sBv).sza).e(new 4(this, ez)).a(new 3(this));
        }
    }
}
