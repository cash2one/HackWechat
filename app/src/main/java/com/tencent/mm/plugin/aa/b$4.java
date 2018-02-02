package com.tencent.mm.plugin.aa;

import com.tencent.mm.g.a.bn;
import com.tencent.mm.plugin.aa.a.a.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class b$4 extends c<bn> {
    final /* synthetic */ b ifC;

    b$4(b bVar) {
        this.ifC = bVar;
        this.xen = bn.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bn bnVar = (bn) bVar;
        if (!(bh.ov(bnVar.fpH.fpE) || bh.ov(bnVar.fpH.fpF))) {
            new d(bnVar.fpH.fpE, bnVar.fpH.fpF).JV().f(new 1(this, bnVar));
        }
        return false;
    }
}
