package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class asz extends a {
    public int ngq;
    public String nko;
    public String nkp;
    public int vGW;
    public long vHe;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkp != null) {
                aVar.g(1, this.nkp);
            }
            if (this.nko != null) {
                aVar.g(2, this.nko);
            }
            aVar.fU(3, this.vGW);
            aVar.fU(4, this.ngq);
            aVar.S(5, this.vHe);
            return 0;
        } else if (i == 1) {
            if (this.nkp != null) {
                r0 = e.a.a.b.b.a.h(1, this.nkp) + 0;
            } else {
                r0 = 0;
            }
            if (this.nko != null) {
                r0 += e.a.a.b.b.a.h(2, this.nko);
            }
            return ((r0 + e.a.a.a.fR(3, this.vGW)) + e.a.a.a.fR(4, this.ngq)) + e.a.a.a.R(5, this.vHe);
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
            asz com_tencent_mm_protocal_c_asz = (asz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_asz.nkp = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_asz.nko = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_asz.vGW = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_asz.ngq = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_asz.vHe = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
