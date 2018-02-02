package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i$e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;
import java.lang.reflect.Array;

public final class d extends i<com.tencent.tinker.a.a.d> {
    private a AgI = null;
    private i$e AgJ = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cGC();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        int i;
        com.tencent.tinker.a.a.d dVar = (com.tencent.tinker.a.a.d) comparable;
        int IK = aVar.IK(dVar.Aej);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.Aek.length, 2});
        for (i = 0; i < iArr.length; i++) {
            iArr[i][0] = aVar.IG(dVar.Aek[i][0]);
            iArr[i][1] = aVar.IK(dVar.Aek[i][1]);
        }
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.Ael.length, 2});
        for (i = 0; i < iArr2.length; i++) {
            iArr2[i][0] = aVar.IH(dVar.Ael[i][0]);
            iArr2[i][1] = aVar.IK(dVar.Ael[i][1]);
        }
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.Aem.length, 2});
        for (i = 0; i < iArr3.length; i++) {
            iArr3[i][0] = aVar.IH(dVar.Aem[i][0]);
            iArr3[i][1] = aVar.IL(dVar.Aem[i][1]);
        }
        return new com.tencent.tinker.a.a.d(dVar.dzw, IK, iArr, iArr2, iArr3);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.d dVar = (com.tencent.tinker.a.a.d) comparable;
        a aVar = this.AgI;
        aVar.size++;
        return this.AgJ.a(dVar);
    }

    public d(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AgI = iVar2.AeT.AfF;
            this.AgJ = iVar2.a(this.AgI);
        }
    }

    protected final a c(i iVar) {
        return iVar.AeT.AfF;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.AhT.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.Aih.IA(i2);
        }
    }
}
