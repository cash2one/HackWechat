package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class cu extends a {
    public String ktA;
    public String nGJ;
    public String niZ;
    public String vHL;
    public String vHM;
    public int vHN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nGJ != null) {
                aVar.g(1, this.nGJ);
            }
            if (this.ktA != null) {
                aVar.g(2, this.ktA);
            }
            if (this.niZ != null) {
                aVar.g(3, this.niZ);
            }
            if (this.vHL != null) {
                aVar.g(4, this.vHL);
            }
            if (this.vHM != null) {
                aVar.g(5, this.vHM);
            }
            aVar.fU(6, this.vHN);
            return 0;
        } else if (i == 1) {
            if (this.nGJ != null) {
                r0 = e.a.a.b.b.a.h(1, this.nGJ) + 0;
            } else {
                r0 = 0;
            }
            if (this.ktA != null) {
                r0 += e.a.a.b.b.a.h(2, this.ktA);
            }
            if (this.niZ != null) {
                r0 += e.a.a.b.b.a.h(3, this.niZ);
            }
            if (this.vHL != null) {
                r0 += e.a.a.b.b.a.h(4, this.vHL);
            }
            if (this.vHM != null) {
                r0 += e.a.a.b.b.a.h(5, this.vHM);
            }
            return r0 + e.a.a.a.fR(6, this.vHN);
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
            cu cuVar = (cu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cuVar.nGJ = aVar3.Avy.readString();
                    return 0;
                case 2:
                    cuVar.ktA = aVar3.Avy.readString();
                    return 0;
                case 3:
                    cuVar.niZ = aVar3.Avy.readString();
                    return 0;
                case 4:
                    cuVar.vHL = aVar3.Avy.readString();
                    return 0;
                case 5:
                    cuVar.vHM = aVar3.Avy.readString();
                    return 0;
                case 6:
                    cuVar.vHN = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
