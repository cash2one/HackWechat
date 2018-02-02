package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ti extends a {
    public String nfp;
    public int nkn;
    public int vPD;
    public String waD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfp != null) {
                aVar.g(1, this.nfp);
            }
            aVar.fU(2, this.vPD);
            if (this.waD != null) {
                aVar.g(3, this.waD);
            }
            aVar.fU(4, this.nkn);
            return 0;
        } else if (i == 1) {
            if (this.nfp != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfp) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.vPD);
            if (this.waD != null) {
                r0 += e.a.a.b.b.a.h(3, this.waD);
            }
            return r0 + e.a.a.a.fR(4, this.nkn);
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
            ti tiVar = (ti) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tiVar.nfp = aVar3.Avy.readString();
                    return 0;
                case 2:
                    tiVar.vPD = aVar3.Avy.ry();
                    return 0;
                case 3:
                    tiVar.waD = aVar3.Avy.readString();
                    return 0;
                case 4:
                    tiVar.nkn = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
