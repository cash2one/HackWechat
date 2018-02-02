package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bkf extends a {
    public int rwT;
    public int rwU;
    public String vHY;
    public String vHZ;
    public String vIa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vHY != null) {
                aVar.g(1, this.vHY);
            }
            if (this.vHZ != null) {
                aVar.g(2, this.vHZ);
            }
            if (this.vIa != null) {
                aVar.g(3, this.vIa);
            }
            aVar.fU(4, this.rwT);
            aVar.fU(5, this.rwU);
            return 0;
        } else if (i == 1) {
            if (this.vHY != null) {
                r0 = e.a.a.b.b.a.h(1, this.vHY) + 0;
            } else {
                r0 = 0;
            }
            if (this.vHZ != null) {
                r0 += e.a.a.b.b.a.h(2, this.vHZ);
            }
            if (this.vIa != null) {
                r0 += e.a.a.b.b.a.h(3, this.vIa);
            }
            return (r0 + e.a.a.a.fR(4, this.rwT)) + e.a.a.a.fR(5, this.rwU);
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
            bkf com_tencent_mm_protocal_c_bkf = (bkf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bkf.vHY = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bkf.vHZ = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bkf.vIa = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bkf.rwT = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bkf.rwU = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
