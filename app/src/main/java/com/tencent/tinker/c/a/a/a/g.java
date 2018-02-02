package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.a.a;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t$a;
import com.tencent.tinker.c.a.c.b;
import com.tencent.tinker.c.a.c.c;

public final class g extends i<com.tencent.tinker.a.a.g> {
    private t$a AgO = null;
    private e AgP = null;

    protected final /* synthetic */ Comparable a(a aVar) {
        return aVar.cGw();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.g.a[] aVarArr;
        com.tencent.tinker.a.a.g gVar = (com.tencent.tinker.a.a.g) comparable;
        int IP = aVar.IP(gVar.AeF);
        short[] sArr = gVar.AeG;
        if (!(sArr == null || sArr.length == 0)) {
            sArr = new b(aVar).a(sArr);
        }
        com.tencent.tinker.a.a.g.a[] aVarArr2 = gVar.AeI;
        if (aVarArr2 == null || aVarArr2.length == 0) {
            aVarArr = aVarArr2;
        } else {
            aVarArr = new com.tencent.tinker.a.a.g.a[aVarArr2.length];
            for (int i = 0; i < aVarArr2.length; i++) {
                com.tencent.tinker.a.a.g.a aVar2 = aVarArr2[i];
                int length = aVar2.AeJ.length;
                int[] iArr = new int[length];
                for (int i2 = 0; i2 < length; i2++) {
                    iArr[i2] = aVar.IE(aVar2.AeJ[i2]);
                }
                aVarArr[i] = new com.tencent.tinker.a.a.g.a(iArr, aVar2.AeK, aVar2.AeL, aVar2.offset);
            }
        }
        return new com.tencent.tinker.a.a.g(gVar.dzw, gVar.AeC, gVar.AeD, gVar.AeE, IP, sArr, gVar.AeH, aVarArr);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.g gVar = (com.tencent.tinker.a.a.g) comparable;
        t$a com_tencent_tinker_a_a_t_a = this.AgO;
        com_tencent_tinker_a_a_t_a.size++;
        return this.AgP.a(gVar);
    }

    public g(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AgO = iVar2.AeT.AfA;
            this.AgP = iVar2.a(this.AgO);
        }
    }

    protected final t$a c(i iVar) {
        return iVar.AeT.AfA;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.AhX.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.Ail.IA(i2);
        }
    }
}
