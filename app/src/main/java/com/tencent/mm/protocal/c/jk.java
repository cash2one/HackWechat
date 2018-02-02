package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import java.util.LinkedList;

public final class jk extends a {
    public b vPL;
    public b vPM;
    public LinkedList<bgr> vPN = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPL == null) {
                throw new e.a.a.b("Not all required fields were included: Title");
            } else if (this.vPM == null) {
                throw new e.a.a.b("Not all required fields were included: ServiceUrl");
            } else {
                if (this.vPL != null) {
                    aVar.b(1, this.vPL);
                }
                if (this.vPM != null) {
                    aVar.b(2, this.vPM);
                }
                aVar.d(3, 8, this.vPN);
                return 0;
            }
        } else if (i == 1) {
            if (this.vPL != null) {
                r0 = e.a.a.a.a(1, this.vPL) + 0;
            } else {
                r0 = 0;
            }
            if (this.vPM != null) {
                r0 += e.a.a.a.a(2, this.vPM);
            }
            return r0 + e.a.a.a.c(3, 8, this.vPN);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vPN.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vPL == null) {
                throw new e.a.a.b("Not all required fields were included: Title");
            } else if (this.vPM != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: ServiceUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jk jkVar = (jk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jkVar.vPL = aVar3.cJD();
                    return 0;
                case 2:
                    jkVar.vPM = aVar3.cJD();
                    return 0;
                case 3:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bgr = new bgr();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bgr.a(aVar4, com_tencent_mm_protocal_c_bgr, a.a(aVar4))) {
                        }
                        jkVar.vPN.add(com_tencent_mm_protocal_c_bgr);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
