package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i$e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class f extends i<com.tencent.tinker.a.a.f> {
    private a AgM = null;
    private i$e AgN = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cGv();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.f fVar = (com.tencent.tinker.a.a.f) comparable;
        return new com.tencent.tinker.a.a.f(fVar.dzw, aVar.IE(fVar.Aev), fVar.Aes, aVar.IE(fVar.Aew), aVar.II(fVar.Aex), aVar.ID(fVar.Aey), aVar.IM(fVar.Aez), aVar.IO(fVar.AeA), aVar.IN(fVar.AeB));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.f fVar = (com.tencent.tinker.a.a.f) comparable;
        a aVar = this.AgM;
        aVar.size++;
        return this.AgN.a(fVar);
    }

    public f(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AgM = iVar2.AeT.Afu;
            this.AgN = iVar2.a(this.AgM);
        }
    }

    protected final a c(i iVar) {
        return iVar.AeT.Afu;
    }
}
