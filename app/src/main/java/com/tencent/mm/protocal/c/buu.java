package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class buu extends a {
    public int wWr;
    public int wWs;
    public int wWt;
    public int wWu;
    public int wWv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wWr);
            aVar.fU(2, this.wWs);
            aVar.fU(3, this.wWt);
            aVar.fU(4, this.wWu);
            aVar.fU(5, this.wWv);
            return 0;
        } else if (i == 1) {
            return ((((e.a.a.a.fR(1, this.wWr) + 0) + e.a.a.a.fR(2, this.wWs)) + e.a.a.a.fR(3, this.wWt)) + e.a.a.a.fR(4, this.wWu)) + e.a.a.a.fR(5, this.wWv);
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
                buu com_tencent_mm_protocal_c_buu = (buu) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_buu.wWr = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_buu.wWs = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_buu.wWt = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_buu.wWu = aVar3.Avy.ry();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_buu.wWv = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
