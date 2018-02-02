package com.tencent.mm.wallet_core.ui;

import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e.c;
import com.tencent.mm.z.bd.a;

class e$2 implements a {
    final /* synthetic */ c[] zJh;

    e$2(c[] cVarArr) {
        this.zJh = cVarArr;
    }

    public final void a(e eVar) {
        if (eVar != null && eVar.Kx() != null) {
            if (this.zJh == null || this.zJh.length == 0) {
                x.w("MicroMsg.WalletBaseUtil ", "hy: kvs is null or length is 0");
                return;
            }
            try {
                for (c cVar : this.zJh) {
                    if (!(cVar == null || bh.ov(cVar.aAM))) {
                        eVar.Kx().g(cVar.aAM, e.ct(cVar.xhC));
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.WalletBaseUtil ", "hy: serialize failed: %s", new Object[]{e.toString()});
            }
        }
    }
}
