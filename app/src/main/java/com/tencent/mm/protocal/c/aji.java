package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class aji extends a {
    public String nfp;
    public LinkedList<aqr> vYd = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfp != null) {
                aVar.g(1, this.nfp);
            }
            aVar.d(2, 8, this.vYd);
            return 0;
        } else if (i == 1) {
            if (this.nfp != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfp) + 0;
            } else {
                r0 = 0;
            }
            return r0 + e.a.a.a.c(2, 8, this.vYd);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vYd.clear();
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
            aji com_tencent_mm_protocal_c_aji = (aji) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aji.nfp = aVar3.Avy.readString();
                    return 0;
                case 2:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_aqr = new aqr();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_aqr.a(aVar4, com_tencent_mm_protocal_c_aqr, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aji.vYd.add(com_tencent_mm_protocal_c_aqr);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
