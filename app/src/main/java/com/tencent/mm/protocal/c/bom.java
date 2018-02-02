package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bom extends a {
    public String nBM;
    public String oZz;
    public String pHK;
    public String pHL;
    public String pHM;
    public String pHN;
    public String pHq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pHK != null) {
                aVar.g(1, this.pHK);
            }
            if (this.pHL != null) {
                aVar.g(2, this.pHL);
            }
            if (this.pHq != null) {
                aVar.g(3, this.pHq);
            }
            if (this.nBM != null) {
                aVar.g(4, this.nBM);
            }
            if (this.oZz != null) {
                aVar.g(5, this.oZz);
            }
            if (this.pHM != null) {
                aVar.g(6, this.pHM);
            }
            if (this.pHN == null) {
                return 0;
            }
            aVar.g(7, this.pHN);
            return 0;
        } else if (i == 1) {
            if (this.pHK != null) {
                r0 = e.a.a.b.b.a.h(1, this.pHK) + 0;
            } else {
                r0 = 0;
            }
            if (this.pHL != null) {
                r0 += e.a.a.b.b.a.h(2, this.pHL);
            }
            if (this.pHq != null) {
                r0 += e.a.a.b.b.a.h(3, this.pHq);
            }
            if (this.nBM != null) {
                r0 += e.a.a.b.b.a.h(4, this.nBM);
            }
            if (this.oZz != null) {
                r0 += e.a.a.b.b.a.h(5, this.oZz);
            }
            if (this.pHM != null) {
                r0 += e.a.a.b.b.a.h(6, this.pHM);
            }
            if (this.pHN != null) {
                r0 += e.a.a.b.b.a.h(7, this.pHN);
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
            bom com_tencent_mm_protocal_c_bom = (bom) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bom.pHK = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bom.pHL = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bom.pHq = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bom.nBM = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bom.oZz = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bom.pHM = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bom.pHN = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
