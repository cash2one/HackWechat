package com.tencent.mm.plugin.report.service;

import com.tencent.mm.bq.a;

public final class b extends a {
    public int fgt;
    public int pQj;
    public int pQk;
    public boolean pQl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.fgt);
            aVar.fU(2, this.pQj);
            aVar.fU(3, this.pQk);
            aVar.al(4, this.pQl);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.a.fR(1, this.fgt) + 0) + e.a.a.a.fR(2, this.pQj)) + e.a.a.a.fR(3, this.pQk)) + (e.a.a.b.b.a.dX(4) + 1);
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
                b bVar = (b) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bVar.fgt = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        bVar.pQj = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        bVar.pQk = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        bVar.pQl = aVar3.cJC();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
