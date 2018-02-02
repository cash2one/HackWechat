package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class tu extends a {
    public String nfp;
    public long pRd;
    public int wbS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.pRd);
            if (this.nfp != null) {
                aVar.g(2, this.nfp);
            }
            aVar.fU(3, this.wbS);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.R(1, this.pRd) + 0;
            if (this.nfp != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfp);
            }
            return r0 + e.a.a.a.fR(3, this.wbS);
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
            tu tuVar = (tu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tuVar.pRd = aVar3.Avy.rz();
                    return 0;
                case 2:
                    tuVar.nfp = aVar3.Avy.readString();
                    return 0;
                case 3:
                    tuVar.wbS = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
