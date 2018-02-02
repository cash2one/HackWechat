package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bdx extends a {
    public LinkedList<cn> wJM = new LinkedList();
    public String wvP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.wJM);
            if (this.wvP != null) {
                aVar.g(2, this.wvP);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.c(1, 8, this.wJM) + 0;
            if (this.wvP != null) {
                return r0 + e.a.a.b.b.a.h(2, this.wvP);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wJM.clear();
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
            bdx com_tencent_mm_protocal_c_bdx = (bdx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a cnVar = new cn();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = cnVar.a(aVar4, cnVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bdx.wJM.add(cnVar);
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bdx.wvP = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
