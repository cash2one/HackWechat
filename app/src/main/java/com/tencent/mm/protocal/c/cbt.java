package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class cbt extends a {
    public int rYW;
    public int vNa;
    public int wtc;
    public int xaM;
    public int xaN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wtc);
            aVar.fU(2, this.vNa);
            aVar.fU(3, this.xaM);
            aVar.fU(4, this.rYW);
            aVar.fU(10, this.xaN);
            return 0;
        } else if (i == 1) {
            return ((((e.a.a.a.fR(1, this.wtc) + 0) + e.a.a.a.fR(2, this.vNa)) + e.a.a.a.fR(3, this.xaM)) + e.a.a.a.fR(4, this.rYW)) + e.a.a.a.fR(10, this.xaN);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                cbt com_tencent_mm_protocal_c_cbt = (cbt) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_cbt.wtc = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_cbt.vNa = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_cbt.xaM = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_cbt.rYW = aVar3.Avy.ry();
                        return 0;
                    case 10:
                        com_tencent_mm_protocal_c_cbt.xaN = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
