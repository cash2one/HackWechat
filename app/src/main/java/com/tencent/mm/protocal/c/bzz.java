package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bzz extends a {
    public String wZE;
    public boolean wZF;
    public int wZG;
    public int wZH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wZE != null) {
                aVar.g(1, this.wZE);
            }
            aVar.al(2, this.wZF);
            aVar.fU(3, this.wZG);
            aVar.fU(4, this.wZH);
            return 0;
        } else if (i == 1) {
            if (this.wZE != null) {
                r0 = e.a.a.b.b.a.h(1, this.wZE) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + (e.a.a.b.b.a.dX(2) + 1)) + e.a.a.a.fR(3, this.wZG)) + e.a.a.a.fR(4, this.wZH);
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
            bzz com_tencent_mm_protocal_c_bzz = (bzz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bzz.wZE = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bzz.wZF = aVar3.cJC();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bzz.wZG = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bzz.wZH = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
