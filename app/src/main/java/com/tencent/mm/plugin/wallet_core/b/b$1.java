package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class b$1 extends e {
    final /* synthetic */ b sIf;

    b$1(b bVar, MMActivity mMActivity, g gVar) {
        this.sIf = bVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    public final boolean k(Object... objArr) {
        return false;
    }

    public final CharSequence um(int i) {
        switch (i) {
            case 0:
                return this.zHU.getString(i.uQW);
            case 1:
                return this.zHU.getString(i.uRS);
            default:
                return super.um(i);
        }
    }
}
