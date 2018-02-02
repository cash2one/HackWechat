package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bq.a;

public final class n extends a {
    public int vCJ;
    public int vCK;
    public int vCL;
    public int vCM;
    public int vCN;
    public int vCO;
    public int vCa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vCa);
            aVar.fU(2, this.vCJ);
            aVar.fU(3, this.vCK);
            aVar.fU(4, this.vCL);
            aVar.fU(5, this.vCM);
            aVar.fU(6, this.vCN);
            aVar.fU(7, this.vCO);
            return 0;
        } else if (i == 1) {
            return ((((((e.a.a.a.fR(1, this.vCa) + 0) + e.a.a.a.fR(2, this.vCJ)) + e.a.a.a.fR(3, this.vCK)) + e.a.a.a.fR(4, this.vCL)) + e.a.a.a.fR(5, this.vCM)) + e.a.a.a.fR(6, this.vCN)) + e.a.a.a.fR(7, this.vCO);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                n nVar = (n) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        nVar.vCa = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        nVar.vCJ = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        nVar.vCK = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        nVar.vCL = aVar3.Avy.ry();
                        return 0;
                    case 5:
                        nVar.vCM = aVar3.Avy.ry();
                        return 0;
                    case 6:
                        nVar.vCN = aVar3.Avy.ry();
                        return 0;
                    case 7:
                        nVar.vCO = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
