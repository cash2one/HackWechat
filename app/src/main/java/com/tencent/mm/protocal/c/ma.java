package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ma extends a {
    public String oZC;
    public int vUC;
    public String vUD;
    public String vUE;
    public String vUF;
    public int vUG;
    public String vUH;
    public int vUI;
    public String vUJ;
    public int vUK;
    public String vUL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vUC);
            if (this.vUD != null) {
                aVar.g(2, this.vUD);
            }
            if (this.vUE != null) {
                aVar.g(3, this.vUE);
            }
            if (this.vUF != null) {
                aVar.g(4, this.vUF);
            }
            aVar.fU(5, this.vUG);
            if (this.vUH != null) {
                aVar.g(6, this.vUH);
            }
            aVar.fU(7, this.vUI);
            if (this.oZC != null) {
                aVar.g(8, this.oZC);
            }
            if (this.vUJ != null) {
                aVar.g(9, this.vUJ);
            }
            aVar.fU(10, this.vUK);
            if (this.vUL != null) {
                aVar.g(11, this.vUL);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vUC) + 0;
            if (this.vUD != null) {
                r0 += e.a.a.b.b.a.h(2, this.vUD);
            }
            if (this.vUE != null) {
                r0 += e.a.a.b.b.a.h(3, this.vUE);
            }
            if (this.vUF != null) {
                r0 += e.a.a.b.b.a.h(4, this.vUF);
            }
            r0 += e.a.a.a.fR(5, this.vUG);
            if (this.vUH != null) {
                r0 += e.a.a.b.b.a.h(6, this.vUH);
            }
            r0 += e.a.a.a.fR(7, this.vUI);
            if (this.oZC != null) {
                r0 += e.a.a.b.b.a.h(8, this.oZC);
            }
            if (this.vUJ != null) {
                r0 += e.a.a.b.b.a.h(9, this.vUJ);
            }
            r0 += e.a.a.a.fR(10, this.vUK);
            if (this.vUL != null) {
                return r0 + e.a.a.b.b.a.h(11, this.vUL);
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
            ma maVar = (ma) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    maVar.vUC = aVar3.Avy.ry();
                    return 0;
                case 2:
                    maVar.vUD = aVar3.Avy.readString();
                    return 0;
                case 3:
                    maVar.vUE = aVar3.Avy.readString();
                    return 0;
                case 4:
                    maVar.vUF = aVar3.Avy.readString();
                    return 0;
                case 5:
                    maVar.vUG = aVar3.Avy.ry();
                    return 0;
                case 6:
                    maVar.vUH = aVar3.Avy.readString();
                    return 0;
                case 7:
                    maVar.vUI = aVar3.Avy.ry();
                    return 0;
                case 8:
                    maVar.oZC = aVar3.Avy.readString();
                    return 0;
                case 9:
                    maVar.vUJ = aVar3.Avy.readString();
                    return 0;
                case 10:
                    maVar.vUK = aVar3.Avy.ry();
                    return 0;
                case 11:
                    maVar.vUL = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
