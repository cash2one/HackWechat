package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class cs extends a {
    public int ktN;
    public String ngo;
    public int vHI;
    public String vHJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ngo != null) {
                aVar.g(1, this.ngo);
            }
            aVar.fU(2, this.ktN);
            aVar.fU(3, this.vHI);
            if (this.vHJ == null) {
                return 0;
            }
            aVar.g(4, this.vHJ);
            return 0;
        } else if (i == 1) {
            if (this.ngo != null) {
                r0 = e.a.a.b.b.a.h(1, this.ngo) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.ktN)) + e.a.a.a.fR(3, this.vHI);
            if (this.vHJ != null) {
                r0 += e.a.a.b.b.a.h(4, this.vHJ);
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
            cs csVar = (cs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    csVar.ngo = aVar3.Avy.readString();
                    return 0;
                case 2:
                    csVar.ktN = aVar3.Avy.ry();
                    return 0;
                case 3:
                    csVar.vHI = aVar3.Avy.ry();
                    return 0;
                case 4:
                    csVar.vHJ = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
