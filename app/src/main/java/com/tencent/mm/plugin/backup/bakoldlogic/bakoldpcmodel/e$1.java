package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.2;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.s;
import com.tencent.mm.sdk.platformtools.x;

class e$1 extends a {
    final /* synthetic */ e krf;

    e$1(e eVar) {
        this.krf = eVar;
    }

    public final void run() {
        s sVar = new s();
        if (this.kst) {
            sVar.kti = this.dbSize;
            sVar.ktG = this.ksv - this.dbSize;
            sVar.ktF = this.ksu;
            e eVar = this.krf;
            e.a(6, 0, sVar);
            b.a(3, new 2(eVar));
            x.i("MicroMsg.BakPcProcessMgr", "send restore info cmd");
            new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).apQ();
            return;
        }
        if (this.dbSize > this.ksv && this.ksv > 0) {
            sVar.kti = this.dbSize;
            sVar.ktG = this.ksv - this.dbSize;
        }
        e.a(6, 14, sVar);
        x.e("MicroMsg.BakPcProcessMgr", "init TempDB error");
    }
}
