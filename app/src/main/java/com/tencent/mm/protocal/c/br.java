package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class br extends a {
    public int ktN;
    public int vGM;
    public int vGN;
    public int vGO;
    public int vGP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vGM);
            aVar.fU(2, this.ktN);
            aVar.fU(3, this.vGN);
            aVar.fU(4, this.vGO);
            aVar.fU(5, this.vGP);
            return 0;
        } else if (i == 1) {
            return ((((e.a.a.a.fR(1, this.vGM) + 0) + e.a.a.a.fR(2, this.ktN)) + e.a.a.a.fR(3, this.vGN)) + e.a.a.a.fR(4, this.vGO)) + e.a.a.a.fR(5, this.vGP);
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
                br brVar = (br) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        brVar.vGM = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        brVar.ktN = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        brVar.vGN = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        brVar.vGO = aVar3.Avy.ry();
                        return 0;
                    case 5:
                        brVar.vGP = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
