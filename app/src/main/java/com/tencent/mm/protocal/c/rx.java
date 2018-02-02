package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class rx extends a {
    public int vZS;
    public String vZT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vZT == null) {
                throw new b("Not all required fields were included: TagDesc");
            }
            aVar.fU(1, this.vZS);
            if (this.vZT != null) {
                aVar.g(2, this.vZT);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vZS) + 0;
            if (this.vZT != null) {
                return r0 + e.a.a.b.b.a.h(2, this.vZT);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vZT != null) {
                return 0;
            }
            throw new b("Not all required fields were included: TagDesc");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rx rxVar = (rx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rxVar.vZS = aVar3.Avy.ry();
                    return 0;
                case 2:
                    rxVar.vZT = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
