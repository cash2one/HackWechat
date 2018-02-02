package com.tencent.mm.plugin.game.model;

import com.tencent.mm.g.a.ng;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;

class SubCoreGameCenter$3 extends c<ng> {
    final /* synthetic */ SubCoreGameCenter nfd;

    SubCoreGameCenter$3(SubCoreGameCenter subCoreGameCenter) {
        this.nfd = subCoreGameCenter;
        this.xen = ng.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ng ngVar = (ng) bVar;
        ap.a(ac.getContext(), ngVar.fFi.scene, ngVar.fFi.fFj, 1, ngVar.fFi.action, 0, ngVar.fFi.appId, 0, ngVar.fFi.msgType, ngVar.fFi.fDJ, ngVar.fFi.fop, ngVar.fFi.fFk);
        return false;
    }
}
