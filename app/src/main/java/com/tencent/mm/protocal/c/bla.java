package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bla extends a {
    public int hvE;
    public String hvF;
    public long hvG;
    public int wOs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.hvE);
            if (this.hvF != null) {
                aVar.g(2, this.hvF);
            }
            aVar.S(3, this.hvG);
            aVar.fU(4, this.wOs);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.hvE) + 0;
            if (this.hvF != null) {
                r0 += e.a.a.b.b.a.h(2, this.hvF);
            }
            return (r0 + e.a.a.a.R(3, this.hvG)) + e.a.a.a.fR(4, this.wOs);
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
            bla com_tencent_mm_protocal_c_bla = (bla) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bla.hvE = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bla.hvF = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bla.hvG = aVar3.Avy.rz();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bla.wOs = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
