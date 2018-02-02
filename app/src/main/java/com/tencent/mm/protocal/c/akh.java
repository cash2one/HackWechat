package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class akh extends a {
    public String wrB;
    public String wrC;
    public int wrD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wrB != null) {
                aVar.g(1, this.wrB);
            }
            if (this.wrC != null) {
                aVar.g(2, this.wrC);
            }
            aVar.fU(3, this.wrD);
            return 0;
        } else if (i == 1) {
            if (this.wrB != null) {
                r0 = e.a.a.b.b.a.h(1, this.wrB) + 0;
            } else {
                r0 = 0;
            }
            if (this.wrC != null) {
                r0 += e.a.a.b.b.a.h(2, this.wrC);
            }
            return r0 + e.a.a.a.fR(3, this.wrD);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            akh com_tencent_mm_protocal_c_akh = (akh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_akh.wrB = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_akh.wrC = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_akh.wrD = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
