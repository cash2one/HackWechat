package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bzh extends a {
    public int ksO;
    public int ktN;
    public String nko;
    public int pbl;
    public String vHc;
    public int wZc;
    public int wyU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nko != null) {
                aVar.g(1, this.nko);
            }
            aVar.fU(2, this.ktN);
            aVar.fU(3, this.ksO);
            aVar.fU(4, this.pbl);
            aVar.fU(5, this.wyU);
            if (this.vHc != null) {
                aVar.g(6, this.vHc);
            }
            aVar.fU(7, this.wZc);
            return 0;
        } else if (i == 1) {
            if (this.nko != null) {
                r0 = e.a.a.b.b.a.h(1, this.nko) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((r0 + e.a.a.a.fR(2, this.ktN)) + e.a.a.a.fR(3, this.ksO)) + e.a.a.a.fR(4, this.pbl)) + e.a.a.a.fR(5, this.wyU);
            if (this.vHc != null) {
                r0 += e.a.a.b.b.a.h(6, this.vHc);
            }
            return r0 + e.a.a.a.fR(7, this.wZc);
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
            bzh com_tencent_mm_protocal_c_bzh = (bzh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bzh.nko = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bzh.ktN = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bzh.ksO = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bzh.pbl = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bzh.wyU = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bzh.vHc = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bzh.wZc = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
