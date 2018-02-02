package com.tencent.mm.plugin.game.c;

import e.a.a.b;

public final class a extends com.tencent.mm.bq.a {
    public String fon;
    public String nfe;
    public String nff;
    public String nfg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            }
            if (this.fon != null) {
                aVar.g(1, this.fon);
            }
            if (this.nfe != null) {
                aVar.g(2, this.nfe);
            }
            if (this.nff != null) {
                aVar.g(3, this.nff);
            }
            if (this.nfg == null) {
                return 0;
            }
            aVar.g(4, this.nfg);
            return 0;
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfe);
            }
            if (this.nff != null) {
                r0 += e.a.a.b.b.a.h(3, this.nff);
            }
            if (this.nfg != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfg);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.fon != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Title");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    aVar4.nfe = aVar3.Avy.readString();
                    return 0;
                case 3:
                    aVar4.nff = aVar3.Avy.readString();
                    return 0;
                case 4:
                    aVar4.nfg = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
