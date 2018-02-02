package com.tencent.mm.plugin.game.model;

import com.tencent.mm.g.a.jh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class SubCoreGameCenter$13 extends c<jh> {
    final /* synthetic */ SubCoreGameCenter nfd;

    SubCoreGameCenter$13(SubCoreGameCenter subCoreGameCenter) {
        this.nfd = subCoreGameCenter;
        this.xen = jh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.SubCoreGameCenter", "manual force login");
        j.aQe().fB(true);
        return false;
    }
}
