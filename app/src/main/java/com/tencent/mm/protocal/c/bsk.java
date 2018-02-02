package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bsk extends a {
    public String pQt;
    public String wJu;
    public String wTF;
    public int wTG;
    public String wTH;
    public String wTI;
    public int wTJ;
    public String wTK;
    public String whR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pQt != null) {
                aVar.g(1, this.pQt);
            }
            if (this.wTF != null) {
                aVar.g(2, this.wTF);
            }
            if (this.whR != null) {
                aVar.g(3, this.whR);
            }
            aVar.fU(4, this.wTG);
            if (this.wJu != null) {
                aVar.g(5, this.wJu);
            }
            if (this.wTH != null) {
                aVar.g(6, this.wTH);
            }
            if (this.wTI != null) {
                aVar.g(7, this.wTI);
            }
            aVar.fU(8, this.wTJ);
            if (this.wTK == null) {
                return 0;
            }
            aVar.g(9, this.wTK);
            return 0;
        } else if (i == 1) {
            if (this.pQt != null) {
                r0 = e.a.a.b.b.a.h(1, this.pQt) + 0;
            } else {
                r0 = 0;
            }
            if (this.wTF != null) {
                r0 += e.a.a.b.b.a.h(2, this.wTF);
            }
            if (this.whR != null) {
                r0 += e.a.a.b.b.a.h(3, this.whR);
            }
            r0 += e.a.a.a.fR(4, this.wTG);
            if (this.wJu != null) {
                r0 += e.a.a.b.b.a.h(5, this.wJu);
            }
            if (this.wTH != null) {
                r0 += e.a.a.b.b.a.h(6, this.wTH);
            }
            if (this.wTI != null) {
                r0 += e.a.a.b.b.a.h(7, this.wTI);
            }
            r0 += e.a.a.a.fR(8, this.wTJ);
            if (this.wTK != null) {
                r0 += e.a.a.b.b.a.h(9, this.wTK);
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
            bsk com_tencent_mm_protocal_c_bsk = (bsk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bsk.pQt = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bsk.wTF = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bsk.whR = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bsk.wTG = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bsk.wJu = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bsk.wTH = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bsk.wTI = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bsk.wTJ = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bsk.wTK = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
