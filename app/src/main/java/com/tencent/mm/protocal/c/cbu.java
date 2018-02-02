package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class cbu extends a {
    public int xaO;
    public boolean xaP;
    public boolean xaQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.xaO);
            aVar.al(2, this.xaP);
            aVar.al(3, this.xaQ);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.fR(1, this.xaO) + 0) + (e.a.a.b.b.a.dX(2) + 1)) + (e.a.a.b.b.a.dX(3) + 1);
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
                cbu com_tencent_mm_protocal_c_cbu = (cbu) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_cbu.xaO = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_cbu.xaP = aVar3.cJC();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_cbu.xaQ = aVar3.cJC();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
