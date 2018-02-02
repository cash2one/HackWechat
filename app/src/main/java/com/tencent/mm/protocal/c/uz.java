package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class uz extends a {
    public int ktm;
    public int vGM;
    public int vGN;
    public int vGO;
    public int vGP;
    public String vGT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vGM);
            aVar.fU(2, this.ktm);
            if (this.vGT != null) {
                aVar.g(3, this.vGT);
            }
            aVar.fU(4, this.vGN);
            aVar.fU(5, this.vGO);
            aVar.fU(6, this.vGP);
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.fR(1, this.vGM) + 0) + e.a.a.a.fR(2, this.ktm);
            if (this.vGT != null) {
                r0 += e.a.a.b.b.a.h(3, this.vGT);
            }
            return ((r0 + e.a.a.a.fR(4, this.vGN)) + e.a.a.a.fR(5, this.vGO)) + e.a.a.a.fR(6, this.vGP);
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
            uz uzVar = (uz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    uzVar.vGM = aVar3.Avy.ry();
                    return 0;
                case 2:
                    uzVar.ktm = aVar3.Avy.ry();
                    return 0;
                case 3:
                    uzVar.vGT = aVar3.Avy.readString();
                    return 0;
                case 4:
                    uzVar.vGN = aVar3.Avy.ry();
                    return 0;
                case 5:
                    uzVar.vGO = aVar3.Avy.ry();
                    return 0;
                case 6:
                    uzVar.vGP = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
