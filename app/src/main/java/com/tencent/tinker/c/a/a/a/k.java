package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.a.a;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.p;
import com.tencent.tinker.a.a.t$a;
import com.tencent.tinker.c.a.c.c;

public final class k extends i<p> {
    private t$a AgU = null;
    private e AgV = null;

    protected final /* synthetic */ Comparable a(a aVar) {
        return aVar.cGt();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        p pVar = (p) comparable;
        return new p(pVar.dzw, aVar.IE(pVar.Afi), aVar.IF(pVar.Afk), aVar.ID(pVar.Afj));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        p pVar = (p) comparable;
        t$a com_tencent_tinker_a_a_t_a = this.AgU;
        com_tencent_tinker_a_a_t_a.size++;
        return this.AgV.a(pVar);
    }

    public k(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AgU = iVar2.AeT.Aft;
            this.AgV = iVar2.a(this.AgU);
        }
    }

    protected final t$a c(i iVar) {
        return iVar.AeT.Aft;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.AhO.put(i, i3);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.Aic.IA(i);
        }
    }
}
