package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class k extends a {
    public long fLR;
    public int state;
    public String title;
    public String vCW;
    public String vCX;
    public String vDg;
    public int vDh;
    public String vDi;
    public String vDj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vCW != null) {
                aVar.g(1, this.vCW);
            }
            if (this.title != null) {
                aVar.g(2, this.title);
            }
            aVar.S(3, this.fLR);
            if (this.vDg != null) {
                aVar.g(5, this.vDg);
            }
            aVar.fU(10, this.state);
            aVar.fU(11, this.vDh);
            if (this.vDi != null) {
                aVar.g(12, this.vDi);
            }
            if (this.vCX != null) {
                aVar.g(13, this.vCX);
            }
            if (this.vDj == null) {
                return 0;
            }
            aVar.g(14, this.vDj);
            return 0;
        } else if (i == 1) {
            if (this.vCW != null) {
                r0 = e.a.a.b.b.a.h(1, this.vCW) + 0;
            } else {
                r0 = 0;
            }
            if (this.title != null) {
                r0 += e.a.a.b.b.a.h(2, this.title);
            }
            r0 += e.a.a.a.R(3, this.fLR);
            if (this.vDg != null) {
                r0 += e.a.a.b.b.a.h(5, this.vDg);
            }
            r0 = (r0 + e.a.a.a.fR(10, this.state)) + e.a.a.a.fR(11, this.vDh);
            if (this.vDi != null) {
                r0 += e.a.a.b.b.a.h(12, this.vDi);
            }
            if (this.vCX != null) {
                r0 += e.a.a.b.b.a.h(13, this.vCX);
            }
            if (this.vDj != null) {
                r0 += e.a.a.b.b.a.h(14, this.vDj);
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
            k kVar = (k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kVar.vCW = aVar3.Avy.readString();
                    return 0;
                case 2:
                    kVar.title = aVar3.Avy.readString();
                    return 0;
                case 3:
                    kVar.fLR = aVar3.Avy.rz();
                    return 0;
                case 5:
                    kVar.vDg = aVar3.Avy.readString();
                    return 0;
                case 10:
                    kVar.state = aVar3.Avy.ry();
                    return 0;
                case 11:
                    kVar.vDh = aVar3.Avy.ry();
                    return 0;
                case 12:
                    kVar.vDi = aVar3.Avy.readString();
                    return 0;
                case 13:
                    kVar.vCX = aVar3.Avy.readString();
                    return 0;
                case 14:
                    kVar.vDj = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
