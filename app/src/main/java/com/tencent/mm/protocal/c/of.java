package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class of extends a {
    public String ktA;
    public int rYW;
    public String vXf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vXf == null) {
                throw new b("Not all required fields were included: PkgId");
            }
            if (this.vXf != null) {
                aVar.g(1, this.vXf);
            }
            if (this.ktA != null) {
                aVar.g(2, this.ktA);
            }
            aVar.fU(3, this.rYW);
            return 0;
        } else if (i == 1) {
            if (this.vXf != null) {
                r0 = e.a.a.b.b.a.h(1, this.vXf) + 0;
            } else {
                r0 = 0;
            }
            if (this.ktA != null) {
                r0 += e.a.a.b.b.a.h(2, this.ktA);
            }
            return r0 + e.a.a.a.fR(3, this.rYW);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vXf != null) {
                return 0;
            }
            throw new b("Not all required fields were included: PkgId");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            of ofVar = (of) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ofVar.vXf = aVar3.Avy.readString();
                    return 0;
                case 2:
                    ofVar.ktA = aVar3.Avy.readString();
                    return 0;
                case 3:
                    ofVar.rYW = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
