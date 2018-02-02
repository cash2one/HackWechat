package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class bca extends a {
    public int ktN;
    public int lOD;
    public b vYR;
    public int wFj;
    public String wIn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wIn != null) {
                aVar.g(1, this.wIn);
            }
            aVar.fU(2, this.ktN);
            aVar.fU(3, this.lOD);
            aVar.fU(4, this.wFj);
            if (this.vYR == null) {
                return 0;
            }
            aVar.b(5, this.vYR);
            return 0;
        } else if (i == 1) {
            if (this.wIn != null) {
                r0 = e.a.a.b.b.a.h(1, this.wIn) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + e.a.a.a.fR(2, this.ktN)) + e.a.a.a.fR(3, this.lOD)) + e.a.a.a.fR(4, this.wFj);
            if (this.vYR != null) {
                r0 += e.a.a.a.a(5, this.vYR);
            }
            return r0;
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
            bca com_tencent_mm_protocal_c_bca = (bca) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bca.wIn = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bca.ktN = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bca.lOD = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bca.wFj = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bca.vYR = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
