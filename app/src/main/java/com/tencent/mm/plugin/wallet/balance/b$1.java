package com.tencent.mm.plugin.wallet.balance;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.b.a;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class b$1 extends e {
    final /* synthetic */ b syb;

    b$1(b bVar, MMActivity mMActivity, g gVar) {
        this.syb = bVar;
        super(mMActivity, gVar);
    }

    public final boolean p(Object... objArr) {
        String str = null;
        p.bJN();
        b.a(this.syb).putParcelable("key_history_bankcard", p.bJO().sQa);
        PayInfo payInfo = (PayInfo) this.syb.msB.get("key_pay_info");
        if (a.bKG()) {
            this.zHV.a(new v(payInfo == null ? null : payInfo.fuH), true);
        } else {
            g gVar = this.zHV;
            if (payInfo != null) {
                str = payInfo.fuH;
            }
            gVar.a(new x(str, 4), true);
        }
        return false;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    public final boolean k(Object... objArr) {
        this.syb.a(this.zHU, 0, this.syb.msB);
        return true;
    }
}
