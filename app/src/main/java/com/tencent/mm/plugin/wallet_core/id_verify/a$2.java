package com.tencent.mm.plugin.wallet_core.id_verify;

import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.su;
import com.tencent.mm.plugin.wallet_core.id_verify.model.c;
import com.tencent.mm.plugin.wallet_core.id_verify.model.h;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class a$2 extends e {
    final /* synthetic */ a sJh;

    a$2(a aVar, MMActivity mMActivity, g gVar) {
        this.sJh = aVar;
        super(mMActivity, gVar);
    }

    public final boolean k(Object... objArr) {
        p pVar = (p) objArr[0];
        String string = a.e(this.sJh).getString("key_real_name_token");
        if (pVar == null || bh.ov(pVar.sPj)) {
            x.e("MicroMsg.RealNameVerifyProcess", "get pwd error");
        } else if (bh.ov(string)) {
            x.e("MicroMsg.RealNameVerifyProcess", "get token error");
        } else {
            this.zHV.a(new c(pVar.sPj, string, this.sJh.msB.getInt("entry_scene", -1)), true);
        }
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof c) {
            if (i == 0 && i2 == 0) {
                a.f(this.sJh).putInt("realname_verify_process_ret", -1);
                x.i("MicroMsg.RealNameVerifyProcess", "real name reg succ ,update user info");
                o.bLq().aJh();
                b suVar = new su();
                suVar.fKE.scene = 16;
                suVar.fqI = new 1(this);
                a.xef.m(suVar);
                a.a(this.sJh, this.zHV);
                this.sJh.b(this.zHU, a.g(this.sJh));
                return true;
            }
        } else if (kVar instanceof h) {
            return true;
        }
        return false;
    }
}
