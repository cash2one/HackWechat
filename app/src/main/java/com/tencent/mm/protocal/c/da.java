package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class da extends a {
    public String nfn;
    public String nhz;
    public int vIl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfn != null) {
                aVar.g(1, this.nfn);
            }
            aVar.fU(2, this.vIl);
            if (this.nhz == null) {
                return 0;
            }
            aVar.g(3, this.nhz);
            return 0;
        } else if (i == 1) {
            if (this.nfn != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfn) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.vIl);
            if (this.nhz != null) {
                r0 += e.a.a.b.b.a.h(3, this.nhz);
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
            da daVar = (da) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    daVar.nfn = aVar3.Avy.readString();
                    return 0;
                case 2:
                    daVar.vIl = aVar3.Avy.ry();
                    return 0;
                case 3:
                    daVar.nhz = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
