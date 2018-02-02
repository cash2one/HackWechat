package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class anv extends a {
    public int wgQ;
    public int wuJ;
    public String wuK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wuJ);
            if (this.wuK != null) {
                aVar.g(2, this.wuK);
            }
            aVar.fU(3, this.wgQ);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wuJ) + 0;
            if (this.wuK != null) {
                r0 += e.a.a.b.b.a.h(2, this.wuK);
            }
            return r0 + e.a.a.a.fR(3, this.wgQ);
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
            anv com_tencent_mm_protocal_c_anv = (anv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_anv.wuJ = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_anv.wuK = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_anv.wgQ = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
