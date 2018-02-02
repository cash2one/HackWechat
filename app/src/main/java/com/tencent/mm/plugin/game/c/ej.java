package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;

public final class ej extends a {
    public String ngf;
    public String nkA;
    public String nkB;
    public String nkC;
    public int nkD;
    public String nkE;
    public String nkF;
    public String nkz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ngf != null) {
                aVar.g(1, this.ngf);
            }
            if (this.nkz != null) {
                aVar.g(2, this.nkz);
            }
            if (this.nkA != null) {
                aVar.g(3, this.nkA);
            }
            if (this.nkB != null) {
                aVar.g(4, this.nkB);
            }
            if (this.nkC != null) {
                aVar.g(5, this.nkC);
            }
            aVar.fU(6, this.nkD);
            if (this.nkE != null) {
                aVar.g(7, this.nkE);
            }
            if (this.nkF == null) {
                return 0;
            }
            aVar.g(8, this.nkF);
            return 0;
        } else if (i == 1) {
            if (this.ngf != null) {
                r0 = e.a.a.b.b.a.h(1, this.ngf) + 0;
            } else {
                r0 = 0;
            }
            if (this.nkz != null) {
                r0 += e.a.a.b.b.a.h(2, this.nkz);
            }
            if (this.nkA != null) {
                r0 += e.a.a.b.b.a.h(3, this.nkA);
            }
            if (this.nkB != null) {
                r0 += e.a.a.b.b.a.h(4, this.nkB);
            }
            if (this.nkC != null) {
                r0 += e.a.a.b.b.a.h(5, this.nkC);
            }
            r0 += e.a.a.a.fR(6, this.nkD);
            if (this.nkE != null) {
                r0 += e.a.a.b.b.a.h(7, this.nkE);
            }
            if (this.nkF != null) {
                r0 += e.a.a.b.b.a.h(8, this.nkF);
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
            ej ejVar = (ej) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ejVar.ngf = aVar3.Avy.readString();
                    return 0;
                case 2:
                    ejVar.nkz = aVar3.Avy.readString();
                    return 0;
                case 3:
                    ejVar.nkA = aVar3.Avy.readString();
                    return 0;
                case 4:
                    ejVar.nkB = aVar3.Avy.readString();
                    return 0;
                case 5:
                    ejVar.nkC = aVar3.Avy.readString();
                    return 0;
                case 6:
                    ejVar.nkD = aVar3.Avy.ry();
                    return 0;
                case 7:
                    ejVar.nkE = aVar3.Avy.readString();
                    return 0;
                case 8:
                    ejVar.nkF = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
