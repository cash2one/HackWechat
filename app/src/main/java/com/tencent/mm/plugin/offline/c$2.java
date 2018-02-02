package com.tencent.mm.plugin.offline;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.b.a.b;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class c$2 extends e {
    final /* synthetic */ c oVj;

    c$2(c cVar, MMActivity mMActivity, g gVar) {
        this.oVj = cVar;
        super(mMActivity, gVar);
    }

    public final boolean k(Object... objArr) {
        this.zHV.a(new b((p) objArr[0]), true, 1);
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof x) {
                if (!(((WalletBaseUI) this.zHU).vf == null || ((WalletBaseUI) this.zHU).vf.getInt("key_bind_scene", -1) != 5 || a.bhH())) {
                    c.d(this.zHU);
                    return true;
                }
            } else if (kVar instanceof com.tencent.mm.plugin.offline.a.k) {
                Bundle bundle = ((WalletBaseUI) this.zHU).vf;
                bundle.putBoolean("intent_bind_end", true);
                com.tencent.mm.wallet_core.a.j(this.zHU, bundle);
                a.F(this.zHU);
                return true;
            }
        }
        return false;
    }
}
