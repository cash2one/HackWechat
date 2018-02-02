package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class n extends i<s> {
    private a Aha = null;
    private a Ahb = null;
    private e Ahc = null;
    private e Ahd = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cGq();
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        int a = this.Ahc.a((s) comparable);
        this.Ahd.writeInt(a);
        a aVar = this.Aha;
        aVar.size++;
        aVar = this.Ahb;
        aVar.size++;
        return a;
    }

    public n(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.Aha = iVar2.AeT.AfB;
            this.Ahb = iVar2.AeT.Afp;
            this.Ahc = iVar2.a(this.Aha);
            this.Ahd = iVar2.a(this.Ahb);
        }
    }

    protected final a c(i iVar) {
        return iVar.AeT.AfB;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.AhK.put(i, i3);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.AhY.IA(i);
        }
    }
}
