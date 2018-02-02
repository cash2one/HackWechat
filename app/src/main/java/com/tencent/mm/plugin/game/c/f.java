package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;

public final class f extends a {
    public int nfF;
    public int nfG;
    public int nfH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.nfF);
            aVar.fU(2, this.nfG);
            aVar.fU(3, this.nfH);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.fR(1, this.nfF) + 0) + e.a.a.a.fR(2, this.nfG)) + e.a.a.a.fR(3, this.nfH);
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
                f fVar = (f) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        fVar.nfF = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        fVar.nfG = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        fVar.nfH = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
