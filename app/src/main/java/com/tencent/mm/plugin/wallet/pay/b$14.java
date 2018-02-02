package com.tencent.mm.plugin.wallet.pay;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pay.b.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$14 extends a {
    final /* synthetic */ b sEl;

    b$14(b bVar, WalletBaseUI walletBaseUI, g gVar) {
        this.sEl = bVar;
        super(bVar, walletBaseUI, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (super.d(i, i2, str, kVar)) {
            return true;
        }
        return false;
    }

    public final boolean k(Object... objArr) {
        Orders orders = (Orders) objArr[0];
        p.bJN();
        Bankcard bankcard = p.bJO().szU;
        bankcard.sLf += orders.pNX;
        return false;
    }

    public final CharSequence um(int i) {
        switch (i) {
            case 0:
                return this.zHU.getString(i.uPt);
            case 1:
                return this.zHU.getString(i.uPs);
            default:
                return super.um(i);
        }
    }
}
