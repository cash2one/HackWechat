package com.tencent.mm.plugin.address.model;

import com.tencent.mm.g.a.me;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class j extends c<me> {
    public j() {
        this.xen = me.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        me meVar = (me) bVar;
        x.i("MicroMsg.RcptAddressEventListener", "revent " + meVar.fDQ.fDS);
        ar.Hg();
        k.fp(meVar.fDQ.fDS, com.tencent.mm.z.c.FC() + "address");
        return false;
    }
}
