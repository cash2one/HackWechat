package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class cbi extends a {
    public int vGO;
    public int wwD;
    public int xay;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wwD);
            aVar.fU(2, this.vGO);
            aVar.fU(3, this.xay);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.fR(1, this.wwD) + 0) + e.a.a.a.fR(2, this.vGO)) + e.a.a.a.fR(3, this.xay);
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
                cbi com_tencent_mm_protocal_c_cbi = (cbi) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_cbi.wwD = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_cbi.vGO = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_cbi.xay = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
