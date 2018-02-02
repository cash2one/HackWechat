package com.tencent.mm.plugin.wxcredit;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxcredit.a.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class f$1 extends e {
    final /* synthetic */ f tYV;

    f$1(f fVar, MMActivity mMActivity, g gVar) {
        this.tYV = fVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0 || !(kVar instanceof f)) {
            return false;
        }
        this.tYV.a(this.zHU, 0, f.a(this.tYV));
        return true;
    }

    public final boolean k(Object... objArr) {
        if (f.b(this.tYV).getBoolean("key_is_show_detail", true)) {
            return false;
        }
        Bankcard bankcard = (Bankcard) f.c(this.tYV).getParcelable("key_bankcard");
        this.zHV.a(new f(bankcard.field_bankcardType, bankcard.field_bindSerial, f.d(this.tYV).getString("key_pwd1")), true, 1);
        return true;
    }
}
