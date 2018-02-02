package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class cba extends a {
    public int fIs;
    public String fIt;
    public String jIc;
    public int jIh;
    public int ktN;
    public int lOD;
    public String ngo;
    public int pQj;
    public int pQk;
    public int tlN;
    public String xai;
    public String xaj;
    public int xak;
    public String xal;
    public String xam;
    public int xan;
    public String xao;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.ktN);
            if (this.ngo != null) {
                aVar.g(2, this.ngo);
            }
            if (this.xai != null) {
                aVar.g(3, this.xai);
            }
            aVar.fU(4, this.pQj);
            aVar.fU(5, this.lOD);
            aVar.fU(6, this.pQk);
            if (this.xaj != null) {
                aVar.g(7, this.xaj);
            }
            aVar.fU(8, this.xak);
            if (this.xal != null) {
                aVar.g(9, this.xal);
            }
            if (this.xam != null) {
                aVar.g(10, this.xam);
            }
            aVar.fU(11, this.tlN);
            aVar.fU(12, this.xan);
            if (this.xao != null) {
                aVar.g(13, this.xao);
            }
            if (this.jIc != null) {
                aVar.g(14, this.jIc);
            }
            aVar.fU(15, this.fIs);
            if (this.fIt != null) {
                aVar.g(16, this.fIt);
            }
            aVar.fU(17, this.jIh);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.ktN) + 0;
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(2, this.ngo);
            }
            if (this.xai != null) {
                r0 += e.a.a.b.b.a.h(3, this.xai);
            }
            r0 = ((r0 + e.a.a.a.fR(4, this.pQj)) + e.a.a.a.fR(5, this.lOD)) + e.a.a.a.fR(6, this.pQk);
            if (this.xaj != null) {
                r0 += e.a.a.b.b.a.h(7, this.xaj);
            }
            r0 += e.a.a.a.fR(8, this.xak);
            if (this.xal != null) {
                r0 += e.a.a.b.b.a.h(9, this.xal);
            }
            if (this.xam != null) {
                r0 += e.a.a.b.b.a.h(10, this.xam);
            }
            r0 = (r0 + e.a.a.a.fR(11, this.tlN)) + e.a.a.a.fR(12, this.xan);
            if (this.xao != null) {
                r0 += e.a.a.b.b.a.h(13, this.xao);
            }
            if (this.jIc != null) {
                r0 += e.a.a.b.b.a.h(14, this.jIc);
            }
            r0 += e.a.a.a.fR(15, this.fIs);
            if (this.fIt != null) {
                r0 += e.a.a.b.b.a.h(16, this.fIt);
            }
            return r0 + e.a.a.a.fR(17, this.jIh);
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
            cba com_tencent_mm_protocal_c_cba = (cba) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_cba.ktN = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_cba.ngo = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_cba.xai = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_cba.pQj = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_cba.lOD = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_cba.pQk = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_cba.xaj = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_cba.xak = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_cba.xal = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_cba.xam = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_cba.tlN = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_cba.xan = aVar3.Avy.ry();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_cba.xao = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_cba.jIc = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_cba.fIs = aVar3.Avy.ry();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_cba.fIt = aVar3.Avy.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_cba.jIh = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
