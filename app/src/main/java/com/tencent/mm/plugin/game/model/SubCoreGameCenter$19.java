package com.tencent.mm.plugin.game.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.game.b.b;

class SubCoreGameCenter$19 extends a {
    final /* synthetic */ SubCoreGameCenter nfd;

    SubCoreGameCenter$19(SubCoreGameCenter subCoreGameCenter) {
        this.nfd = subCoreGameCenter;
    }

    public final boolean execute() {
        h aVar = new com.tencent.mm.plugin.game.b.a();
        ((m) g.k(m.class)).registerIndexStorage(aVar);
        aVar.create();
        j bVar = new b();
        ((m) g.k(m.class)).registerNativeLogic(5, bVar);
        bVar.create();
        return true;
    }

    public final String getName() {
        return "InitFTSGamePluginTask";
    }
}
