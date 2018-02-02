package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class nn extends a {
    public String vWs;
    public String vWt;
    public LinkedList<bnr> vWu = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vWs == null) {
                throw new b("Not all required fields were included: baseid");
            }
            if (this.vWs != null) {
                aVar.g(1, this.vWs);
            }
            if (this.vWt != null) {
                aVar.g(2, this.vWt);
            }
            aVar.d(3, 8, this.vWu);
            return 0;
        } else if (i == 1) {
            if (this.vWs != null) {
                r0 = e.a.a.b.b.a.h(1, this.vWs) + 0;
            } else {
                r0 = 0;
            }
            if (this.vWt != null) {
                r0 += e.a.a.b.b.a.h(2, this.vWt);
            }
            return r0 + e.a.a.a.c(3, 8, this.vWu);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vWu.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vWs != null) {
                return 0;
            }
            throw new b("Not all required fields were included: baseid");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            nn nnVar = (nn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    nnVar.vWs = aVar3.Avy.readString();
                    return 0;
                case 2:
                    nnVar.vWt = aVar3.Avy.readString();
                    return 0;
                case 3:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bnr = new bnr();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bnr.a(aVar4, com_tencent_mm_protocal_c_bnr, a.a(aVar4))) {
                        }
                        nnVar.vWu.add(com_tencent_mm_protocal_c_bnr);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
