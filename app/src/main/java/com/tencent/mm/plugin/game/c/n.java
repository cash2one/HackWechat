package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class n extends a {
    public int nfY;
    public String nfj;
    public String nfo;
    public String nfp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfp == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.nfo == null) {
                throw new b("Not all required fields were included: IconURL");
            } else {
                aVar.fU(1, this.nfY);
                if (this.nfp != null) {
                    aVar.g(2, this.nfp);
                }
                if (this.nfo != null) {
                    aVar.g(3, this.nfo);
                }
                if (this.nfj != null) {
                    aVar.g(4, this.nfj);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.nfY) + 0;
            if (this.nfp != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfp);
            }
            if (this.nfo != null) {
                r0 += e.a.a.b.b.a.h(3, this.nfo);
            }
            if (this.nfj != null) {
                return r0 + e.a.a.b.b.a.h(4, this.nfj);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.nfp == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.nfo != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: IconURL");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.nfY = aVar3.Avy.ry();
                    return 0;
                case 2:
                    nVar.nfp = aVar3.Avy.readString();
                    return 0;
                case 3:
                    nVar.nfo = aVar3.Avy.readString();
                    return 0;
                case 4:
                    nVar.nfj = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
