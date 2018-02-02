package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;

public final class ds extends a {
    public String nfT;
    public String nfg;
    public String nkf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkf != null) {
                aVar.g(1, this.nkf);
            }
            if (this.nfT != null) {
                aVar.g(2, this.nfT);
            }
            if (this.nfg == null) {
                return 0;
            }
            aVar.g(3, this.nfg);
            return 0;
        } else if (i == 1) {
            if (this.nkf != null) {
                r0 = e.a.a.b.b.a.h(1, this.nkf) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfT != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfT);
            }
            if (this.nfg != null) {
                r0 += e.a.a.b.b.a.h(3, this.nfg);
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
            ds dsVar = (ds) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dsVar.nkf = aVar3.Avy.readString();
                    return 0;
                case 2:
                    dsVar.nfT = aVar3.Avy.readString();
                    return 0;
                case 3:
                    dsVar.nfg = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
