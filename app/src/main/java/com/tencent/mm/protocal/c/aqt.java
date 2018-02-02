package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class aqt extends a {
    public float wyu;
    public float wyv;
    public float wyw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.m(1, this.wyu);
            aVar.m(2, this.wyv);
            aVar.m(3, this.wyw);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.b.b.a.dX(1) + 4) + 0) + (e.a.a.b.b.a.dX(2) + 4)) + (e.a.a.b.b.a.dX(3) + 4);
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
                aqt com_tencent_mm_protocal_c_aqt = (aqt) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_aqt.wyu = aVar3.Avy.readFloat();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_aqt.wyv = aVar3.Avy.readFloat();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_aqt.wyw = aVar3.Avy.readFloat();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
