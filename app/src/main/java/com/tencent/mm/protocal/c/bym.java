package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bym extends a {
    public long wYH;
    public long wYI;
    public String wYJ;
    public LinkedList<byn> wYK = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wYJ == null) {
                throw new b("Not all required fields were included: TotalMsg");
            }
            aVar.S(1, this.wYI);
            aVar.S(2, this.wYH);
            if (this.wYJ != null) {
                aVar.g(3, this.wYJ);
            }
            aVar.d(4, 8, this.wYK);
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.R(1, this.wYI) + 0) + e.a.a.a.R(2, this.wYH);
            if (this.wYJ != null) {
                r0 += e.a.a.b.b.a.h(3, this.wYJ);
            }
            return r0 + e.a.a.a.c(4, 8, this.wYK);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wYK.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wYJ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: TotalMsg");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bym com_tencent_mm_protocal_c_bym = (bym) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bym.wYI = aVar3.Avy.rz();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bym.wYH = aVar3.Avy.rz();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bym.wYJ = aVar3.Avy.readString();
                    return 0;
                case 4:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_byn = new byn();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_byn.a(aVar4, com_tencent_mm_protocal_c_byn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bym.wYK.add(com_tencent_mm_protocal_c_byn);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
