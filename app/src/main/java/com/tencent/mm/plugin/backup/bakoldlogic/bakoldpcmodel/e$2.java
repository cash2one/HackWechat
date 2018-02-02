package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.3;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.ac;
import com.tencent.mm.plugin.backup.h.r;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class e$2 implements e {
    final /* synthetic */ e krf;

    e$2(e eVar) {
        this.krf = eVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        b bVar = (b) kVar;
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 3) {
                ac acVar = (ac) bVar.apH();
                if (acVar.ksA == 2) {
                    r rVar = acVar.kuh;
                    Runnable 1 = new 1(this, rVar);
                    Runnable 2 = new 2(this);
                    e eVar = this.krf;
                    x.i("MicroMsg.BakPcProcessMgr", "doGetBakchatKey id: %s", new Object[]{rVar.ID});
                    ar.CG().a(596, new 3(eVar, 1, 2));
                    if (eVar.kqX != null) {
                        eVar.kqX.cancel();
                    }
                    eVar.kqX = new com.tencent.mm.plugin.backup.bakoldlogic.c.e(r0);
                    ar.CG().a(eVar.kqX, 0);
                }
            }
            b.b(3, this);
            return;
        }
        x.e("MicroMsg.BakPcProcessMgr", "onSceneEnd:%d  err  [%d,%d]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
    }
}
