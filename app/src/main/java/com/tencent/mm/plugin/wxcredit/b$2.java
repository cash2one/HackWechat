package com.tencent.mm.plugin.wxcredit;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class b$2 extends e {
    final /* synthetic */ b tYR;

    b$2(b bVar, MMActivity mMActivity, g gVar) {
        this.tYR = bVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        this.tYR.a(this.zHU, 0, b.e(this.tYR));
        this.zHU.finish();
        return true;
    }

    public final boolean k(Object... objArr) {
        b.f(this.tYR).putString("key_pwd1", (String) objArr[0]);
        this.zHV.a(new r((String) objArr[0], 5, ""), true, 1);
        return true;
    }
}
