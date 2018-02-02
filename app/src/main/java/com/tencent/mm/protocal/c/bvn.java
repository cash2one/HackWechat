package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class bvn extends a {
    public String category;
    public int hOH;
    public b vZC;
    public int wWO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.hOH);
            aVar.fU(2, this.wWO);
            if (this.category != null) {
                aVar.g(3, this.category);
            }
            if (this.vZC != null) {
                aVar.b(4, this.vZC);
            }
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.fR(1, this.hOH) + 0) + e.a.a.a.fR(2, this.wWO);
            if (this.category != null) {
                r0 += e.a.a.b.b.a.h(3, this.category);
            }
            if (this.vZC != null) {
                return r0 + e.a.a.a.a(4, this.vZC);
            }
            return r0;
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
            bvn com_tencent_mm_protocal_c_bvn = (bvn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bvn.hOH = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bvn.wWO = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bvn.category = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bvn.vZC = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
