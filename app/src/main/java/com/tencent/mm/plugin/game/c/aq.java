package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class aq extends a {
    public String fon;
    public String nfK;
    public int nfP;
    public String nfg;
    public String nhg;
    public boolean nhh;
    public boolean nhi;
    public String nhj;
    public String nhk;
    public int nhl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nhg == null) {
                throw new b("Not all required fields were included: NavKey");
            } else {
                if (this.fon != null) {
                    aVar.g(1, this.fon);
                }
                if (this.nhg != null) {
                    aVar.g(2, this.nhg);
                }
                if (this.nfg != null) {
                    aVar.g(3, this.nfg);
                }
                aVar.al(4, this.nhh);
                aVar.al(5, this.nhi);
                if (this.nhj != null) {
                    aVar.g(6, this.nhj);
                }
                if (this.nhk != null) {
                    aVar.g(7, this.nhk);
                }
                aVar.fU(8, this.nhl);
                aVar.fU(9, this.nfP);
                if (this.nfK == null) {
                    return 0;
                }
                aVar.g(10, this.nfK);
                return 0;
            }
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            if (this.nhg != null) {
                r0 += e.a.a.b.b.a.h(2, this.nhg);
            }
            if (this.nfg != null) {
                r0 += e.a.a.b.b.a.h(3, this.nfg);
            }
            r0 = (r0 + (e.a.a.b.b.a.dX(4) + 1)) + (e.a.a.b.b.a.dX(5) + 1);
            if (this.nhj != null) {
                r0 += e.a.a.b.b.a.h(6, this.nhj);
            }
            if (this.nhk != null) {
                r0 += e.a.a.b.b.a.h(7, this.nhk);
            }
            r0 = (r0 + e.a.a.a.fR(8, this.nhl)) + e.a.a.a.fR(9, this.nfP);
            if (this.nfK != null) {
                r0 += e.a.a.b.b.a.h(10, this.nfK);
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
            } else if (this.nhg != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: NavKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aq aqVar = (aq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aqVar.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    aqVar.nhg = aVar3.Avy.readString();
                    return 0;
                case 3:
                    aqVar.nfg = aVar3.Avy.readString();
                    return 0;
                case 4:
                    aqVar.nhh = aVar3.cJC();
                    return 0;
                case 5:
                    aqVar.nhi = aVar3.cJC();
                    return 0;
                case 6:
                    aqVar.nhj = aVar3.Avy.readString();
                    return 0;
                case 7:
                    aqVar.nhk = aVar3.Avy.readString();
                    return 0;
                case 8:
                    aqVar.nhl = aVar3.Avy.ry();
                    return 0;
                case 9:
                    aqVar.nfP = aVar3.Avy.ry();
                    return 0;
                case 10:
                    aqVar.nfK = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
