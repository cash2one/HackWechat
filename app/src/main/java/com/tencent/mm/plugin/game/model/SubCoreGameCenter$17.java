package com.tencent.mm.plugin.game.model;

import com.tencent.mm.g.a.hh;
import com.tencent.mm.plugin.game.c.dw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SubCoreGameCenter$17 extends c<hh> {
    final /* synthetic */ SubCoreGameCenter nfd;

    SubCoreGameCenter$17(SubCoreGameCenter subCoreGameCenter) {
        this.nfd = subCoreGameCenter;
        this.xen = hh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        hh hhVar = (hh) bVar;
        dw aQd = i.aQb().aQd();
        if (aQd != null) {
            hhVar.fxz.fxA = aQd.hbM;
            hhVar.fxz.fxB = aQd.neh;
        }
        return false;
    }
}
