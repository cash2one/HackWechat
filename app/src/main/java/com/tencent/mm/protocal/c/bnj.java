package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bnj extends bcv {
    public int rYW;
    public int wQg;
    public LinkedList<bni> wQh = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.wQg);
            aVar.d(3, 8, this.wQh);
            aVar.fU(4, this.rYW);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + e.a.a.a.fR(2, this.wQg)) + e.a.a.a.c(3, 8, this.wQh)) + e.a.a.a.fR(4, this.rYW);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wQh.clear();
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
            bnj com_tencent_mm_protocal_c_bnj = (bnj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bnj.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bnj.wQg = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bni();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bnj.wQh.add(fdVar);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bnj.rYW = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
