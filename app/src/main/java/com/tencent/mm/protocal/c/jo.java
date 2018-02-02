package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class jo extends a {
    public int vPT;
    public int vPU;
    public int vPV;
    public int vPW;
    public int vPX;
    public int vPY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vPT);
            aVar.fU(2, this.vPU);
            aVar.fU(3, this.vPV);
            aVar.fU(4, this.vPW);
            aVar.fU(5, this.vPX);
            aVar.fU(6, this.vPY);
            return 0;
        } else if (i == 1) {
            return (((((e.a.a.a.fR(1, this.vPT) + 0) + e.a.a.a.fR(2, this.vPU)) + e.a.a.a.fR(3, this.vPV)) + e.a.a.a.fR(4, this.vPW)) + e.a.a.a.fR(5, this.vPX)) + e.a.a.a.fR(6, this.vPY);
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
                jo joVar = (jo) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        joVar.vPT = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        joVar.vPU = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        joVar.vPV = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        joVar.vPW = aVar3.Avy.ry();
                        return 0;
                    case 5:
                        joVar.vPX = aVar3.Avy.ry();
                        return 0;
                    case 6:
                        joVar.vPY = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
