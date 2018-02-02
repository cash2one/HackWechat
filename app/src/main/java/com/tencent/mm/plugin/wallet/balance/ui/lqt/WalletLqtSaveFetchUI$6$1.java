package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.6;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.a;

class WalletLqtSaveFetchUI$6$1 implements a {
    final /* synthetic */ 6 sBy;

    WalletLqtSaveFetchUI$6$1(6 6) {
        this.sBy = 6;
    }

    public final void aW(Object obj) {
        x.i("MicroMsg.WalletLqtSaveFetchUI", "save failed: %s", obj);
        this.sBy.sBv.bJB();
        if (obj != null) {
            String obj2;
            if (obj instanceof String) {
                obj2 = obj.toString();
            } else {
                obj2 = this.sBy.sBv.getString(i.uSN);
            }
            this.sBy.sBv.Ib(obj2);
        }
    }
}
