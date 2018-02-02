package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import java.util.LinkedList;

public final class g extends a {
    public LinkedList<h> sDC = new LinkedList();
    public b sDD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.sDC);
            if (this.sDD != null) {
                aVar.b(2, this.sDD);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.c(1, 8, this.sDC) + 0;
            if (this.sDD != null) {
                return r0 + e.a.a.a.a(2, this.sDD);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.sDC.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a hVar = new h();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                        }
                        gVar.sDC.add(hVar);
                    }
                    return 0;
                case 2:
                    gVar.sDD = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
