package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;

public final class dz extends a {
    public String nfK;
    public String nff;
    public String nfg;
    public int nkn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nff != null) {
                aVar.g(1, this.nff);
            }
            if (this.nfg != null) {
                aVar.g(2, this.nfg);
            }
            aVar.fU(3, this.nkn);
            if (this.nfK == null) {
                return 0;
            }
            aVar.g(4, this.nfK);
            return 0;
        } else if (i == 1) {
            if (this.nff != null) {
                r0 = e.a.a.b.b.a.h(1, this.nff) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfg != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfg);
            }
            r0 += e.a.a.a.fR(3, this.nkn);
            if (this.nfK != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfK);
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
            dz dzVar = (dz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dzVar.nff = aVar3.Avy.readString();
                    return 0;
                case 2:
                    dzVar.nfg = aVar3.Avy.readString();
                    return 0;
                case 3:
                    dzVar.nkn = aVar3.Avy.ry();
                    return 0;
                case 4:
                    dzVar.nfK = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
