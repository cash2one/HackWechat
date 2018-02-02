package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class k extends a {
    public int ksS;
    public int ksT;
    public String ksU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ksU == null) {
                throw new b("Not all required fields were included: UserName");
            }
            aVar.fU(1, this.ksS);
            aVar.fU(2, this.ksT);
            if (this.ksU != null) {
                aVar.g(3, this.ksU);
            }
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.fR(1, this.ksS) + 0) + e.a.a.a.fR(2, this.ksT);
            if (this.ksU != null) {
                return r0 + e.a.a.b.b.a.h(3, this.ksU);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.ksU != null) {
                return 0;
            }
            throw new b("Not all required fields were included: UserName");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kVar.ksS = aVar3.Avy.ry();
                    return 0;
                case 2:
                    kVar.ksT = aVar3.Avy.ry();
                    return 0;
                case 3:
                    kVar.ksU = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
