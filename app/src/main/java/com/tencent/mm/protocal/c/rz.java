package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class rz extends a {
    public long vHe;
    public int vIB;
    public int vIC;
    public int vJU;
    public String vZU;
    public int waa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vJU);
            aVar.fU(2, this.vIC);
            aVar.fU(3, this.vIB);
            if (this.vZU != null) {
                aVar.g(4, this.vZU);
            }
            aVar.fU(5, this.waa);
            aVar.S(6, this.vHe);
            return 0;
        } else if (i == 1) {
            r0 = ((e.a.a.a.fR(1, this.vJU) + 0) + e.a.a.a.fR(2, this.vIC)) + e.a.a.a.fR(3, this.vIB);
            if (this.vZU != null) {
                r0 += e.a.a.b.b.a.h(4, this.vZU);
            }
            return (r0 + e.a.a.a.fR(5, this.waa)) + e.a.a.a.R(6, this.vHe);
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
            rz rzVar = (rz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rzVar.vJU = aVar3.Avy.ry();
                    return 0;
                case 2:
                    rzVar.vIC = aVar3.Avy.ry();
                    return 0;
                case 3:
                    rzVar.vIB = aVar3.Avy.ry();
                    return 0;
                case 4:
                    rzVar.vZU = aVar3.Avy.readString();
                    return 0;
                case 5:
                    rzVar.waa = aVar3.Avy.ry();
                    return 0;
                case 6:
                    rzVar.vHe = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
