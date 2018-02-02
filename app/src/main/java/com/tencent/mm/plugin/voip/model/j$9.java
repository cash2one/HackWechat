package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.g.a.tm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;

class j$9 extends c<tm> {
    final /* synthetic */ j smu;

    j$9(j jVar) {
        this.smu = jVar;
        this.xen = tm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        tm tmVar = (tm) bVar;
        if (tmVar instanceof tm) {
            ag.y(new 1(this, tmVar));
        }
        return false;
    }
}
