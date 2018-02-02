package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class cbo extends a {
    public String wRC;
    public int xaB;
    public int xaC;
    public String xaD;
    public String xaE;
    public int xaF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.xaB);
            aVar.fU(2, this.xaC);
            if (this.wRC != null) {
                aVar.g(3, this.wRC);
            }
            if (this.xaD != null) {
                aVar.g(4, this.xaD);
            }
            if (this.xaE != null) {
                aVar.g(5, this.xaE);
            }
            aVar.fU(6, this.xaF);
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.fR(1, this.xaB) + 0) + e.a.a.a.fR(2, this.xaC);
            if (this.wRC != null) {
                r0 += e.a.a.b.b.a.h(3, this.wRC);
            }
            if (this.xaD != null) {
                r0 += e.a.a.b.b.a.h(4, this.xaD);
            }
            if (this.xaE != null) {
                r0 += e.a.a.b.b.a.h(5, this.xaE);
            }
            return r0 + e.a.a.a.fR(6, this.xaF);
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
            cbo com_tencent_mm_protocal_c_cbo = (cbo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_cbo.xaB = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_cbo.xaC = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_cbo.wRC = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_cbo.xaD = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_cbo.xaE = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_cbo.xaF = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
