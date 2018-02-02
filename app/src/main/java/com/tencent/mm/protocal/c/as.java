package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class as extends a {
    public int ktN;
    public String nfT;
    public String nfp;
    public String nje;
    public String pew;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfp != null) {
                aVar.g(1, this.nfp);
            }
            if (this.pew != null) {
                aVar.g(2, this.pew);
            }
            aVar.fU(3, this.ktN);
            if (this.nje != null) {
                aVar.g(4, this.nje);
            }
            if (this.nfT == null) {
                return 0;
            }
            aVar.g(5, this.nfT);
            return 0;
        } else if (i == 1) {
            if (this.nfp != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfp) + 0;
            } else {
                r0 = 0;
            }
            if (this.pew != null) {
                r0 += e.a.a.b.b.a.h(2, this.pew);
            }
            r0 += e.a.a.a.fR(3, this.ktN);
            if (this.nje != null) {
                r0 += e.a.a.b.b.a.h(4, this.nje);
            }
            if (this.nfT != null) {
                r0 += e.a.a.b.b.a.h(5, this.nfT);
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
            as asVar = (as) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    asVar.nfp = aVar3.Avy.readString();
                    return 0;
                case 2:
                    asVar.pew = aVar3.Avy.readString();
                    return 0;
                case 3:
                    asVar.ktN = aVar3.Avy.ry();
                    return 0;
                case 4:
                    asVar.nje = aVar3.Avy.readString();
                    return 0;
                case 5:
                    asVar.nfT = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
