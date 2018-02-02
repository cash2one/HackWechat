package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ajs extends a {
    public int gfR;
    public long gfS;
    public String gfT;
    public String gfU;
    public String gfV;
    public String gfW;
    public String hvy;
    public String nfT;
    public String nfg;
    public String vJh;
    public String vLs;
    public String wqJ;
    public String wqK;
    public int wqL;
    public int wqM;
    public int wqN;
    public int wqO;
    public String wqP;
    public String wqQ;
    public String wqR;
    public String wqS;
    public int wqT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wqJ != null) {
                aVar.g(1, this.wqJ);
            }
            if (this.vJh != null) {
                aVar.g(2, this.vJh);
            }
            if (this.vLs != null) {
                aVar.g(3, this.vLs);
            }
            if (this.wqK != null) {
                aVar.g(4, this.wqK);
            }
            aVar.fU(5, this.wqL);
            aVar.fU(6, this.wqM);
            aVar.fU(7, this.wqN);
            aVar.fU(8, this.wqO);
            if (this.wqP != null) {
                aVar.g(9, this.wqP);
            }
            if (this.hvy != null) {
                aVar.g(10, this.hvy);
            }
            if (this.nfT != null) {
                aVar.g(11, this.nfT);
            }
            if (this.nfg != null) {
                aVar.g(12, this.nfg);
            }
            if (this.wqQ != null) {
                aVar.g(13, this.wqQ);
            }
            if (this.wqR != null) {
                aVar.g(14, this.wqR);
            }
            if (this.wqS != null) {
                aVar.g(15, this.wqS);
            }
            aVar.fU(16, this.wqT);
            aVar.fU(17, this.gfR);
            aVar.S(18, this.gfS);
            if (this.gfT != null) {
                aVar.g(19, this.gfT);
            }
            if (this.gfU != null) {
                aVar.g(20, this.gfU);
            }
            if (this.gfV != null) {
                aVar.g(21, this.gfV);
            }
            if (this.gfW == null) {
                return 0;
            }
            aVar.g(22, this.gfW);
            return 0;
        } else if (i == 1) {
            if (this.wqJ != null) {
                r0 = e.a.a.b.b.a.h(1, this.wqJ) + 0;
            } else {
                r0 = 0;
            }
            if (this.vJh != null) {
                r0 += e.a.a.b.b.a.h(2, this.vJh);
            }
            if (this.vLs != null) {
                r0 += e.a.a.b.b.a.h(3, this.vLs);
            }
            if (this.wqK != null) {
                r0 += e.a.a.b.b.a.h(4, this.wqK);
            }
            r0 = (((r0 + e.a.a.a.fR(5, this.wqL)) + e.a.a.a.fR(6, this.wqM)) + e.a.a.a.fR(7, this.wqN)) + e.a.a.a.fR(8, this.wqO);
            if (this.wqP != null) {
                r0 += e.a.a.b.b.a.h(9, this.wqP);
            }
            if (this.hvy != null) {
                r0 += e.a.a.b.b.a.h(10, this.hvy);
            }
            if (this.nfT != null) {
                r0 += e.a.a.b.b.a.h(11, this.nfT);
            }
            if (this.nfg != null) {
                r0 += e.a.a.b.b.a.h(12, this.nfg);
            }
            if (this.wqQ != null) {
                r0 += e.a.a.b.b.a.h(13, this.wqQ);
            }
            if (this.wqR != null) {
                r0 += e.a.a.b.b.a.h(14, this.wqR);
            }
            if (this.wqS != null) {
                r0 += e.a.a.b.b.a.h(15, this.wqS);
            }
            r0 = ((r0 + e.a.a.a.fR(16, this.wqT)) + e.a.a.a.fR(17, this.gfR)) + e.a.a.a.R(18, this.gfS);
            if (this.gfT != null) {
                r0 += e.a.a.b.b.a.h(19, this.gfT);
            }
            if (this.gfU != null) {
                r0 += e.a.a.b.b.a.h(20, this.gfU);
            }
            if (this.gfV != null) {
                r0 += e.a.a.b.b.a.h(21, this.gfV);
            }
            if (this.gfW != null) {
                r0 += e.a.a.b.b.a.h(22, this.gfW);
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
            ajs com_tencent_mm_protocal_c_ajs = (ajs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ajs.wqJ = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ajs.vJh = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ajs.vLs = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ajs.wqK = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ajs.wqL = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ajs.wqM = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ajs.wqN = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ajs.wqO = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ajs.wqP = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ajs.hvy = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ajs.nfT = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_ajs.nfg = aVar3.Avy.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_ajs.wqQ = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_ajs.wqR = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_ajs.wqS = aVar3.Avy.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_ajs.wqT = aVar3.Avy.ry();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_ajs.gfR = aVar3.Avy.ry();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_ajs.gfS = aVar3.Avy.rz();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_ajs.gfT = aVar3.Avy.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_ajs.gfU = aVar3.Avy.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_ajs.gfV = aVar3.Avy.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_ajs.gfW = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
