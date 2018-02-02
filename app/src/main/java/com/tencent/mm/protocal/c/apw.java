package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class apw extends a {
    public String fFm;
    public int rYW;
    public String username;
    public int vNa;
    public int wtc;
    public int wwA;
    public int wwB;
    public String wwC;
    public int wwD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fFm != null) {
                aVar.g(1, this.fFm);
            }
            if (this.username != null) {
                aVar.g(2, this.username);
            }
            aVar.fU(3, this.wtc);
            aVar.fU(4, this.vNa);
            aVar.fU(5, this.rYW);
            aVar.fU(6, this.wwA);
            aVar.fU(7, this.wwB);
            if (this.wwC != null) {
                aVar.g(8, this.wwC);
            }
            aVar.fU(9, this.wwD);
            return 0;
        } else if (i == 1) {
            if (this.fFm != null) {
                r0 = e.a.a.b.b.a.h(1, this.fFm) + 0;
            } else {
                r0 = 0;
            }
            if (this.username != null) {
                r0 += e.a.a.b.b.a.h(2, this.username);
            }
            r0 = ((((r0 + e.a.a.a.fR(3, this.wtc)) + e.a.a.a.fR(4, this.vNa)) + e.a.a.a.fR(5, this.rYW)) + e.a.a.a.fR(6, this.wwA)) + e.a.a.a.fR(7, this.wwB);
            if (this.wwC != null) {
                r0 += e.a.a.b.b.a.h(8, this.wwC);
            }
            return r0 + e.a.a.a.fR(9, this.wwD);
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
            apw com_tencent_mm_protocal_c_apw = (apw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_apw.fFm = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_apw.username = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_apw.wtc = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_apw.vNa = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_apw.rYW = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_apw.wwA = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_apw.wwB = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_apw.wwC = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_apw.wwD = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
