package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.bf.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class b$1 extends c<bf> {
    final /* synthetic */ b svT;

    b$1(b bVar) {
        this.svT = bVar;
        this.xen = bf.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = true;
        bf bfVar = (bf) bVar;
        if (bfVar instanceof bf) {
            a aVar = bfVar.fpv;
            if (!(b.bIT().swV == 1 || b.bIT().swV == 2)) {
                z = false;
            }
            aVar.fdc = z;
        }
        return false;
    }
}
