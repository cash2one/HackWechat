package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.bq.a;

public final class c extends a {
    public int liR;
    public double obA;
    public String obB;
    public String obC;
    public double obD;
    public double obE;
    public double obF;
    public int obG;
    public String obH;
    public String obI;
    public int obz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.obz);
            aVar.b(2, this.obA);
            if (this.obB != null) {
                aVar.g(3, this.obB);
            }
            if (this.obC != null) {
                aVar.g(4, this.obC);
            }
            aVar.b(5, this.obD);
            aVar.b(6, this.obE);
            aVar.b(7, this.obF);
            aVar.fU(8, this.obG);
            aVar.fU(9, this.liR);
            if (this.obH != null) {
                aVar.g(10, this.obH);
            }
            if (this.obI != null) {
                aVar.g(11, this.obI);
            }
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.fR(1, this.obz) + 0) + (e.a.a.b.b.a.dX(2) + 8);
            if (this.obB != null) {
                r0 += e.a.a.b.b.a.h(3, this.obB);
            }
            if (this.obC != null) {
                r0 += e.a.a.b.b.a.h(4, this.obC);
            }
            r0 = ((((r0 + (e.a.a.b.b.a.dX(5) + 8)) + (e.a.a.b.b.a.dX(6) + 8)) + (e.a.a.b.b.a.dX(7) + 8)) + e.a.a.a.fR(8, this.obG)) + e.a.a.a.fR(9, this.liR);
            if (this.obH != null) {
                r0 += e.a.a.b.b.a.h(10, this.obH);
            }
            if (this.obI != null) {
                return r0 + e.a.a.b.b.a.h(11, this.obI);
            }
            return r0;
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
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.obz = aVar3.Avy.ry();
                    return 0;
                case 2:
                    cVar.obA = aVar3.Avy.readDouble();
                    return 0;
                case 3:
                    cVar.obB = aVar3.Avy.readString();
                    return 0;
                case 4:
                    cVar.obC = aVar3.Avy.readString();
                    return 0;
                case 5:
                    cVar.obD = aVar3.Avy.readDouble();
                    return 0;
                case 6:
                    cVar.obE = aVar3.Avy.readDouble();
                    return 0;
                case 7:
                    cVar.obF = aVar3.Avy.readDouble();
                    return 0;
                case 8:
                    cVar.obG = aVar3.Avy.ry();
                    return 0;
                case 9:
                    cVar.liR = aVar3.Avy.ry();
                    return 0;
                case 10:
                    cVar.obH = aVar3.Avy.readString();
                    return 0;
                case 11:
                    cVar.obI = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
