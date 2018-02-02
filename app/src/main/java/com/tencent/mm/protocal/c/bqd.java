package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class bqd extends a {
    public int vIB;
    public int vIC;
    public String vZU;
    public b wRN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wRN == null) {
                throw new e.a.a.b("Not all required fields were included: EmojiBuffer");
            }
            if (this.vZU != null) {
                aVar.g(1, this.vZU);
            }
            aVar.fU(2, this.vIC);
            aVar.fU(3, this.vIB);
            if (this.wRN == null) {
                return 0;
            }
            aVar.b(4, this.wRN);
            return 0;
        } else if (i == 1) {
            if (this.vZU != null) {
                r0 = e.a.a.b.b.a.h(1, this.vZU) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.vIC)) + e.a.a.a.fR(3, this.vIB);
            if (this.wRN != null) {
                r0 += e.a.a.a.a(4, this.wRN);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wRN != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: EmojiBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqd com_tencent_mm_protocal_c_bqd = (bqd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bqd.vZU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bqd.vIC = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bqd.vIB = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bqd.wRN = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
