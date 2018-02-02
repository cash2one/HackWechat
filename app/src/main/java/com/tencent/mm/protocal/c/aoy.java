package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class aoy extends a {
    public float biF;
    public String country;
    public String hvv;
    public String nTe;
    public String rue;
    public int rug;
    public int rui;
    public int score;
    public float vQt;
    public float vQu;
    public String wvH;
    public String wvI;
    public int wvJ;
    public int wvK;
    public b wvL;
    public String wvM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.m(1, this.vQt);
            aVar.m(2, this.vQu);
            if (this.hvv != null) {
                aVar.g(3, this.hvv);
            }
            if (this.nTe != null) {
                aVar.g(4, this.nTe);
            }
            if (this.rue != null) {
                aVar.g(5, this.rue);
            }
            if (this.wvH != null) {
                aVar.g(6, this.wvH);
            }
            aVar.fU(7, this.rug);
            if (this.wvI != null) {
                aVar.g(8, this.wvI);
            }
            aVar.fU(9, this.wvJ);
            aVar.fU(10, this.wvK);
            aVar.fU(11, this.rui);
            aVar.m(12, this.biF);
            if (this.wvL != null) {
                aVar.b(13, this.wvL);
            }
            aVar.fU(14, this.score);
            if (this.wvM != null) {
                aVar.g(15, this.wvM);
            }
            if (this.country != null) {
                aVar.g(16, this.country);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((e.a.a.b.b.a.dX(1) + 4) + 0) + (e.a.a.b.b.a.dX(2) + 4);
            if (this.hvv != null) {
                r0 += e.a.a.b.b.a.h(3, this.hvv);
            }
            if (this.nTe != null) {
                r0 += e.a.a.b.b.a.h(4, this.nTe);
            }
            if (this.rue != null) {
                r0 += e.a.a.b.b.a.h(5, this.rue);
            }
            if (this.wvH != null) {
                r0 += e.a.a.b.b.a.h(6, this.wvH);
            }
            r0 += e.a.a.a.fR(7, this.rug);
            if (this.wvI != null) {
                r0 += e.a.a.b.b.a.h(8, this.wvI);
            }
            r0 = (((r0 + e.a.a.a.fR(9, this.wvJ)) + e.a.a.a.fR(10, this.wvK)) + e.a.a.a.fR(11, this.rui)) + (e.a.a.b.b.a.dX(12) + 4);
            if (this.wvL != null) {
                r0 += e.a.a.a.a(13, this.wvL);
            }
            r0 += e.a.a.a.fR(14, this.score);
            if (this.wvM != null) {
                r0 += e.a.a.b.b.a.h(15, this.wvM);
            }
            if (this.country != null) {
                return r0 + e.a.a.b.b.a.h(16, this.country);
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
            aoy com_tencent_mm_protocal_c_aoy = (aoy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aoy.vQt = aVar3.Avy.readFloat();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aoy.vQu = aVar3.Avy.readFloat();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aoy.hvv = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aoy.nTe = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aoy.rue = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aoy.wvH = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aoy.rug = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aoy.wvI = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aoy.wvJ = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aoy.wvK = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aoy.rui = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aoy.biF = aVar3.Avy.readFloat();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aoy.wvL = aVar3.cJD();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aoy.score = aVar3.Avy.ry();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_aoy.wvM = aVar3.Avy.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_aoy.country = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
