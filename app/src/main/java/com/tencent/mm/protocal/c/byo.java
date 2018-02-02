package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class byo extends a {
    public long wYH;
    public boolean wYL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.wYH);
            aVar.al(2, this.wYL);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.R(1, this.wYH) + 0) + (e.a.a.b.b.a.dX(2) + 1);
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
                byo com_tencent_mm_protocal_c_byo = (byo) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_byo.wYH = aVar3.Avy.rz();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_byo.wYL = aVar3.cJC();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
