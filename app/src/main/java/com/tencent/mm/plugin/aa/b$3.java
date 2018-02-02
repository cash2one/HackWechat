package com.tencent.mm.plugin.aa;

import com.tencent.mm.g.a.bm;
import com.tencent.mm.plugin.aa.a.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;

class b$3 extends c<bm> {
    final /* synthetic */ b ifC;

    b$3(b bVar) {
        this.ifC = bVar;
        this.xen = bm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bm bmVar = (bm) bVar;
        x.i("MicroMsg.SubCoreAA", "closeAAEvent callback, billNo: %s, chatroom: %s", new Object[]{bmVar.fpD.fpE, bmVar.fpD.fpF});
        if (!(bh.ov(bmVar.fpD.fpE) || bh.ov(bmVar.fpD.fpF))) {
            j jVar = new j();
            jVar.WL().init();
            a aVar = jVar.igB;
            String str = bmVar.fpD.fpE;
            int i = com.tencent.mm.plugin.aa.a.a.igd;
            g.a(str, Integer.valueOf(i), bmVar.fpD.fpF, Long.valueOf(bmVar.fpD.fpG)).b(aVar).c(new 2(this, jVar)).a(new 1(this, jVar));
        }
        return false;
    }
}
