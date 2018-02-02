package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class boq extends a {
    public int vJU;
    public int wQZ;
    public String wRc;
    public String wRd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wQZ);
            if (this.wRc != null) {
                aVar.g(2, this.wRc);
            }
            aVar.fU(3, this.vJU);
            if (this.wRd != null) {
                aVar.g(4, this.wRd);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wQZ) + 0;
            if (this.wRc != null) {
                r0 += e.a.a.b.b.a.h(2, this.wRc);
            }
            r0 += e.a.a.a.fR(3, this.vJU);
            if (this.wRd != null) {
                return r0 + e.a.a.b.b.a.h(4, this.wRd);
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
            boq com_tencent_mm_protocal_c_boq = (boq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_boq.wQZ = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_boq.wRc = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_boq.vJU = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_boq.wRd = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
