package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;

public final class s extends a {
    public String nfl;
    public int ngn;
    public String ngo;
    public int ngp;
    public int ngq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.ngn);
            if (this.ngo != null) {
                aVar.g(2, this.ngo);
            }
            aVar.fU(3, this.ngp);
            if (this.nfl != null) {
                aVar.g(4, this.nfl);
            }
            aVar.fU(5, this.ngq);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.ngn) + 0;
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(2, this.ngo);
            }
            r0 += e.a.a.a.fR(3, this.ngp);
            if (this.nfl != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfl);
            }
            return r0 + e.a.a.a.fR(5, this.ngq);
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
            s sVar = (s) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    sVar.ngn = aVar3.Avy.ry();
                    return 0;
                case 2:
                    sVar.ngo = aVar3.Avy.readString();
                    return 0;
                case 3:
                    sVar.ngp = aVar3.Avy.ry();
                    return 0;
                case 4:
                    sVar.nfl = aVar3.Avy.readString();
                    return 0;
                case 5:
                    sVar.ngq = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
