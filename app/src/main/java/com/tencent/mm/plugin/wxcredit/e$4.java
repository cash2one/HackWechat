package com.tencent.mm.plugin.wxcredit;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.b.a.a;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.e.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class e$4 extends e {
    final /* synthetic */ e tYU;

    e$4(e eVar, MMActivity mMActivity, g gVar) {
        this.tYU = eVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0 || !(kVar instanceof a)) {
            return false;
        }
        a aVar = (a) kVar;
        new StringBuilder("reqKey  ").append(aVar.sEE);
        e.P(this.tYU).putString("kreq_token", aVar.token);
        this.tYU.a(this.zHU, 0, e.Q(this.tYU));
        return true;
    }

    public final boolean k(Object... objArr) {
        c.bNg();
        Authen authen = new Authen();
        authen.sKw = (String) objArr[0];
        authen.oZz = (String) objArr[1];
        authen.sIF = (String) objArr[2];
        e.R(this.tYU).putString("key_bank_phone", (String) objArr[3]);
        authen.fDt = o.bLq().bLM() ? 2 : 1;
        authen.sKv = 1;
        authen.pCn = (PayInfo) e.S(this.tYU).getParcelable("key_pay_info");
        authen.sKs = e.T(this.tYU).getString("key_pwd1");
        if (!e.U(this.tYU).getBoolean("key_has_indentity_info", false)) {
            authen.sKt = e.V(this.tYU).getString("key_name");
            authen.sKu = e.W(this.tYU).getString("key_indentity");
        }
        e.X(this.tYU).putString("key_mobile", com.tencent.mm.wallet_core.ui.e.aaB(authen.sIF));
        e.Y(this.tYU).putBoolean("key_is_oversea", false);
        this.zHV.a(new a(authen), true, 1);
        return true;
    }

    public final boolean q(Object... objArr) {
        this.zHV.a(new t("", (String) objArr[0], (PayInfo) e.Z(this.tYU).getParcelable("key_pay_info")), true, 1);
        return true;
    }
}
