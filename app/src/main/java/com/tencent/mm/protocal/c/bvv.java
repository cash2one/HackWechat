package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bvv extends a {
    public long wXa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).S(1, this.wXa);
            return 0;
        } else if (i == 1) {
            return e.a.a.a.R(1, this.wXa) + 0;
        } else {
            if (i == 2) {
                e.a.a.a.a aVar = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
                    if (!super.a(aVar, this, a)) {
                        aVar.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
                bvv com_tencent_mm_protocal_c_bvv = (bvv) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bvv.wXa = aVar2.Avy.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
