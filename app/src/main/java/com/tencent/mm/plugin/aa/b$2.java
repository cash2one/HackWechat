package com.tencent.mm.plugin.aa;

import com.tencent.mm.g.a.mi;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class b$2 extends c<mi> {
    final /* synthetic */ b ifC;

    b$2(b bVar) {
        this.ifC = bVar;
        this.xen = mi.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mi miVar = (mi) bVar;
        x.i("MicroMsg.SubCoreAA", "ReceiveAAMsgEvent, localMsgId: %s, msgContent: %s", new Object[]{Long.valueOf(miVar.fEk.fEl), bh.VT(miVar.fEk.fDP)});
        h.g(r0, r2);
        return false;
    }
}
