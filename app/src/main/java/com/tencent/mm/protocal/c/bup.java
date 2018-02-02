package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bup extends a {
    public int ktN;
    public int wWa;
    public int wWb;
    public int wWc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.ktN);
            aVar.fU(2, this.wWa);
            aVar.fU(3, this.wWb);
            aVar.fU(4, this.wWc);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.a.fR(1, this.ktN) + 0) + e.a.a.a.fR(2, this.wWa)) + e.a.a.a.fR(3, this.wWb)) + e.a.a.a.fR(4, this.wWc);
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
                bup com_tencent_mm_protocal_c_bup = (bup) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bup.ktN = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bup.wWa = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_bup.wWb = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_bup.wWc = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
