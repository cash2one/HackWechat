package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;

public final class eb extends a {
    public String fon;
    public String nfK;
    public String nfT;
    public String nfg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfT != null) {
                aVar.g(1, this.nfT);
            }
            if (this.fon != null) {
                aVar.g(2, this.fon);
            }
            if (this.nfg != null) {
                aVar.g(3, this.nfg);
            }
            if (this.nfK == null) {
                return 0;
            }
            aVar.g(4, this.nfK);
            return 0;
        } else if (i == 1) {
            if (this.nfT != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfT) + 0;
            } else {
                r0 = 0;
            }
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(2, this.fon);
            }
            if (this.nfg != null) {
                r0 += e.a.a.b.b.a.h(3, this.nfg);
            }
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
            eb ebVar = (eb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ebVar.nfT = aVar3.Avy.readString();
                    return 0;
                case 2:
                    ebVar.fon = aVar3.Avy.readString();
                    return 0;
                case 3:
                    ebVar.nfg = aVar3.Avy.readString();
                    return 0;
                case 4:
                    ebVar.nfK = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
