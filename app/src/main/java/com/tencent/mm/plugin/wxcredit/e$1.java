package com.tencent.mm.plugin.wxcredit;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wxcredit.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class e$1 extends e {
    final /* synthetic */ e tYU;

    e$1(e eVar, MMActivity mMActivity, g gVar) {
        this.tYU = eVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (kVar instanceof b) {
            b bVar = (b) kVar;
            e.a(this.tYU).putString("KEY_SESSION_KEY", bVar.token);
            e.b(this.tYU).putString("key_pre_name", bVar.name);
            e.c(this.tYU).putString("key_pre_indentity", bVar.tYX);
            e.d(this.tYU).putBoolean("key_has_indentity_info", bVar.tYY);
        }
        this.tYU.a(this.zHU, 0, e.e(this.tYU));
        return true;
    }

    public final boolean k(Object... objArr) {
        int i = 0;
        e.f(this.tYU).putString("key_pwd1", (String) objArr[0]);
        g gVar = this.zHV;
        String str = (String) objArr[0];
        if (objArr[1] != null) {
            i = bh.VI((String) objArr[1]);
        }
        gVar.a(new b(str, i, e.g(this.tYU).getString("key_bank_type")), true, 1);
        return true;
    }
}
