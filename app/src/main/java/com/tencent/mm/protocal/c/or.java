package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class or extends a {
    public String aAM;
    public long vXx;
    public String vXy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.aAM == null) {
                throw new b("Not all required fields were included: key");
            }
            if (this.aAM != null) {
                aVar.g(1, this.aAM);
            }
            aVar.S(2, this.vXx);
            if (this.vXy == null) {
                return 0;
            }
            aVar.g(3, this.vXy);
            return 0;
        } else if (i == 1) {
            if (this.aAM != null) {
                r0 = e.a.a.b.b.a.h(1, this.aAM) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.R(2, this.vXx);
            if (this.vXy != null) {
                r0 += e.a.a.b.b.a.h(3, this.vXy);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.aAM != null) {
                return 0;
            }
            throw new b("Not all required fields were included: key");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            or orVar = (or) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    orVar.aAM = aVar3.Avy.readString();
                    return 0;
                case 2:
                    orVar.vXx = aVar3.Avy.rz();
                    return 0;
                case 3:
                    orVar.vXy = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
