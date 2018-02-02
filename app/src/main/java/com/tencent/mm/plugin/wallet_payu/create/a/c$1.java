package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_payu.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class c$1 extends e {
    final /* synthetic */ c tca;

    c$1(c cVar, MMActivity mMActivity, g gVar) {
        this.tca = cVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof b) {
            x.d("MicroMsg.PayUOpenProcess", "hy: scene gen otp, errCode %d, errType %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i == 0 && i2 == 0) {
                b bVar = (b) kVar;
                this.tca.msB.putString("payu_reference", bVar.fzP);
                x.d("MicroMsg.PayUOpenProcess", "hy: session: %s", new Object[]{bVar.fzP});
                this.tca.msB.putBoolean("key_is_has_mobile", bVar.tct);
                a.j(this.zHU, this.tca.msB);
                return true;
            }
        }
        return false;
    }

    public final boolean k(Object... objArr) {
        this.zHV.a(new b(this.tca.msB.getString("dial_code"), this.tca.msB.getString("key_mobile")), true);
        return false;
    }
}
