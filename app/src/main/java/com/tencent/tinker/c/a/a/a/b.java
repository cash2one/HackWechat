package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.c;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;

public final class b extends i<c> {
    private a AgE = null;
    private e AgF = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cGB();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        c cVar = (c) comparable;
        int length = cVar.Aei.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = aVar.IK(cVar.Aei[i]);
        }
        return new c(cVar.dzw, iArr);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        c cVar = (c) comparable;
        a aVar = this.AgE;
        aVar.size++;
        return this.AgF.a(cVar);
    }

    public b(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.c.a.c.c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AgE = iVar2.AeT.Afx;
            this.AgF = iVar2.a(this.AgE);
        }
    }

    protected final a c(i iVar) {
        return iVar.AeT.Afx;
    }

    protected final void a(com.tencent.tinker.c.a.c.c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.AhS.put(i2, i4);
        }
    }

    protected final void a(com.tencent.tinker.c.a.c.c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.Aig.IA(i2);
        }
    }
}
