package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class bh extends a {
    public long vGA;
    public int vGy;
    public b vGz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vGy);
            if (this.vGz != null) {
                aVar.b(2, this.vGz);
            }
            aVar.S(3, this.vGA);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vGy) + 0;
            if (this.vGz != null) {
                r0 += e.a.a.a.a(2, this.vGz);
            }
            return r0 + e.a.a.a.R(3, this.vGA);
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
            bh bhVar = (bh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bhVar.vGy = aVar3.Avy.ry();
                    return 0;
                case 2:
                    bhVar.vGz = aVar3.cJD();
                    return 0;
                case 3:
                    bhVar.vGA = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
