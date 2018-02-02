package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class aou extends a {
    public String ksU;
    public int ktm;
    public String kub;
    public String pQt;
    public String vUU;
    public String vUV;
    public String whR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pQt != null) {
                aVar.g(1, this.pQt);
            }
            if (this.ksU != null) {
                aVar.g(2, this.ksU);
            }
            aVar.fU(3, this.ktm);
            if (this.vUU != null) {
                aVar.g(4, this.vUU);
            }
            if (this.vUV != null) {
                aVar.g(5, this.vUV);
            }
            if (this.kub != null) {
                aVar.g(6, this.kub);
            }
            if (this.whR == null) {
                return 0;
            }
            aVar.g(7, this.whR);
            return 0;
        } else if (i == 1) {
            if (this.pQt != null) {
                r0 = e.a.a.b.b.a.h(1, this.pQt) + 0;
            } else {
                r0 = 0;
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(2, this.ksU);
            }
            r0 += e.a.a.a.fR(3, this.ktm);
            if (this.vUU != null) {
                r0 += e.a.a.b.b.a.h(4, this.vUU);
            }
            if (this.vUV != null) {
                r0 += e.a.a.b.b.a.h(5, this.vUV);
            }
            if (this.kub != null) {
                r0 += e.a.a.b.b.a.h(6, this.kub);
            }
            if (this.whR != null) {
                r0 += e.a.a.b.b.a.h(7, this.whR);
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
            aou com_tencent_mm_protocal_c_aou = (aou) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aou.pQt = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aou.ksU = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aou.ktm = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aou.vUU = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aou.vUV = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aou.kub = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aou.whR = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
