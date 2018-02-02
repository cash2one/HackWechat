package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class j extends i<n> {
    private a AgS = null;
    private e AgT = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cGs();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        n nVar = (n) comparable;
        return new n(nVar.dzw, aVar.IE(nVar.Afi), aVar.IE(nVar.Aev), aVar.ID(nVar.Afj));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        n nVar = (n) comparable;
        a aVar = this.AgS;
        aVar.size++;
        return this.AgT.a(nVar);
    }

    public j(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AgS = iVar2.AeT.Afs;
            this.AgT = iVar2.a(this.AgS);
        }
    }

    protected final a c(i iVar) {
        return iVar.AeT.Afs;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.AhN.put(i, i3);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.Aib.IA(i);
        }
    }
}
