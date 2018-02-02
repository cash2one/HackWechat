package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class kr extends a {
    public int vSA;
    public int vSB;
    public int vSC;
    public String vSx;
    public String vSy;
    public int vSz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vSx != null) {
                aVar.g(1, this.vSx);
            }
            if (this.vSy != null) {
                aVar.g(2, this.vSy);
            }
            aVar.fU(3, this.vSz);
            aVar.fU(4, this.vSA);
            aVar.fU(5, this.vSB);
            aVar.fU(6, this.vSC);
            return 0;
        } else if (i == 1) {
            if (this.vSx != null) {
                r0 = e.a.a.b.b.a.h(1, this.vSx) + 0;
            } else {
                r0 = 0;
            }
            if (this.vSy != null) {
                r0 += e.a.a.b.b.a.h(2, this.vSy);
            }
            return (((r0 + e.a.a.a.fR(3, this.vSz)) + e.a.a.a.fR(4, this.vSA)) + e.a.a.a.fR(5, this.vSB)) + e.a.a.a.fR(6, this.vSC);
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
            kr krVar = (kr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    krVar.vSx = aVar3.Avy.readString();
                    return 0;
                case 2:
                    krVar.vSy = aVar3.Avy.readString();
                    return 0;
                case 3:
                    krVar.vSz = aVar3.Avy.ry();
                    return 0;
                case 4:
                    krVar.vSA = aVar3.Avy.ry();
                    return 0;
                case 5:
                    krVar.vSB = aVar3.Avy.ry();
                    return 0;
                case 6:
                    krVar.vSC = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
