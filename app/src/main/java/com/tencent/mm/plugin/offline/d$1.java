package com.tencent.mm.plugin.offline;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.c.q;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class d$1 extends e {
    final /* synthetic */ d oVk;

    d$1(d dVar, MMActivity mMActivity, g gVar) {
        this.oVk = dVar;
        super(mMActivity, gVar);
    }

    public final boolean k(Object... objArr) {
        p pVar = (p) objArr[1];
        pVar.flag = "1";
        this.zHV.a(new q(pVar), true, 1);
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof x) {
                if (!(((WalletBaseUI) this.zHU).vf == null || ((WalletBaseUI) this.zHU).vf.getInt("key_bind_scene", -1) != 5 || a.bhH())) {
                    d.e(this.zHU);
                    return true;
                }
            } else if (kVar instanceof com.tencent.mm.plugin.offline.a.k) {
                com.tencent.mm.wallet_core.a.j(this.zHU, ((WalletBaseUI) this.zHU).vf);
                a.F(this.zHU);
                return true;
            }
        }
        return false;
    }
}
