package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i$e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class e extends i<com.tencent.tinker.a.a.e> {
    private a AgK = null;
    private i$e AgL = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cGy();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.e eVar = (com.tencent.tinker.a.a.e) comparable;
        return new com.tencent.tinker.a.a.e(eVar.dzw, aVar.b(eVar.Aen), aVar.b(eVar.Aeo), aVar.b(eVar.Aep), aVar.b(eVar.Aeq));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.e eVar = (com.tencent.tinker.a.a.e) comparable;
        a aVar = this.AgK;
        aVar.size++;
        return this.AgL.a(eVar);
    }

    public e(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AgK = iVar2.AeT.Afz;
            this.AgL = iVar2.a(this.AgK);
        }
    }

    protected final a c(i iVar) {
        return iVar.AeT.Afz;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.AhV.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.Aij.IA(i2);
        }
    }
}
