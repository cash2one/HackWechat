package com.tencent.mm.plugin.soter.d;

import com.tencent.d.b.e.e;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class c implements a<Boolean, com.tencent.mm.vending.j.c<Boolean, Boolean>> {
    private b igh = null;

    public final /* synthetic */ Object call(Object obj) {
        final com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
        x.v("MicroMsg.SoterPrepareAskFunc", "alvinluo SoterPrepareAskFunc call");
        if (((Boolean) cVar.get(0)).booleanValue()) {
            this.igh = g.czQ();
            if (!com.tencent.d.b.a.cFW()) {
                return Boolean.valueOf(false);
            }
            e eVar = com.tencent.mm.kernel.g.Dh().Cy() ? new com.tencent.mm.plugin.soter.b.e() : new f();
            x.v("MicroMsg.SoterPrepareAskFunc", "alvinluo has ask: %b", new Object[]{Boolean.valueOf(com.tencent.d.a.a.cFL())});
            this.igh.czP();
            com.tencent.d.b.a.a(new com.tencent.d.b.a.b<com.tencent.d.b.a.c>(this) {
                final /* synthetic */ c rSt;

                public final /* synthetic */ void a(com.tencent.d.b.a.e eVar) {
                    com.tencent.d.b.a.c cVar = (com.tencent.d.b.a.c) eVar;
                    x.i("MicroMsg.SoterPrepareAskFunc", "alvinluo SoterPrepareAskFunc onResult errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(cVar.errCode), cVar.fnL});
                    if (cVar.isSuccess()) {
                        this.rSt.igh.t(new Object[]{cVar.get(1)});
                        return;
                    }
                    com.tencent.mm.plugin.soter.c.a.dM(1, cVar.errCode);
                    this.rSt.igh.cl(g.u(Integer.valueOf(cVar.errCode), cVar.fnL));
                }
            }, false, eVar);
            x.v("MicroMsg.SoterPrepareAskFunc", "alvinluo prepareask isNeedSaveDeviceInfo: %b", new Object[]{cVar.get(1)});
            return (Boolean) cVar.get(1);
        }
        x.i("MicroMsg.SoterPrepareAskFunc", "alvinluo not need prepare ask, return");
        return (Boolean) cVar.get(1);
    }
}
