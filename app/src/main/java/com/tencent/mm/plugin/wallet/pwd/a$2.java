package com.tencent.mm.plugin.wallet.pwd;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.pwd.a.f;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class a$2 extends e {
    final /* synthetic */ a sGp;

    a$2(a aVar, MMActivity mMActivity, g gVar) {
        this.sGp = aVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0 || !(kVar instanceof f)) {
            return false;
        }
        a.a(this.sGp).putString("kreq_token", ((f) kVar).token);
        this.sGp.a(this.zHU, 0, a.b(this.sGp));
        return true;
    }

    public final boolean k(Object... objArr) {
        Authen authen = (Authen) objArr[0];
        if (this.sGp.bMX()) {
            authen.fDt = 4;
        } else {
            authen.fDt = 1;
        }
        this.zHV.a(new f(authen, a.c(this.sGp).getBoolean("key_is_reset_with_new_card", false)), true, 1);
        return true;
    }
}
