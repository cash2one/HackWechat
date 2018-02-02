package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;

public final class co extends a {
    public String fon;
    public String nfK;
    public String nfe;
    public String nff;
    public String nfg;
    public String niX;
    public String njk;
    public String njl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.niX != null) {
                aVar.g(1, this.niX);
            }
            if (this.njk != null) {
                aVar.g(2, this.njk);
            }
            if (this.fon != null) {
                aVar.g(3, this.fon);
            }
            if (this.nfe != null) {
                aVar.g(4, this.nfe);
            }
            if (this.njl != null) {
                aVar.g(5, this.njl);
            }
            if (this.nfg != null) {
                aVar.g(6, this.nfg);
            }
            if (this.nff != null) {
                aVar.g(7, this.nff);
            }
            if (this.nfK == null) {
                return 0;
            }
            aVar.g(8, this.nfK);
            return 0;
        } else if (i == 1) {
            if (this.niX != null) {
                r0 = e.a.a.b.b.a.h(1, this.niX) + 0;
            } else {
                r0 = 0;
            }
            if (this.njk != null) {
                r0 += e.a.a.b.b.a.h(2, this.njk);
            }
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(3, this.fon);
            }
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfe);
            }
            if (this.njl != null) {
                r0 += e.a.a.b.b.a.h(5, this.njl);
            }
            if (this.nfg != null) {
                r0 += e.a.a.b.b.a.h(6, this.nfg);
            }
            if (this.nff != null) {
                r0 += e.a.a.b.b.a.h(7, this.nff);
            }
            if (this.nfK != null) {
                r0 += e.a.a.b.b.a.h(8, this.nfK);
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
            co coVar = (co) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    coVar.niX = aVar3.Avy.readString();
                    return 0;
                case 2:
                    coVar.njk = aVar3.Avy.readString();
                    return 0;
                case 3:
                    coVar.fon = aVar3.Avy.readString();
                    return 0;
                case 4:
                    coVar.nfe = aVar3.Avy.readString();
                    return 0;
                case 5:
                    coVar.njl = aVar3.Avy.readString();
                    return 0;
                case 6:
                    coVar.nfg = aVar3.Avy.readString();
                    return 0;
                case 7:
                    coVar.nff = aVar3.Avy.readString();
                    return 0;
                case 8:
                    coVar.nfK = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
