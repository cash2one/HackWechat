package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class bny extends a {
    public int wQJ;
    public b wQK;
    public int wQL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(7, this.wQJ);
            if (this.wQK != null) {
                aVar.b(8, this.wQK);
            }
            aVar.fU(9, this.wQL);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(7, this.wQJ) + 0;
            if (this.wQK != null) {
                r0 += e.a.a.a.a(8, this.wQK);
            }
            return r0 + e.a.a.a.fR(9, this.wQL);
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
            bny com_tencent_mm_protocal_c_bny = (bny) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 7:
                    com_tencent_mm_protocal_c_bny.wQJ = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bny.wQK = aVar3.cJD();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bny.wQL = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
