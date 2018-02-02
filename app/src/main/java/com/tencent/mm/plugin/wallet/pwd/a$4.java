package com.tencent.mm.plugin.wallet.pwd;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class a$4 extends e {
    final /* synthetic */ a sGp;

    a$4(a aVar, MMActivity mMActivity, g gVar) {
        this.sGp = aVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet.pwd.a.e)) {
            return false;
        }
        this.sGp.a(this.zHU, 0, a.e(this.sGp));
        return true;
    }

    public final boolean k(Object... objArr) {
        this.zHV.a(new com.tencent.mm.plugin.wallet.pwd.a.e((p) objArr[0]), true, 1);
        return true;
    }
}
