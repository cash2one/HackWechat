package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class l extends i<r> {
    private a AgW = null;
    private e AgX = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cGu();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        r rVar = (r) comparable;
        return new r(rVar.dzw, aVar.ID(rVar.Afl), aVar.IE(rVar.Afm), aVar.II(rVar.Afn));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        r rVar = (r) comparable;
        a aVar = this.AgW;
        aVar.size++;
        return this.AgX.a(rVar);
    }

    public l(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AgW = iVar2.AeT.Afr;
            this.AgX = iVar2.a(this.AgW);
        }
    }

    protected final a c(i iVar) {
        return iVar.AeT.Afr;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.AhM.put(i, i3);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.Aia.IA(i);
        }
    }
}
