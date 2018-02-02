package com.tencent.mm.plugin.wxcredit;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class e$6 extends e {
    final /* synthetic */ e tYU;

    e$6(e eVar, MMActivity mMActivity, g gVar) {
        this.tYU = eVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        this.tYU.a(this.zHU, 0, e.al(this.tYU));
        return true;
    }

    public final boolean k(Object... objArr) {
        e.am(this.tYU).putBoolean("key_is_follow_bank_username", ((Boolean) objArr[0]).booleanValue());
        e.an(this.tYU);
        this.zHV.a(new x(), true, 1);
        return true;
    }
}
