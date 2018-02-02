package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class brs extends a {
    public String ksY;
    public String nfT;
    public String niZ;
    public String vJA;
    public String vXI;
    public String wDj;
    public long wTp;
    public String wqK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vXI != null) {
                aVar.g(1, this.vXI);
            }
            if (this.vJA != null) {
                aVar.g(2, this.vJA);
            }
            if (this.wDj != null) {
                aVar.g(3, this.wDj);
            }
            if (this.niZ != null) {
                aVar.g(4, this.niZ);
            }
            if (this.ksY != null) {
                aVar.g(5, this.ksY);
            }
            if (this.nfT != null) {
                aVar.g(6, this.nfT);
            }
            if (this.wqK != null) {
                aVar.g(7, this.wqK);
            }
            aVar.S(8, this.wTp);
            return 0;
        } else if (i == 1) {
            if (this.vXI != null) {
                r0 = e.a.a.b.b.a.h(1, this.vXI) + 0;
            } else {
                r0 = 0;
            }
            if (this.vJA != null) {
                r0 += e.a.a.b.b.a.h(2, this.vJA);
            }
            if (this.wDj != null) {
                r0 += e.a.a.b.b.a.h(3, this.wDj);
            }
            if (this.niZ != null) {
                r0 += e.a.a.b.b.a.h(4, this.niZ);
            }
            if (this.ksY != null) {
                r0 += e.a.a.b.b.a.h(5, this.ksY);
            }
            if (this.nfT != null) {
                r0 += e.a.a.b.b.a.h(6, this.nfT);
            }
            if (this.wqK != null) {
                r0 += e.a.a.b.b.a.h(7, this.wqK);
            }
            return r0 + e.a.a.a.R(8, this.wTp);
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
            brs com_tencent_mm_protocal_c_brs = (brs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_brs.vXI = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_brs.vJA = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_brs.wDj = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_brs.niZ = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_brs.ksY = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_brs.nfT = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_brs.wqK = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_brs.wTp = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
