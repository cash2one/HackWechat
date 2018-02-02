package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class eg extends a {
    public String fon;
    public String nff;
    public String nfg;
    public String ngb;
    public String niX;
    public String nji;
    public String njl;
    public String nkr;
    public String nks;
    public int nkt;
    public String nku;
    public String nkv;
    public String nkw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            }
            if (this.fon != null) {
                aVar.g(1, this.fon);
            }
            if (this.njl != null) {
                aVar.g(2, this.njl);
            }
            if (this.nkr != null) {
                aVar.g(3, this.nkr);
            }
            if (this.nks != null) {
                aVar.g(4, this.nks);
            }
            if (this.nff != null) {
                aVar.g(5, this.nff);
            }
            if (this.niX != null) {
                aVar.g(6, this.niX);
            }
            aVar.fU(7, this.nkt);
            if (this.nfg != null) {
                aVar.g(8, this.nfg);
            }
            if (this.ngb != null) {
                aVar.g(9, this.ngb);
            }
            if (this.nku != null) {
                aVar.g(10, this.nku);
            }
            if (this.nkv != null) {
                aVar.g(11, this.nkv);
            }
            if (this.nji != null) {
                aVar.g(12, this.nji);
            }
            if (this.nkw == null) {
                return 0;
            }
            aVar.g(13, this.nkw);
            return 0;
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            if (this.njl != null) {
                r0 += e.a.a.b.b.a.h(2, this.njl);
            }
            if (this.nkr != null) {
                r0 += e.a.a.b.b.a.h(3, this.nkr);
            }
            if (this.nks != null) {
                r0 += e.a.a.b.b.a.h(4, this.nks);
            }
            if (this.nff != null) {
                r0 += e.a.a.b.b.a.h(5, this.nff);
            }
            if (this.niX != null) {
                r0 += e.a.a.b.b.a.h(6, this.niX);
            }
            r0 += e.a.a.a.fR(7, this.nkt);
            if (this.nfg != null) {
                r0 += e.a.a.b.b.a.h(8, this.nfg);
            }
            if (this.ngb != null) {
                r0 += e.a.a.b.b.a.h(9, this.ngb);
            }
            if (this.nku != null) {
                r0 += e.a.a.b.b.a.h(10, this.nku);
            }
            if (this.nkv != null) {
                r0 += e.a.a.b.b.a.h(11, this.nkv);
            }
            if (this.nji != null) {
                r0 += e.a.a.b.b.a.h(12, this.nji);
            }
            if (this.nkw != null) {
                r0 += e.a.a.b.b.a.h(13, this.nkw);
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
            eg egVar = (eg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    egVar.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    egVar.njl = aVar3.Avy.readString();
                    return 0;
                case 3:
                    egVar.nkr = aVar3.Avy.readString();
                    return 0;
                case 4:
                    egVar.nks = aVar3.Avy.readString();
                    return 0;
                case 5:
                    egVar.nff = aVar3.Avy.readString();
                    return 0;
                case 6:
                    egVar.niX = aVar3.Avy.readString();
                    return 0;
                case 7:
                    egVar.nkt = aVar3.Avy.ry();
                    return 0;
                case 8:
                    egVar.nfg = aVar3.Avy.readString();
                    return 0;
                case 9:
                    egVar.ngb = aVar3.Avy.readString();
                    return 0;
                case 10:
                    egVar.nku = aVar3.Avy.readString();
                    return 0;
                case 11:
                    egVar.nkv = aVar3.Avy.readString();
                    return 0;
                case 12:
                    egVar.nji = aVar3.Avy.readString();
                    return 0;
                case 13:
                    egVar.nkw = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
