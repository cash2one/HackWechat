package com.tencent.mm.plugin.wallet.a;

import java.util.LinkedList;

public final class a extends com.tencent.mm.bq.a {
    public LinkedList<b> sDg = new LinkedList();
    public k sDh;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.sDg);
            if (this.sDh != null) {
                aVar.fW(2, this.sDh.bke());
                this.sDh.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.c(1, 8, this.sDg) + 0;
            if (this.sDh != null) {
                return r0 + e.a.a.a.fT(2, this.sDh.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.sDg.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a bVar;
            e.a.a.a.a aVar5;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        bVar = new b();
                        aVar5 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar5, bVar, com.tencent.mm.bq.a.a(aVar5))) {
                        }
                        aVar4.sDg.add(bVar);
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        bVar = new k();
                        aVar5 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar5, bVar, com.tencent.mm.bq.a.a(aVar5))) {
                        }
                        aVar4.sDh = bVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
