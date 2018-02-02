package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.b;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i$e;
import com.tencent.tinker.a.a.t.a;

public final class c extends i<b> {
    private a AgG = null;
    private i$e AgH = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cGA();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        b bVar = (b) comparable;
        int length = bVar.Aeh.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = aVar.IJ(bVar.Aeh[i]);
        }
        return new b(bVar.dzw, iArr);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        b bVar = (b) comparable;
        a aVar = this.AgG;
        aVar.size++;
        return this.AgH.a(bVar);
    }

    public c(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.c.a.c.c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AgG = iVar2.AeT.Afy;
            this.AgH = iVar2.a(this.AgG);
        }
    }

    protected final a c(i iVar) {
        return iVar.AeT.Afy;
    }

    protected final void a(com.tencent.tinker.c.a.c.c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.AhR.put(i2, i4);
        }
    }

    protected final void a(com.tencent.tinker.c.a.c.c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.Aif.IA(i2);
        }
    }
}
