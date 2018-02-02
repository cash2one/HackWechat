package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;

public final class af extends a {
    public String nfg;
    public int ngD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.ngD);
            if (this.nfg != null) {
                aVar.g(2, this.nfg);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.ngD) + 0;
            if (this.nfg != null) {
                return r0 + e.a.a.b.b.a.h(2, this.nfg);
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
            af afVar = (af) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    afVar.ngD = aVar3.Avy.ry();
                    return 0;
                case 2:
                    afVar.nfg = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
