package com.tencent.mm.az;

import com.tencent.mm.g.a.bc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class r$3 extends c<bc> {
    final /* synthetic */ r hJT;

    r$3(r rVar) {
        this.hJT = rVar;
        this.xen = bc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bc bcVar = (bc) bVar;
        if (bcVar.fpl.fpm == 47 && bcVar.fpl.fpn == 1) {
            x.i("MicroMsg.SubCorePacakge", "going to update region code.");
            r.a(this.hJT, bcVar.fpl.filePath);
        }
        return false;
    }
}
