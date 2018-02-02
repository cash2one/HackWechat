package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class o extends i<Integer> {
    private a Ahe = null;
    private e Ahf = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return Integer.valueOf(aVar.aif.getInt());
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        return Integer.valueOf(aVar.ID(((Integer) comparable).intValue()));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        Integer num = (Integer) comparable;
        int position = this.Ahf.aif.position();
        this.Ahf.writeInt(num.intValue());
        a aVar = this.Ahe;
        aVar.size++;
        return position;
    }

    public o(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.Ahe = iVar2.AeT.Afq;
            this.Ahf = iVar2.a(this.Ahe);
        }
    }

    protected final a c(i iVar) {
        return iVar.AeT.Afq;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.AhL.put(i, i3);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.AhZ.IA(i);
        }
    }
}
