package com.tencent.mm.plugin.wallet.pwd;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class b$1 extends e {
    final /* synthetic */ b sGq;

    b$1(b bVar, MMActivity mMActivity, g gVar) {
        this.sGq = bVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    public final boolean k(Object... objArr) {
        this.zHV.a(new r((String) objArr[0], 3, (String) objArr[1]), true, 1);
        return true;
    }

    public final CharSequence um(int i) {
        switch (i) {
            case 0:
                return this.zHU.getString(i.uQT);
            case 1:
                return this.zHU.getString(i.uUk);
            default:
                return super.um(i);
        }
    }
}
