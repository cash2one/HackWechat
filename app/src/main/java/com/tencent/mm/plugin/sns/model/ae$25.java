package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.rq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class ae$25 extends c<rq> {
    final /* synthetic */ ae qWL;

    ae$25(ae aeVar) {
        this.qWL = aeVar;
        this.xen = rq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.SnsCore", "triger snslogmgr try report");
        ae.bvp().bub();
        return false;
    }
}
