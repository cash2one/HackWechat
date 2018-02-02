package com.tencent.mm.vending.app;

import com.tencent.mm.vending.b.c;
import com.tencent.mm.vending.base.a.a;
import com.tencent.mm.vending.g.g;

class a$2 implements a {
    final /* synthetic */ a zBa;

    a$2(a aVar) {
        this.zBa = aVar;
    }

    public final /* synthetic */ void cj(Object obj) {
        Class cls = (Class) obj;
        c cVar = (c) this.zBa.zAY.get(cls);
        if (cVar != null) {
            cVar.a(g.cq(this.zBa.zAV.get(cls)));
        }
    }
}
