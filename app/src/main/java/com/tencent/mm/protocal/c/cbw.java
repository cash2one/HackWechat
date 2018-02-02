package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class cbw extends a {
    public String nkB;
    public String nkC;
    public int nkD;
    public String nkz;
    public String vNd;
    public int xaR;
    public String xaS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.xaR);
            if (this.vNd != null) {
                aVar.g(2, this.vNd);
            }
            if (this.nkz != null) {
                aVar.g(3, this.nkz);
            }
            if (this.xaS != null) {
                aVar.g(4, this.xaS);
            }
            if (this.nkB != null) {
                aVar.g(5, this.nkB);
            }
            if (this.nkC != null) {
                aVar.g(6, this.nkC);
            }
            aVar.fU(7, this.nkD);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.xaR) + 0;
            if (this.vNd != null) {
                r0 += e.a.a.b.b.a.h(2, this.vNd);
            }
            if (this.nkz != null) {
                r0 += e.a.a.b.b.a.h(3, this.nkz);
            }
            if (this.xaS != null) {
                r0 += e.a.a.b.b.a.h(4, this.xaS);
            }
            if (this.nkB != null) {
                r0 += e.a.a.b.b.a.h(5, this.nkB);
            }
            if (this.nkC != null) {
                r0 += e.a.a.b.b.a.h(6, this.nkC);
            }
            return r0 + e.a.a.a.fR(7, this.nkD);
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
            cbw com_tencent_mm_protocal_c_cbw = (cbw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_cbw.xaR = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_cbw.vNd = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_cbw.nkz = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_cbw.xaS = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_cbw.nkB = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_cbw.nkC = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_cbw.nkD = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
