package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class aum extends a {
    public String nfJ;
    public String nfn;
    public int nfu;
    public String niZ;
    public String vFW;
    public String vFY;
    public String vMZ;
    public int vNa;
    public String wCq;
    public String wCr;
    public String wCs;
    public String wCt;
    public String wCu;
    public String wCv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfn != null) {
                aVar.g(1, this.nfn);
            }
            if (this.niZ != null) {
                aVar.g(2, this.niZ);
            }
            if (this.wCq != null) {
                aVar.g(3, this.wCq);
            }
            if (this.vFW != null) {
                aVar.g(4, this.vFW);
            }
            if (this.nfJ != null) {
                aVar.g(5, this.nfJ);
            }
            aVar.fU(6, this.vNa);
            if (this.wCr != null) {
                aVar.g(7, this.wCr);
            }
            if (this.vFY != null) {
                aVar.g(8, this.vFY);
            }
            if (this.vMZ != null) {
                aVar.g(9, this.vMZ);
            }
            if (this.wCs != null) {
                aVar.g(10, this.wCs);
            }
            if (this.wCt != null) {
                aVar.g(11, this.wCt);
            }
            if (this.wCu != null) {
                aVar.g(12, this.wCu);
            }
            if (this.wCv != null) {
                aVar.g(13, this.wCv);
            }
            aVar.fU(14, this.nfu);
            return 0;
        } else if (i == 1) {
            if (this.nfn != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfn) + 0;
            } else {
                r0 = 0;
            }
            if (this.niZ != null) {
                r0 += e.a.a.b.b.a.h(2, this.niZ);
            }
            if (this.wCq != null) {
                r0 += e.a.a.b.b.a.h(3, this.wCq);
            }
            if (this.vFW != null) {
                r0 += e.a.a.b.b.a.h(4, this.vFW);
            }
            if (this.nfJ != null) {
                r0 += e.a.a.b.b.a.h(5, this.nfJ);
            }
            r0 += e.a.a.a.fR(6, this.vNa);
            if (this.wCr != null) {
                r0 += e.a.a.b.b.a.h(7, this.wCr);
            }
            if (this.vFY != null) {
                r0 += e.a.a.b.b.a.h(8, this.vFY);
            }
            if (this.vMZ != null) {
                r0 += e.a.a.b.b.a.h(9, this.vMZ);
            }
            if (this.wCs != null) {
                r0 += e.a.a.b.b.a.h(10, this.wCs);
            }
            if (this.wCt != null) {
                r0 += e.a.a.b.b.a.h(11, this.wCt);
            }
            if (this.wCu != null) {
                r0 += e.a.a.b.b.a.h(12, this.wCu);
            }
            if (this.wCv != null) {
                r0 += e.a.a.b.b.a.h(13, this.wCv);
            }
            return r0 + e.a.a.a.fR(14, this.nfu);
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
            aum com_tencent_mm_protocal_c_aum = (aum) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aum.nfn = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aum.niZ = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aum.wCq = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aum.vFW = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aum.nfJ = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aum.vNa = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aum.wCr = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aum.vFY = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aum.vMZ = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aum.wCs = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aum.wCt = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aum.wCu = aVar3.Avy.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aum.wCv = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aum.nfu = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
