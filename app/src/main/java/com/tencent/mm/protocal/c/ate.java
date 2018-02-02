package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ate extends a {
    public String ksU;
    public String kub;
    public int lOd;
    public String vLN;
    public String vXO;
    public String wAU;
    public int wgF;
    public int wsC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.lOd);
            if (this.kub != null) {
                aVar.g(2, this.kub);
            }
            if (this.vLN != null) {
                aVar.g(3, this.vLN);
            }
            if (this.vXO != null) {
                aVar.g(4, this.vXO);
            }
            if (this.ksU != null) {
                aVar.g(5, this.ksU);
            }
            aVar.fU(6, this.wsC);
            aVar.fU(7, this.wgF);
            if (this.wAU != null) {
                aVar.g(8, this.wAU);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.lOd) + 0;
            if (this.kub != null) {
                r0 += e.a.a.b.b.a.h(2, this.kub);
            }
            if (this.vLN != null) {
                r0 += e.a.a.b.b.a.h(3, this.vLN);
            }
            if (this.vXO != null) {
                r0 += e.a.a.b.b.a.h(4, this.vXO);
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(5, this.ksU);
            }
            r0 = (r0 + e.a.a.a.fR(6, this.wsC)) + e.a.a.a.fR(7, this.wgF);
            if (this.wAU != null) {
                return r0 + e.a.a.b.b.a.h(8, this.wAU);
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
            ate com_tencent_mm_protocal_c_ate = (ate) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ate.lOd = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ate.kub = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ate.vLN = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ate.vXO = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ate.ksU = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ate.wsC = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ate.wgF = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ate.wAU = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
