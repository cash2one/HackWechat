package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class e$2 extends e {
    final /* synthetic */ e tcT;

    e$2(e eVar, MMActivity mMActivity, g gVar) {
        this.tcT = eVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
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
