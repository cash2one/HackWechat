package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.g.a.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;

class f$1 extends c<e> {
    final /* synthetic */ f mOg;

    f$1(f fVar) {
        this.mOg = fVar;
        this.xen = e.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!((e) bVar).fmQ.fmR) {
            ag.h(new 1(this), 10000);
            this.mOg.mOd.dead();
        }
        return false;
    }
}
