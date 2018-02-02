package com.tencent.mm.plugin.wallet.pwd;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.pwd.a.b;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class b$2 extends e {
    final /* synthetic */ b sGq;

    b$2(b bVar, MMActivity mMActivity, g gVar) {
        this.sGq = bVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (!(kVar instanceof b)) {
                return true;
            }
            this.sGq.a(this.zHU, 0, b.a(this.sGq));
            h.bu(this.zHU, this.zHU.getString(a$i.uUg));
            return true;
        } else if (!(kVar instanceof b)) {
            return false;
        } else {
            h.a(this.zHU, str, "", false, new 1(this));
            return true;
        }
    }

    public final boolean k(Object... objArr) {
        p pVar = (p) objArr[0];
        this.zHV.a(new b(b.b(this.sGq).getString("key_pwd1"), pVar.sPj), true, 1);
        return true;
    }
}
