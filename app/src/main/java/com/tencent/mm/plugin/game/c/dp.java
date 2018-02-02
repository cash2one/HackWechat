package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;

public final class dp extends a {
    public String fon;
    public String nfK;
    public String nfT;
    public String nfe;
    public String nfg;
    public String nkb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon != null) {
                aVar.g(1, this.fon);
            }
            if (this.nfe != null) {
                aVar.g(2, this.nfe);
            }
            if (this.nfT != null) {
                aVar.g(3, this.nfT);
            }
            if (this.nfg != null) {
                aVar.g(4, this.nfg);
            }
            if (this.nfK != null) {
                aVar.g(5, this.nfK);
            }
            if (this.nkb == null) {
                return 0;
            }
            aVar.g(6, this.nkb);
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
            if (this.nfT != null) {
                r0 += e.a.a.b.b.a.h(3, this.nfT);
            }
            if (this.nfg != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfg);
            }
            if (this.nfK != null) {
                r0 += e.a.a.b.b.a.h(5, this.nfK);
            }
            if (this.nkb != null) {
                r0 += e.a.a.b.b.a.h(6, this.nkb);
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
            dp dpVar = (dp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dpVar.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    dpVar.nfe = aVar3.Avy.readString();
                    return 0;
                case 3:
                    dpVar.nfT = aVar3.Avy.readString();
                    return 0;
                case 4:
                    dpVar.nfg = aVar3.Avy.readString();
                    return 0;
                case 5:
                    dpVar.nfK = aVar3.Avy.readString();
                    return 0;
                case 6:
                    dpVar.nkb = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
