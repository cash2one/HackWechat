package com.tencent.mm.plugin.wxcredit;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wxcredit.a.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class e$2 extends e {
    final /* synthetic */ e tYU;

    e$2(e eVar, MMActivity mMActivity, g gVar) {
        this.tYU = eVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (kVar instanceof a) {
            a aVar = (a) kVar;
            e.h(this.tYU).putString("KEY_SESSION_KEY", aVar.token);
            e.i(this.tYU).putString("key_mobile", aVar.fAf);
            e.j(this.tYU).putBoolean("key_need_bind_deposit", aVar.fKI);
            e.k(this.tYU).putBoolean("key_is_bank_user", aVar.tYW);
        }
        this.tYU.a(this.zHU, 0, e.l(this.tYU));
        return true;
    }

    public final boolean k(Object... objArr) {
        String str = (String) objArr[0];
        String str2 = (String) objArr[1];
        e.m(this.tYU).putString("key_name", str);
        e.n(this.tYU).putString("key_indentity", str2);
        this.zHV.a(new a(str, str2, e.o(this.tYU).getString("KEY_SESSION_KEY"), e.p(this.tYU).getString("key_bank_type")), true, 1);
        return true;
    }
}
