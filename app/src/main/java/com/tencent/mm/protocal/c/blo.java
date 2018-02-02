package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class blo extends a {
    public String appName;
    public int blZ;
    public String wPc;
    public boolean wPd;
    public boolean wPe;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wPc != null) {
                aVar.g(1, this.wPc);
            }
            if (this.appName != null) {
                aVar.g(2, this.appName);
            }
            aVar.fU(3, this.blZ);
            aVar.al(4, this.wPd);
            aVar.al(5, this.wPe);
            return 0;
        } else if (i == 1) {
            if (this.wPc != null) {
                r0 = e.a.a.b.b.a.h(1, this.wPc) + 0;
            } else {
                r0 = 0;
            }
            if (this.appName != null) {
                r0 += e.a.a.b.b.a.h(2, this.appName);
            }
            return ((r0 + e.a.a.a.fR(3, this.blZ)) + (e.a.a.b.b.a.dX(4) + 1)) + (e.a.a.b.b.a.dX(5) + 1);
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
            blo com_tencent_mm_protocal_c_blo = (blo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_blo.wPc = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_blo.appName = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_blo.blZ = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_blo.wPd = aVar3.cJC();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_blo.wPe = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
