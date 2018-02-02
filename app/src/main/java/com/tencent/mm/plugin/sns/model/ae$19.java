package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.ns;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class ae$19 extends c<ns> {
    final /* synthetic */ ae qWL;

    ae$19(ae aeVar) {
        this.qWL = aeVar;
        this.xen = ns.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.d("MicroMsg.SnsCore", "try resend msg for SnsInfoId:%d", new Object[]{Long.valueOf((long) ((ns) bVar).fFK.fFL)});
        ag.y(new 1(this, r0));
        return false;
    }
}
