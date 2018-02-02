package com.tencent.mm.plugin.wallet.balance;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.pay.a.e.f;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class b$6 extends e {
    final /* synthetic */ b syb;

    b$6(b bVar, MMActivity mMActivity, g gVar) {
        this.syb = bVar;
        super(mMActivity, gVar);
    }

    public final /* synthetic */ CharSequence um(int i) {
        return this.zHU.getString(i.uWO);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0 || !(kVar instanceof f)) {
            return false;
        }
        f fVar = (f) kVar;
        if (fVar.sFA) {
            b.E(this.syb).putParcelable("key_orders", fVar.sEs);
        }
        this.syb.a(this.zHU, 0, b.F(this.syb));
        return true;
    }

    public final boolean k(Object... objArr) {
        this.zHV.a(new f((p) objArr[0], (Orders) b.G(this.syb).getParcelable("key_orders")), true, 1);
        return true;
    }
}
