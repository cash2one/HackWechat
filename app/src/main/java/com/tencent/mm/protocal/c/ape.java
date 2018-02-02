package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ape extends a {
    public LinkedList<ku> wiJ = new LinkedList();
    public String wvR;
    public boolean wvS;
    public et wvT;
    public String wvU;
    public boolean wvV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wvR != null) {
                aVar.g(1, this.wvR);
            }
            aVar.d(2, 8, this.wiJ);
            aVar.al(3, this.wvS);
            if (this.wvT != null) {
                aVar.fW(4, this.wvT.bke());
                this.wvT.a(aVar);
            }
            if (this.wvU != null) {
                aVar.g(5, this.wvU);
            }
            aVar.al(6, this.wvV);
            return 0;
        } else if (i == 1) {
            if (this.wvR != null) {
                r0 = e.a.a.b.b.a.h(1, this.wvR) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.c(2, 8, this.wiJ)) + (e.a.a.b.b.a.dX(3) + 1);
            if (this.wvT != null) {
                r0 += e.a.a.a.fT(4, this.wvT.bke());
            }
            if (this.wvU != null) {
                r0 += e.a.a.b.b.a.h(5, this.wvU);
            }
            return r0 + (e.a.a.b.b.a.dX(6) + 1);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wiJ.clear();
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
            ape com_tencent_mm_protocal_c_ape = (ape) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a kuVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_ape.wvR = aVar3.Avy.readString();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        kuVar = new ku();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = kuVar.a(aVar4, kuVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ape.wiJ.add(kuVar);
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ape.wvS = aVar3.cJC();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        kuVar = new et();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = kuVar.a(aVar4, kuVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ape.wvT = kuVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ape.wvU = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ape.wvV = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
