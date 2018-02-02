package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bwo extends a {
    public String hvC;
    public String wXG;
    public int wXH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wXG != null) {
                aVar.g(1, this.wXG);
            }
            if (this.hvC != null) {
                aVar.g(2, this.hvC);
            }
            aVar.fU(3, this.wXH);
            return 0;
        } else if (i == 1) {
            if (this.wXG != null) {
                r0 = e.a.a.b.b.a.h(1, this.wXG) + 0;
            } else {
                r0 = 0;
            }
            if (this.hvC != null) {
                r0 += e.a.a.b.b.a.h(2, this.hvC);
            }
            return r0 + e.a.a.a.fR(3, this.wXH);
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
            bwo com_tencent_mm_protocal_c_bwo = (bwo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bwo.wXG = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bwo.hvC = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bwo.wXH = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
