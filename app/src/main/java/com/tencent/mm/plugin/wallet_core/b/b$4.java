package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.b.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.model.h;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class b$4 extends e {
    final /* synthetic */ b sIf;

    b$4(b bVar, MMActivity mMActivity, g gVar) {
        this.sIf = bVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof b) {
            this.sIf.a(this.zHV);
            if (((b) kVar).sIg != null) {
                b.h(this.sIf).putParcelable("key_bindcard_value_result", ((b) kVar).sIg);
            }
        } else if (kVar instanceof h) {
            return true;
        }
        return false;
    }

    public final boolean k(Object... objArr) {
        p pVar = (p) objArr[0];
        b.i(this.sIf).getString("verify_card_flag", "0");
        if ("realname_verify_process".equals(this.sIf.aKG())) {
            this.zHV.a(new b(pVar, this.sIf.msB.getInt("entry_scene", -1)), true);
        } else {
            this.zHV.a(new b(pVar), true);
        }
        return false;
    }
}
