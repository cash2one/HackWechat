package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class brt extends a {
    public int wTq;
    public b wTr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wTq);
            if (this.wTr != null) {
                aVar.b(2, this.wTr);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wTq) + 0;
            if (this.wTr != null) {
                return r0 + e.a.a.a.a(2, this.wTr);
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
            brt com_tencent_mm_protocal_c_brt = (brt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_brt.wTq = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_brt.wTr = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
