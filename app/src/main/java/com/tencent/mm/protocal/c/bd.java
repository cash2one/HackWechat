package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bd extends a {
    public long endTime;
    public int qOH;
    public int qOI;
    public long startTime;
    public float vGk;
    public float vGl;
    public float vGm;
    public long vGn;
    public long vGo;
    public long vGp;
    public long vGq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.qOH);
            aVar.fU(2, this.qOI);
            aVar.m(3, this.vGk);
            aVar.m(4, this.vGl);
            aVar.m(5, this.vGm);
            aVar.S(6, this.startTime);
            aVar.S(7, this.endTime);
            aVar.S(8, this.vGn);
            aVar.S(9, this.vGo);
            aVar.S(10, this.vGp);
            aVar.S(11, this.vGq);
            return 0;
        } else if (i == 1) {
            return ((((((((((e.a.a.a.fR(1, this.qOH) + 0) + e.a.a.a.fR(2, this.qOI)) + (e.a.a.b.b.a.dX(3) + 4)) + (e.a.a.b.b.a.dX(4) + 4)) + (e.a.a.b.b.a.dX(5) + 4)) + e.a.a.a.R(6, this.startTime)) + e.a.a.a.R(7, this.endTime)) + e.a.a.a.R(8, this.vGn)) + e.a.a.a.R(9, this.vGo)) + e.a.a.a.R(10, this.vGp)) + e.a.a.a.R(11, this.vGq);
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
                bd bdVar = (bd) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bdVar.qOH = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        bdVar.qOI = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        bdVar.vGk = aVar3.Avy.readFloat();
                        return 0;
                    case 4:
                        bdVar.vGl = aVar3.Avy.readFloat();
                        return 0;
                    case 5:
                        bdVar.vGm = aVar3.Avy.readFloat();
                        return 0;
                    case 6:
                        bdVar.startTime = aVar3.Avy.rz();
                        return 0;
                    case 7:
                        bdVar.endTime = aVar3.Avy.rz();
                        return 0;
                    case 8:
                        bdVar.vGn = aVar3.Avy.rz();
                        return 0;
                    case 9:
                        bdVar.vGo = aVar3.Avy.rz();
                        return 0;
                    case 10:
                        bdVar.vGp = aVar3.Avy.rz();
                        return 0;
                    case 11:
                        bdVar.vGq = aVar3.Avy.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
