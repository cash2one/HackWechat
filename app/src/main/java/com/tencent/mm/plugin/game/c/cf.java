package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class cf extends a {
    public String fon;
    public String nfj;
    public String ngs;
    public String niT;
    public String niX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            }
            if (this.niT != null) {
                aVar.g(1, this.niT);
            }
            if (this.fon != null) {
                aVar.g(2, this.fon);
            }
            if (this.ngs != null) {
                aVar.g(3, this.ngs);
            }
            if (this.nfj != null) {
                aVar.g(4, this.nfj);
            }
            if (this.niX == null) {
                return 0;
            }
            aVar.g(5, this.niX);
            return 0;
        } else if (i == 1) {
            if (this.niT != null) {
                r0 = e.a.a.b.b.a.h(1, this.niT) + 0;
            } else {
                r0 = 0;
            }
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(2, this.fon);
            }
            if (this.ngs != null) {
                r0 += e.a.a.b.b.a.h(3, this.ngs);
            }
            if (this.nfj != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfj);
            }
            if (this.niX != null) {
                r0 += e.a.a.b.b.a.h(5, this.niX);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
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
            cf cfVar = (cf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cfVar.niT = aVar3.Avy.readString();
                    return 0;
                case 2:
                    cfVar.fon = aVar3.Avy.readString();
                    return 0;
                case 3:
                    cfVar.ngs = aVar3.Avy.readString();
                    return 0;
                case 4:
                    cfVar.nfj = aVar3.Avy.readString();
                    return 0;
                case 5:
                    cfVar.niX = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
