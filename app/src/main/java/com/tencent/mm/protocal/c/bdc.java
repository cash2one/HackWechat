package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bdc extends a {
    public int vgO;
    public int wFj;
    public int wJj;
    public int wJl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wFj);
            aVar.fU(2, this.wJl);
            aVar.fU(3, this.wJj);
            aVar.fU(4, this.vgO);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.a.fR(1, this.wFj) + 0) + e.a.a.a.fR(2, this.wJl)) + e.a.a.a.fR(3, this.wJj)) + e.a.a.a.fR(4, this.vgO);
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
                bdc com_tencent_mm_protocal_c_bdc = (bdc) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bdc.wFj = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bdc.wJl = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_bdc.wJj = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_bdc.vgO = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
