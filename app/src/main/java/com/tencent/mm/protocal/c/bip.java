package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class bip extends a {
    public int ktM;
    public b wMc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wMc == null) {
                throw new e.a.a.b("Not all required fields were included: Signature");
            }
            aVar.fU(1, this.ktM);
            if (this.wMc != null) {
                aVar.b(2, this.wMc);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.ktM) + 0;
            if (this.wMc != null) {
                return r0 + e.a.a.a.a(2, this.wMc);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wMc != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: Signature");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bip com_tencent_mm_protocal_c_bip = (bip) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bip.ktM = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bip.wMc = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
