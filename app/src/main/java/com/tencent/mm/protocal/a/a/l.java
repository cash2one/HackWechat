package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bq.a;

public final class l extends a {
    public int action;
    public int vCA;
    public int vCB;
    public int vCC;
    public int vCD;
    public int vCE;
    public int vCF;
    public int vCz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vCz);
            aVar.fU(2, this.action);
            aVar.fU(3, this.vCA);
            aVar.fU(4, this.vCB);
            aVar.fU(5, this.vCC);
            aVar.fU(6, this.vCD);
            aVar.fU(7, this.vCE);
            aVar.fU(8, this.vCF);
            return 0;
        } else if (i == 1) {
            return (((((((e.a.a.a.fR(1, this.vCz) + 0) + e.a.a.a.fR(2, this.action)) + e.a.a.a.fR(3, this.vCA)) + e.a.a.a.fR(4, this.vCB)) + e.a.a.a.fR(5, this.vCC)) + e.a.a.a.fR(6, this.vCD)) + e.a.a.a.fR(7, this.vCE)) + e.a.a.a.fR(8, this.vCF);
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
                l lVar = (l) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        lVar.vCz = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        lVar.action = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        lVar.vCA = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        lVar.vCB = aVar3.Avy.ry();
                        return 0;
                    case 5:
                        lVar.vCC = aVar3.Avy.ry();
                        return 0;
                    case 6:
                        lVar.vCD = aVar3.Avy.ry();
                        return 0;
                    case 7:
                        lVar.vCE = aVar3.Avy.ry();
                        return 0;
                    case 8:
                        lVar.vCF = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
