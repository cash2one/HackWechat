package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class rc extends a {
    public String fon;
    public int vPD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon != null) {
                aVar.g(1, this.fon);
            }
            aVar.fU(2, this.vPD);
            return 0;
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            return r0 + e.a.a.a.fR(2, this.vPD);
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
            rc rcVar = (rc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rcVar.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    rcVar.vPD = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
