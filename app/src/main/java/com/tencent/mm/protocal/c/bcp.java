package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bcp extends a {
    public int rYW;
    public long vPp;
    public int vXc;
    public long wFp;
    public String wIH;
    public String wII;
    public int wIJ;
    public int wIK;
    public int wIL;
    public String wIM;
    public String wIN;
    public String wIO;
    public int wsh;
    public String wwM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.rYW);
            if (this.wwM != null) {
                aVar.g(2, this.wwM);
            }
            if (this.wIH != null) {
                aVar.g(3, this.wIH);
            }
            aVar.S(4, this.vPp);
            if (this.wII != null) {
                aVar.g(5, this.wII);
            }
            aVar.fU(6, this.wIJ);
            aVar.fU(7, this.wIK);
            aVar.fU(8, this.wIL);
            aVar.S(9, this.wFp);
            aVar.fU(10, this.wsh);
            if (this.wIM != null) {
                aVar.g(11, this.wIM);
            }
            aVar.fU(12, this.vXc);
            if (this.wIN != null) {
                aVar.g(13, this.wIN);
            }
            if (this.wIO != null) {
                aVar.g(14, this.wIO);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.rYW) + 0;
            if (this.wwM != null) {
                r0 += e.a.a.b.b.a.h(2, this.wwM);
            }
            if (this.wIH != null) {
                r0 += e.a.a.b.b.a.h(3, this.wIH);
            }
            r0 += e.a.a.a.R(4, this.vPp);
            if (this.wII != null) {
                r0 += e.a.a.b.b.a.h(5, this.wII);
            }
            r0 = ((((r0 + e.a.a.a.fR(6, this.wIJ)) + e.a.a.a.fR(7, this.wIK)) + e.a.a.a.fR(8, this.wIL)) + e.a.a.a.R(9, this.wFp)) + e.a.a.a.fR(10, this.wsh);
            if (this.wIM != null) {
                r0 += e.a.a.b.b.a.h(11, this.wIM);
            }
            r0 += e.a.a.a.fR(12, this.vXc);
            if (this.wIN != null) {
                r0 += e.a.a.b.b.a.h(13, this.wIN);
            }
            if (this.wIO != null) {
                return r0 + e.a.a.b.b.a.h(14, this.wIO);
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
            bcp com_tencent_mm_protocal_c_bcp = (bcp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bcp.rYW = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bcp.wwM = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bcp.wIH = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bcp.vPp = aVar3.Avy.rz();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bcp.wII = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bcp.wIJ = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bcp.wIK = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bcp.wIL = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bcp.wFp = aVar3.Avy.rz();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bcp.wsh = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bcp.wIM = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bcp.vXc = aVar3.Avy.ry();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bcp.wIN = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bcp.wIO = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
