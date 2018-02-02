package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bxs extends a {
    public String nfe;
    public LinkedList<vy> wYr = new LinkedList();
    public String wYs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wYs == null) {
                throw new b("Not all required fields were included: Charset");
            }
            aVar.d(1, 8, this.wYr);
            if (this.wYs != null) {
                aVar.g(2, this.wYs);
            }
            if (this.nfe != null) {
                aVar.g(3, this.nfe);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.c(1, 8, this.wYr) + 0;
            if (this.wYs != null) {
                r0 += e.a.a.b.b.a.h(2, this.wYs);
            }
            if (this.nfe != null) {
                return r0 + e.a.a.b.b.a.h(3, this.nfe);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wYr.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wYs != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Charset");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bxs com_tencent_mm_protocal_c_bxs = (bxs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a vyVar = new vy();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = vyVar.a(aVar4, vyVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bxs.wYr.add(vyVar);
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bxs.wYs = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bxs.nfe = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
