package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class cc extends a {
    public String fon;
    public String nfj;
    public String ngs;
    public String niT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.niT == null) {
                throw new b("Not all required fields were included: LogoURL");
            } else if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.ngs == null) {
                throw new b("Not all required fields were included: Detail");
            } else if (this.nfj == null) {
                throw new b("Not all required fields were included: WebURL");
            } else {
                if (this.niT != null) {
                    aVar.g(1, this.niT);
                }
                if (this.fon != null) {
                    aVar.g(2, this.fon);
                }
                if (this.ngs != null) {
                    aVar.g(3, this.ngs);
                }
                if (this.nfj == null) {
                    return 0;
                }
                aVar.g(4, this.nfj);
                return 0;
            }
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
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.niT == null) {
                throw new b("Not all required fields were included: LogoURL");
            } else if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.ngs == null) {
                throw new b("Not all required fields were included: Detail");
            } else if (this.nfj != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: WebURL");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cc ccVar = (cc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccVar.niT = aVar3.Avy.readString();
                    return 0;
                case 2:
                    ccVar.fon = aVar3.Avy.readString();
                    return 0;
                case 3:
                    ccVar.ngs = aVar3.Avy.readString();
                    return 0;
                case 4:
                    ccVar.nfj = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
