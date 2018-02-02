package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.b.a.a;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class b$2 extends e {
    final /* synthetic */ b sIf;

    b$2(b bVar, MMActivity mMActivity, g gVar) {
        this.sIf = bVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof a) {
                b.a(this.sIf).putString("kreq_token", ((a) kVar).token);
                if (this.sIf.c(this.zHU, b.b(this.sIf))) {
                    x.i("MicroMsg.BindCardProcess", "need update bankcardlist");
                    this.zHV.a(new com.tencent.mm.plugin.wallet_core.c.x(null, 12), false);
                    return true;
                }
                x.i("MicroMsg.BindCardProcess", "not need update bankcardlist");
                this.sIf.a(this.zHU, 0, b.c(this.sIf));
                return true;
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.x) {
                x.i("MicroMsg.BindCardProcess", "update bankcardlist success!");
                this.sIf.a(this.zHU, 0, b.d(this.sIf));
                return true;
            }
        }
        return false;
    }

    public final boolean k(Object... objArr) {
        this.sIf.w(new Object[]{"onNext", objArr});
        x.i("MicroMsg.BindCardProcess", "onNext, do bind bank card!");
        Authen authen = (Authen) objArr[0];
        authen.fDt = b.e(this.sIf);
        this.zHV.a(new a(authen), true, 1);
        return true;
    }
}
