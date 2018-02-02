package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class akb extends a {
    public long fLR;
    public b wrl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.fLR);
            if (this.wrl != null) {
                aVar.b(2, this.wrl);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.R(1, this.fLR) + 0;
            if (this.wrl != null) {
                return r0 + e.a.a.a.a(2, this.wrl);
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
            akb com_tencent_mm_protocal_c_akb = (akb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_akb.fLR = aVar3.Avy.rz();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_akb.wrl = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
