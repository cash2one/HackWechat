package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class c$4 extends e {
    final /* synthetic */ c tca;

    c$4(c cVar, MMActivity mMActivity, g gVar) {
        this.tca = cVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if ((kVar instanceof a) && i == 0 && i2 == 0) {
            x.d("MicroMsg.PayUOpenProcess", "hy: create user success");
            a.c(this.zHU, this.tca.msB, 0);
            c.d(this.tca).putInt("key_open_error_code", 0);
            u.makeText(this.zHU, this.zHU.getString(i.uVk), 0).show();
            return true;
        } else if (!(kVar instanceof b) || i != 0 || i2 != 0) {
            return false;
        } else {
            x.d("MicroMsg.PayUOpenProcess", "hy: link user success");
            a.c(this.zHU, this.tca.msB, 0);
            c.e(this.tca).putInt("key_open_error_code", 0);
            u.makeText(this.zHU, this.zHU.getString(i.uVk), 0).show();
            return true;
        }
    }

    public final boolean k(Object... objArr) {
        p pVar = (p) objArr[0];
        String string = this.tca.msB.getString("dial_code");
        String string2 = this.tca.msB.getString("key_mobile");
        String str = pVar.sPj;
        String string3 = this.tca.msB.getString("key_question_id");
        String string4 = this.tca.msB.getString("key_question_answer");
        String string5 = this.tca.msB.getString("payu_reference");
        if (this.tca.msB.getBoolean("key_is_has_mobile")) {
            this.zHV.a(new b(string, string2, str, string5), true);
        } else {
            this.zHV.a(new a(string, string2, str, string3, string4, string5), true);
        }
        return true;
    }
}
