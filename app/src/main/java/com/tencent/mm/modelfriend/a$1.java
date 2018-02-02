package com.tencent.mm.modelfriend;

import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class a$1 implements b {
    a$1() {
    }

    public final void bM(boolean z) {
        x.i("MicroMsg.AddrBookSyncHelper", "syncAddrBookAndUpload onSyncEnd suc:%b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            System.currentTimeMillis();
            ar.CG().a(new aa(m.NU(), m.NT()), 0);
        }
    }
}
