package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class lf extends a {
    public int cey;
    public String fGU;
    public String kNu;
    public int vUc;
    public String vUd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fGU != null) {
                aVar.g(1, this.fGU);
            }
            if (this.kNu != null) {
                aVar.g(2, this.kNu);
            }
            aVar.fU(3, this.cey);
            aVar.fU(4, this.vUc);
            if (this.vUd == null) {
                return 0;
            }
            aVar.g(5, this.vUd);
            return 0;
        } else if (i == 1) {
            if (this.fGU != null) {
                r0 = e.a.a.b.b.a.h(1, this.fGU) + 0;
            } else {
                r0 = 0;
            }
            if (this.kNu != null) {
                r0 += e.a.a.b.b.a.h(2, this.kNu);
            }
            r0 = (r0 + e.a.a.a.fR(3, this.cey)) + e.a.a.a.fR(4, this.vUc);
            if (this.vUd != null) {
                r0 += e.a.a.b.b.a.h(5, this.vUd);
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
            lf lfVar = (lf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lfVar.fGU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    lfVar.kNu = aVar3.Avy.readString();
                    return 0;
                case 3:
                    lfVar.cey = aVar3.Avy.ry();
                    return 0;
                case 4:
                    lfVar.vUc = aVar3.Avy.ry();
                    return 0;
                case 5:
                    lfVar.vUd = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
