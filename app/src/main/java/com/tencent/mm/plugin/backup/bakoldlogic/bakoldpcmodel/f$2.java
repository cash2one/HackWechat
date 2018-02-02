package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.ac;
import com.tencent.mm.plugin.backup.h.r;
import com.tencent.mm.sdk.platformtools.x;

class f$2 implements e {
    final /* synthetic */ f krr;

    f$2(f fVar) {
        this.krr = fVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ac acVar = (ac) ((b) kVar).apH();
        if (acVar.ksA == 2) {
            r rVar = acVar.kuh;
            this.krr.krl.addAll(rVar.ktE);
            this.krr.krk.addAll(rVar.ktD);
            x.i("MicroMsg.RecoverPCServer", "MediaSize:[%d / %d], digestSize: [%d / %d]", new Object[]{Integer.valueOf(this.krr.krl.size()), Integer.valueOf(this.krr.krk.size()), Integer.valueOf(rVar.ktq), Integer.valueOf(rVar.ktp)});
            if (this.krr.krl.size() < rVar.ktq || this.krr.krk.size() < rVar.ktp) {
                x.i("MicroMsg.RecoverPCServer", "send restore info cmd again~");
                new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).apQ();
                return;
            }
            this.krr.kro = rVar.ktl;
            x.i("MicroMsg.RecoverPCServer", "down RestoreInfo complete, convDataSize:%d", new Object[]{Long.valueOf(this.krr.kro)});
            b.b(3, this);
            com.tencent.mm.sdk.f.e.post(new 1(this), "RecoverPCServer_recover_getIDList");
        }
    }
}
