package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bia extends a {
    public String fGU;
    public String fGV;
    public String kJN;
    public String vEG;
    public String vEH;
    public int vEI;
    public String wLD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fGU != null) {
                aVar.g(1, this.fGU);
            }
            if (this.kJN != null) {
                aVar.g(2, this.kJN);
            }
            if (this.fGV != null) {
                aVar.g(3, this.fGV);
            }
            if (this.vEG != null) {
                aVar.g(4, this.vEG);
            }
            if (this.vEH != null) {
                aVar.g(5, this.vEH);
            }
            aVar.fU(6, this.vEI);
            if (this.wLD == null) {
                return 0;
            }
            aVar.g(7, this.wLD);
            return 0;
        } else if (i == 1) {
            if (this.fGU != null) {
                r0 = e.a.a.b.b.a.h(1, this.fGU) + 0;
            } else {
                r0 = 0;
            }
            if (this.kJN != null) {
                r0 += e.a.a.b.b.a.h(2, this.kJN);
            }
            if (this.fGV != null) {
                r0 += e.a.a.b.b.a.h(3, this.fGV);
            }
            if (this.vEG != null) {
                r0 += e.a.a.b.b.a.h(4, this.vEG);
            }
            if (this.vEH != null) {
                r0 += e.a.a.b.b.a.h(5, this.vEH);
            }
            r0 += e.a.a.a.fR(6, this.vEI);
            if (this.wLD != null) {
                r0 += e.a.a.b.b.a.h(7, this.wLD);
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
            bia com_tencent_mm_protocal_c_bia = (bia) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bia.fGU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bia.kJN = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bia.fGV = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bia.vEG = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bia.vEH = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bia.vEI = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bia.wLD = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
