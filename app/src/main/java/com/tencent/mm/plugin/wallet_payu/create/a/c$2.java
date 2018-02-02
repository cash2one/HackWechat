package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_payu.a.a;
import com.tencent.mm.plugin.wallet_payu.a.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class c$2 extends e {
    final /* synthetic */ c tca;

    c$2(c cVar, MMActivity mMActivity, g gVar) {
        this.tca = cVar;
        super(mMActivity, gVar);
    }

    public final boolean q(Object... objArr) {
        this.zHV.a(new b(this.tca.msB.getString("dial_code"), this.tca.msB.getString("key_mobile")), true, 1);
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof a) {
            a aVar = (a) kVar;
            if (i == 0 && i2 == 0 && aVar.qjU) {
                c.a(this.tca).putString("payu_reference", aVar.tcs);
                com.tencent.mm.wallet_core.a.j(this.zHU, this.tca.msB);
                return true;
            }
        } else if ((kVar instanceof b) && i == 0 && i2 == 0) {
            this.tca.msB.putString("payu_reference", ((b) kVar).fzP);
            return true;
        }
        return false;
    }

    public final boolean k(Object... objArr) {
        this.zHV.a(new a((String) objArr[0], this.tca.msB.getString("payu_reference")), true);
        return true;
    }

    public final CharSequence um(int i) {
        if (i != 0) {
            return super.um(i);
        }
        return this.zHU.getString(i.uXd, new Object[]{com.tencent.mm.wallet_core.ui.e.aaB("+" + c.b(this.tca).getString("dial_code") + c.c(this.tca).getString("key_mobile"))});
    }
}
