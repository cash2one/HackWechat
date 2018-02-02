package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class cs extends a {
    public String fon;
    public String nfj;
    public String nfo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfo == null) {
                throw new b("Not all required fields were included: IconURL");
            }
            if (this.nfo != null) {
                aVar.g(1, this.nfo);
            }
            if (this.fon != null) {
                aVar.g(2, this.fon);
            }
            if (this.nfj == null) {
                return 0;
            }
            aVar.g(3, this.nfj);
            return 0;
        } else if (i == 1) {
            if (this.nfo != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfo) + 0;
            } else {
                r0 = 0;
            }
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(2, this.fon);
            }
            if (this.nfj != null) {
                r0 += e.a.a.b.b.a.h(3, this.nfj);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.nfo != null) {
                return 0;
            }
            throw new b("Not all required fields were included: IconURL");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cs csVar = (cs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    csVar.nfo = aVar3.Avy.readString();
                    return 0;
                case 2:
                    csVar.fon = aVar3.Avy.readString();
                    return 0;
                case 3:
                    csVar.nfj = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
