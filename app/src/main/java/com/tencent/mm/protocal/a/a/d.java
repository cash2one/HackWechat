package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class d extends a {
    public int count;
    public int qox;
    public int vCa;
    public b vCj;
    public int vCk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vCj == null) {
                throw new e.a.a.b("Not all required fields were included: value");
            }
            aVar.fU(1, this.vCa);
            if (this.vCj != null) {
                aVar.b(2, this.vCj);
            }
            aVar.fU(3, this.vCk);
            aVar.fU(4, this.qox);
            aVar.fU(5, this.count);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vCa) + 0;
            if (this.vCj != null) {
                r0 += e.a.a.a.a(2, this.vCj);
            }
            return ((r0 + e.a.a.a.fR(3, this.vCk)) + e.a.a.a.fR(4, this.qox)) + e.a.a.a.fR(5, this.count);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vCj != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: value");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.vCa = aVar3.Avy.ry();
                    return 0;
                case 2:
                    dVar.vCj = aVar3.cJD();
                    return 0;
                case 3:
                    dVar.vCk = aVar3.Avy.ry();
                    return 0;
                case 4:
                    dVar.qox = aVar3.Avy.ry();
                    return 0;
                case 5:
                    dVar.count = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
