package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bri extends a {
    public String title;
    public LinkedList<bna> wSN = new LinkedList();
    public LinkedList<bna> wSO = new LinkedList();
    public LinkedList<oq> wSP = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            aVar.d(2, 8, this.wSN);
            aVar.d(3, 8, this.wSO);
            aVar.d(4, 8, this.wSP);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + e.a.a.a.c(2, 8, this.wSN)) + e.a.a.a.c(3, 8, this.wSO)) + e.a.a.a.c(4, 8, this.wSP);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wSN.clear();
            this.wSO.clear();
            this.wSP.clear();
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
            bri com_tencent_mm_protocal_c_bri = (bri) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a com_tencent_mm_protocal_c_bna;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bri.title = aVar3.Avy.readString();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bna = new bna();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bna.a(aVar4, com_tencent_mm_protocal_c_bna, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bri.wSN.add(com_tencent_mm_protocal_c_bna);
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bna = new bna();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bna.a(aVar4, com_tencent_mm_protocal_c_bna, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bri.wSO.add(com_tencent_mm_protocal_c_bna);
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bna = new oq();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bna.a(aVar4, com_tencent_mm_protocal_c_bna, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bri.wSP.add(com_tencent_mm_protocal_c_bna);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
