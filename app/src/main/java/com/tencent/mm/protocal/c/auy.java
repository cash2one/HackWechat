package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class auy extends a {
    public String fGU;
    public String kLC;
    public int wCK;
    public int wCL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fGU != null) {
                aVar.g(1, this.fGU);
            }
            if (this.kLC != null) {
                aVar.g(2, this.kLC);
            }
            aVar.fU(3, this.wCK);
            aVar.fU(4, this.wCL);
            return 0;
        } else if (i == 1) {
            if (this.fGU != null) {
                r0 = e.a.a.b.b.a.h(1, this.fGU) + 0;
            } else {
                r0 = 0;
            }
            if (this.kLC != null) {
                r0 += e.a.a.b.b.a.h(2, this.kLC);
            }
            return (r0 + e.a.a.a.fR(3, this.wCK)) + e.a.a.a.fR(4, this.wCL);
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
            auy com_tencent_mm_protocal_c_auy = (auy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_auy.fGU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_auy.kLC = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_auy.wCK = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_auy.wCL = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
