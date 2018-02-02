package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.a.a;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t$a;
import com.tencent.tinker.a.a.u;
import com.tencent.tinker.c.a.c.c;

public final class p extends i<u> {
    private t$a Ahg = null;
    private e Ahh = null;

    protected final /* synthetic */ Comparable a(a aVar) {
        return aVar.cGr();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        u uVar = (u) comparable;
        if (uVar == u.AfO) {
            return uVar;
        }
        short[] sArr = new short[uVar.AfP.length];
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = (short) aVar.IE(uVar.AfP[i]);
        }
        return new u(uVar.dzw, sArr);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        u uVar = (u) comparable;
        t$a com_tencent_tinker_a_a_t_a = this.Ahg;
        com_tencent_tinker_a_a_t_a.size++;
        return this.Ahh.a(uVar);
    }

    public p(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.Ahg = iVar2.AeT.Afw;
            this.Ahh = iVar2.a(this.Ahg);
        }
    }

    protected final t$a c(i iVar) {
        return iVar.AeT.Afw;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.AhP.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.Aid.IA(i2);
        }
    }
}
