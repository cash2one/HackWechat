package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.on;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.z.ar;

class g$3 extends c<on> {
    final /* synthetic */ g tOt;

    g$3(g gVar) {
        this.tOt = gVar;
        this.xen = on.class.getName().hashCode();
    }

    private boolean a(on onVar) {
        if (onVar != null && (onVar instanceof on)) {
            k dVar = new d(onVar.fGv.fGw);
            ar.CG().a(971, new 1(this, dVar, onVar));
            ar.CG().a(dVar, 0);
        }
        return false;
    }
}
