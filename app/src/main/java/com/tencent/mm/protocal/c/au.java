package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class au extends a {
    public String fWp;
    public String fWq;
    public double latitude;
    public double longitude;
    public long vFO;
    public String vFP;
    public String vFQ;
    public String vFR;
    public String vFS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fWp != null) {
                aVar.g(1, this.fWp);
            }
            if (this.fWq != null) {
                aVar.g(2, this.fWq);
            }
            aVar.b(3, this.latitude);
            aVar.b(4, this.longitude);
            aVar.S(5, this.vFO);
            if (this.vFP != null) {
                aVar.g(6, this.vFP);
            }
            if (this.vFQ != null) {
                aVar.g(7, this.vFQ);
            }
            if (this.vFR != null) {
                aVar.g(8, this.vFR);
            }
            if (this.vFS == null) {
                return 0;
            }
            aVar.g(9, this.vFS);
            return 0;
        } else if (i == 1) {
            if (this.fWp != null) {
                r0 = e.a.a.b.b.a.h(1, this.fWp) + 0;
            } else {
                r0 = 0;
            }
            if (this.fWq != null) {
                r0 += e.a.a.b.b.a.h(2, this.fWq);
            }
            r0 = ((r0 + (e.a.a.b.b.a.dX(3) + 8)) + (e.a.a.b.b.a.dX(4) + 8)) + e.a.a.a.R(5, this.vFO);
            if (this.vFP != null) {
                r0 += e.a.a.b.b.a.h(6, this.vFP);
            }
            if (this.vFQ != null) {
                r0 += e.a.a.b.b.a.h(7, this.vFQ);
            }
            if (this.vFR != null) {
                r0 += e.a.a.b.b.a.h(8, this.vFR);
            }
            if (this.vFS != null) {
                r0 += e.a.a.b.b.a.h(9, this.vFS);
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
            au auVar = (au) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    auVar.fWp = aVar3.Avy.readString();
                    return 0;
                case 2:
                    auVar.fWq = aVar3.Avy.readString();
                    return 0;
                case 3:
                    auVar.latitude = aVar3.Avy.readDouble();
                    return 0;
                case 4:
                    auVar.longitude = aVar3.Avy.readDouble();
                    return 0;
                case 5:
                    auVar.vFO = aVar3.Avy.rz();
                    return 0;
                case 6:
                    auVar.vFP = aVar3.Avy.readString();
                    return 0;
                case 7:
                    auVar.vFQ = aVar3.Avy.readString();
                    return 0;
                case 8:
                    auVar.vFR = aVar3.Avy.readString();
                    return 0;
                case 9:
                    auVar.vFS = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
