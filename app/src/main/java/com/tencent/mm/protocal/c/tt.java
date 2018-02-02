package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class tt extends a {
    public String wbA;
    public String wbM;
    public String wbN;
    public int wbO;
    public int wbP;
    public String wbQ;
    public String wbR;
    public int wby;
    public String wbz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wby);
            if (this.wbz != null) {
                aVar.g(2, this.wbz);
            }
            if (this.wbM != null) {
                aVar.g(3, this.wbM);
            }
            if (this.wbN != null) {
                aVar.g(4, this.wbN);
            }
            aVar.fU(5, this.wbO);
            aVar.fU(6, this.wbP);
            if (this.wbQ != null) {
                aVar.g(7, this.wbQ);
            }
            if (this.wbA != null) {
                aVar.g(8, this.wbA);
            }
            if (this.wbR != null) {
                aVar.g(9, this.wbR);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wby) + 0;
            if (this.wbz != null) {
                r0 += e.a.a.b.b.a.h(2, this.wbz);
            }
            if (this.wbM != null) {
                r0 += e.a.a.b.b.a.h(3, this.wbM);
            }
            if (this.wbN != null) {
                r0 += e.a.a.b.b.a.h(4, this.wbN);
            }
            r0 = (r0 + e.a.a.a.fR(5, this.wbO)) + e.a.a.a.fR(6, this.wbP);
            if (this.wbQ != null) {
                r0 += e.a.a.b.b.a.h(7, this.wbQ);
            }
            if (this.wbA != null) {
                r0 += e.a.a.b.b.a.h(8, this.wbA);
            }
            if (this.wbR != null) {
                return r0 + e.a.a.b.b.a.h(9, this.wbR);
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
            tt ttVar = (tt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ttVar.wby = aVar3.Avy.ry();
                    return 0;
                case 2:
                    ttVar.wbz = aVar3.Avy.readString();
                    return 0;
                case 3:
                    ttVar.wbM = aVar3.Avy.readString();
                    return 0;
                case 4:
                    ttVar.wbN = aVar3.Avy.readString();
                    return 0;
                case 5:
                    ttVar.wbO = aVar3.Avy.ry();
                    return 0;
                case 6:
                    ttVar.wbP = aVar3.Avy.ry();
                    return 0;
                case 7:
                    ttVar.wbQ = aVar3.Avy.readString();
                    return 0;
                case 8:
                    ttVar.wbA = aVar3.Avy.readString();
                    return 0;
                case 9:
                    ttVar.wbR = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
