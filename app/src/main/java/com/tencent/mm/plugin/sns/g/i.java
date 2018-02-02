package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class i extends a {
    public LinkedList<h> raV = new LinkedList();
    public g raW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.raV);
            if (this.raW != null) {
                aVar.fW(2, this.raW.bke());
                this.raW.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.c(1, 8, this.raV) + 0;
            if (this.raW != null) {
                return r0 + e.a.a.a.fT(2, this.raW.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.raV.clear();
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
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a hVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        hVar = new h();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                        }
                        iVar.raV.add(hVar);
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        hVar = new g();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                        }
                        iVar.raW = hVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
