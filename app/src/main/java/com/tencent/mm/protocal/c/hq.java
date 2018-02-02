package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class hq extends a {
    public String kNz;
    public String vNl;
    public int vNm;
    public String vNp;
    public String vNr;
    public String vNz;
    public int ver;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNr != null) {
                aVar.g(1, this.vNr);
            }
            if (this.kNz != null) {
                aVar.g(2, this.kNz);
            }
            aVar.fU(3, this.ver);
            if (this.vNl != null) {
                aVar.g(4, this.vNl);
            }
            if (this.vNz != null) {
                aVar.g(5, this.vNz);
            }
            aVar.fU(6, this.vNm);
            if (this.vNp == null) {
                return 0;
            }
            aVar.g(7, this.vNp);
            return 0;
        } else if (i == 1) {
            if (this.vNr != null) {
                r0 = e.a.a.b.b.a.h(1, this.vNr) + 0;
            } else {
                r0 = 0;
            }
            if (this.kNz != null) {
                r0 += e.a.a.b.b.a.h(2, this.kNz);
            }
            r0 += e.a.a.a.fR(3, this.ver);
            if (this.vNl != null) {
                r0 += e.a.a.b.b.a.h(4, this.vNl);
            }
            if (this.vNz != null) {
                r0 += e.a.a.b.b.a.h(5, this.vNz);
            }
            r0 += e.a.a.a.fR(6, this.vNm);
            if (this.vNp != null) {
                r0 += e.a.a.b.b.a.h(7, this.vNp);
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
            hq hqVar = (hq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hqVar.vNr = aVar3.Avy.readString();
                    return 0;
                case 2:
                    hqVar.kNz = aVar3.Avy.readString();
                    return 0;
                case 3:
                    hqVar.ver = aVar3.Avy.ry();
                    return 0;
                case 4:
                    hqVar.vNl = aVar3.Avy.readString();
                    return 0;
                case 5:
                    hqVar.vNz = aVar3.Avy.readString();
                    return 0;
                case 6:
                    hqVar.vNm = aVar3.Avy.ry();
                    return 0;
                case 7:
                    hqVar.vNp = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
