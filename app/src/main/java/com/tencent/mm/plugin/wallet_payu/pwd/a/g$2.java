package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class g$2 extends e {
    final /* synthetic */ g tdo;

    g$2(g gVar, MMActivity mMActivity, g gVar2) {
        this.tdo = gVar;
        super(mMActivity, gVar2);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof b)) {
            return false;
        }
        x.d("MicroMsg.PayUModifyPasswordProcess", "hy: change pwd user success");
        if (i != 0 || i2 != 0) {
            return false;
        }
        g.a(this.tdo).putInt("key_errcode_payu", 0);
        a.c(this.zHU, this.tdo.msB, 0);
        return true;
    }

    public final boolean k(Object... objArr) {
        p pVar = (p) objArr[0];
        this.zHV.a(new b(g.b(this.tdo).getString("key_pwd1"), pVar.sPj), true);
        return true;
    }
}
