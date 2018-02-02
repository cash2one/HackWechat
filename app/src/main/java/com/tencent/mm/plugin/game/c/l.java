package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class l extends a {
    public String fon;
    public String nfK;
    public int nfP;
    public String nfT;
    public String nfe;
    public String nfg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfT == null) {
                throw new b("Not all required fields were included: IconUrl");
            } else if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nfg == null) {
                throw new b("Not all required fields were included: JumpUrl");
            } else {
                if (this.nfT != null) {
                    aVar.g(1, this.nfT);
                }
                if (this.fon != null) {
                    aVar.g(2, this.fon);
                }
                if (this.nfe != null) {
                    aVar.g(3, this.nfe);
                }
                if (this.nfg != null) {
                    aVar.g(4, this.nfg);
                }
                aVar.fU(5, this.nfP);
                if (this.nfK == null) {
                    return 0;
                }
                aVar.g(6, this.nfK);
                return 0;
            }
        } else if (i == 1) {
            if (this.nfT != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfT) + 0;
            } else {
                r0 = 0;
            }
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(2, this.fon);
            }
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(3, this.nfe);
            }
            if (this.nfg != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfg);
            }
            r0 += e.a.a.a.fR(5, this.nfP);
            if (this.nfK != null) {
                r0 += e.a.a.b.b.a.h(6, this.nfK);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.nfT == null) {
                throw new b("Not all required fields were included: IconUrl");
            } else if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nfg != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: JumpUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lVar.nfT = aVar3.Avy.readString();
                    return 0;
                case 2:
                    lVar.fon = aVar3.Avy.readString();
                    return 0;
                case 3:
                    lVar.nfe = aVar3.Avy.readString();
                    return 0;
                case 4:
                    lVar.nfg = aVar3.Avy.readString();
                    return 0;
                case 5:
                    lVar.nfP = aVar3.Avy.ry();
                    return 0;
                case 6:
                    lVar.nfK = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
