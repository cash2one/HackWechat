package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class pr extends a {
    public int hvH;
    public String hvI;
    public String hvJ;
    public String hvK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.hvH);
            if (this.hvI != null) {
                aVar.g(2, this.hvI);
            }
            if (this.hvJ != null) {
                aVar.g(3, this.hvJ);
            }
            if (this.hvK != null) {
                aVar.g(4, this.hvK);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.hvH) + 0;
            if (this.hvI != null) {
                r0 += e.a.a.b.b.a.h(2, this.hvI);
            }
            if (this.hvJ != null) {
                r0 += e.a.a.b.b.a.h(3, this.hvJ);
            }
            if (this.hvK != null) {
                return r0 + e.a.a.b.b.a.h(4, this.hvK);
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
            pr prVar = (pr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    prVar.hvH = aVar3.Avy.ry();
                    return 0;
                case 2:
                    prVar.hvI = aVar3.Avy.readString();
                    return 0;
                case 3:
                    prVar.hvJ = aVar3.Avy.readString();
                    return 0;
                case 4:
                    prVar.hvK = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
