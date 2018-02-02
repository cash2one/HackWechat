package com.tencent.mm.modelfriend;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.q.b;

class af$5 extends a {
    final /* synthetic */ af hxt;

    af$5(af afVar) {
        this.hxt = afVar;
    }

    public final boolean execute() {
        h aVar = new com.tencent.mm.q.a();
        ((m) g.k(m.class)).registerIndexStorage(aVar);
        aVar.create();
        j bVar = new b();
        ((m) g.k(m.class)).registerNativeLogic(9, bVar);
        bVar.create();
        return true;
    }

    public final String getName() {
        return "InitFTSFriendPluginTask";
    }
}
