package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class x extends a {
    public String fon;
    public String ksU;
    public String nfo;
    public String ngs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.ngs == null) {
                throw new b("Not all required fields were included: Detail");
            } else {
                if (this.ksU != null) {
                    aVar.g(1, this.ksU);
                }
                if (this.nfo != null) {
                    aVar.g(2, this.nfo);
                }
                if (this.fon != null) {
                    aVar.g(3, this.fon);
                }
                if (this.ngs == null) {
                    return 0;
                }
                aVar.g(4, this.ngs);
                return 0;
            }
        } else if (i == 1) {
            if (this.ksU != null) {
                r0 = e.a.a.b.b.a.h(1, this.ksU) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfo != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfo);
            }
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(3, this.fon);
            }
            if (this.ngs != null) {
                r0 += e.a.a.b.b.a.h(4, this.ngs);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.ngs != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Detail");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            x xVar = (x) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xVar.ksU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    xVar.nfo = aVar3.Avy.readString();
                    return 0;
                case 3:
                    xVar.fon = aVar3.Avy.readString();
                    return 0;
                case 4:
                    xVar.ngs = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
