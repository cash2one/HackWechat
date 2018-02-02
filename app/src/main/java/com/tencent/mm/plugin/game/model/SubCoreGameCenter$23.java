package com.tencent.mm.plugin.game.model;

import com.tencent.mm.g.a.gp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SubCoreGameCenter$23 extends c<gp> {
    final /* synthetic */ SubCoreGameCenter nfd;

    SubCoreGameCenter$23(SubCoreGameCenter subCoreGameCenter) {
        this.nfd = subCoreGameCenter;
        this.xen = gp.class.getName().hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean a(b bVar) {
        gp gpVar = (gp) bVar;
        n.a(gpVar.fwJ.url, gpVar.fwJ.fqR, gpVar.fwJ.scene != 0 ? gpVar.fwJ.scene : 1000, gpVar.fwJ.appId, gpVar.fwJ.extInfo);
        return false;
    }
}
