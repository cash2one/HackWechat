package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import java.util.LinkedList;

public final class caj extends a {
    public LinkedList<bma> wZU = new LinkedList();
    public b wZV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.wZU);
            if (this.wZV != null) {
                aVar.b(2, this.wZV);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.c(1, 8, this.wZU) + 0;
            if (this.wZV != null) {
                return r0 + e.a.a.a.a(2, this.wZV);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wZU.clear();
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
            caj com_tencent_mm_protocal_c_caj = (caj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bma = new bma();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bma.a(aVar4, com_tencent_mm_protocal_c_bma, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_caj.wZU.add(com_tencent_mm_protocal_c_bma);
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_caj.wZV = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
