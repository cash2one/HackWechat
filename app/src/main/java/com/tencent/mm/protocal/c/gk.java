package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class gk extends a {
    public int vLF;
    public int vLG;
    public int vLH;
    public int vLa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vLa);
            aVar.fU(2, this.vLF);
            aVar.fU(3, this.vLG);
            aVar.fU(4, this.vLH);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.a.fR(1, this.vLa) + 0) + e.a.a.a.fR(2, this.vLF)) + e.a.a.a.fR(3, this.vLG)) + e.a.a.a.fR(4, this.vLH);
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
                gk gkVar = (gk) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        gkVar.vLa = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        gkVar.vLF = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        gkVar.vLG = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        gkVar.vLH = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
