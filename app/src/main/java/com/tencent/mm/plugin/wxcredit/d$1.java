package com.tencent.mm.plugin.wxcredit;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxcredit.a.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class d$1 extends e {
    final /* synthetic */ d tYT;

    d$1(d dVar, MMActivity mMActivity, g gVar) {
        this.tYT = dVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    public final boolean k(Object... objArr) {
        return false;
    }

    public final boolean p(Object... objArr) {
        Bankcard bankcard = (Bankcard) objArr[0];
        this.zHV.a(new d(bankcard.field_bindSerial, bankcard.field_bankcardType), true, 1);
        return true;
    }
}
