package com.tencent.mm.plugin.game.model;

import com.tencent.mm.g.a.gs;
import com.tencent.mm.plugin.game.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SubCoreGameCenter$18 extends c<gs> {
    final /* synthetic */ SubCoreGameCenter nfd;

    SubCoreGameCenter$18(SubCoreGameCenter subCoreGameCenter) {
        this.nfd = subCoreGameCenter;
        this.xen = gs.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        gs gsVar = (gs) bVar;
        String str = gsVar.fwO.url;
        gsVar.fwP.fwQ = a.mVI;
        switch (gsVar.fwO.pK) {
            case 1:
                gsVar.fwP.fwR = com.tencent.mm.plugin.game.d.a.a.aRT().Cj(str);
                break;
            case 2:
                com.tencent.mm.plugin.game.d.a.a.aRT().Ck(str);
                break;
        }
        return false;
    }
}
