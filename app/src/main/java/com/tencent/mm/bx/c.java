package com.tencent.mm.bx;

import com.tencent.mm.bq.a;

public final class c extends a {
    public int hlq;
    public int size;
    public int xkL;
    public int xkM;
    public int xkN;
    public int xkO = -1;
    public int xkP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.xkL);
            aVar.fU(2, this.xkM);
            aVar.fU(3, this.xkN);
            aVar.fU(41, this.xkO);
            aVar.fU(5, this.xkP);
            aVar.fU(6, this.hlq);
            aVar.fU(7, this.size);
            return 0;
        } else if (i == 1) {
            return ((((((e.a.a.a.fR(1, this.xkL) + 0) + e.a.a.a.fR(2, this.xkM)) + e.a.a.a.fR(3, this.xkN)) + e.a.a.a.fR(41, this.xkO)) + e.a.a.a.fR(5, this.xkP)) + e.a.a.a.fR(6, this.hlq)) + e.a.a.a.fR(7, this.size);
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
                c cVar = (c) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        cVar.xkL = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        cVar.xkM = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        cVar.xkN = aVar3.Avy.ry();
                        return 0;
                    case 5:
                        cVar.xkP = aVar3.Avy.ry();
                        return 0;
                    case 6:
                        cVar.hlq = aVar3.Avy.ry();
                        return 0;
                    case 7:
                        cVar.size = aVar3.Avy.ry();
                        return 0;
                    case 41:
                        cVar.xkO = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
