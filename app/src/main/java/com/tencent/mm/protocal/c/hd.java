package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class hd extends a {
    public b vMO;
    public b vMP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vMO != null) {
                aVar.b(1, this.vMO);
            }
            if (this.vMP == null) {
                return 0;
            }
            aVar.b(2, this.vMP);
            return 0;
        } else if (i == 1) {
            if (this.vMO != null) {
                r0 = e.a.a.a.a(1, this.vMO) + 0;
            } else {
                r0 = 0;
            }
            if (this.vMP != null) {
                r0 += e.a.a.a.a(2, this.vMP);
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
            hd hdVar = (hd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hdVar.vMO = aVar3.cJD();
                    return 0;
                case 2:
                    hdVar.vMP = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
