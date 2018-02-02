package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class akk extends a {
    public int ktH;
    public String nfX;
    public String nfp;
    public String vQA;
    public String vQE;
    public String vZL;
    public String waP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.waP != null) {
                aVar.g(1, this.waP);
            }
            if (this.nfp != null) {
                aVar.g(2, this.nfp);
            }
            aVar.fU(3, this.ktH);
            if (this.vZL != null) {
                aVar.g(4, this.vZL);
            }
            if (this.vQE != null) {
                aVar.g(5, this.vQE);
            }
            if (this.vQA != null) {
                aVar.g(6, this.vQA);
            }
            if (this.nfX == null) {
                return 0;
            }
            aVar.g(7, this.nfX);
            return 0;
        } else if (i == 1) {
            if (this.waP != null) {
                r0 = e.a.a.b.b.a.h(1, this.waP) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfp != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfp);
            }
            r0 += e.a.a.a.fR(3, this.ktH);
            if (this.vZL != null) {
                r0 += e.a.a.b.b.a.h(4, this.vZL);
            }
            if (this.vQE != null) {
                r0 += e.a.a.b.b.a.h(5, this.vQE);
            }
            if (this.vQA != null) {
                r0 += e.a.a.b.b.a.h(6, this.vQA);
            }
            if (this.nfX != null) {
                r0 += e.a.a.b.b.a.h(7, this.nfX);
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
            akk com_tencent_mm_protocal_c_akk = (akk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_akk.waP = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_akk.nfp = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_akk.ktH = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_akk.vZL = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_akk.vQE = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_akk.vQA = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_akk.nfX = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
