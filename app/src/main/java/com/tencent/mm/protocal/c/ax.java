package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ax extends a {
    public String fDI;
    public String fyY;
    public String sAb;
    public String sAc;
    public String sUr;
    public int sUs;
    public String title;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.g(1, this.url);
            }
            if (this.fyY != null) {
                aVar.g(2, this.fyY);
            }
            if (this.fDI != null) {
                aVar.g(3, this.fDI);
            }
            if (this.sUr != null) {
                aVar.g(4, this.sUr);
            }
            if (this.title != null) {
                aVar.g(5, this.title);
            }
            if (this.sAb != null) {
                aVar.g(6, this.sAb);
            }
            if (this.sAc != null) {
                aVar.g(7, this.sAc);
            }
            aVar.fU(8, this.sUs);
            return 0;
        } else if (i == 1) {
            if (this.url != null) {
                r0 = e.a.a.b.b.a.h(1, this.url) + 0;
            } else {
                r0 = 0;
            }
            if (this.fyY != null) {
                r0 += e.a.a.b.b.a.h(2, this.fyY);
            }
            if (this.fDI != null) {
                r0 += e.a.a.b.b.a.h(3, this.fDI);
            }
            if (this.sUr != null) {
                r0 += e.a.a.b.b.a.h(4, this.sUr);
            }
            if (this.title != null) {
                r0 += e.a.a.b.b.a.h(5, this.title);
            }
            if (this.sAb != null) {
                r0 += e.a.a.b.b.a.h(6, this.sAb);
            }
            if (this.sAc != null) {
                r0 += e.a.a.b.b.a.h(7, this.sAc);
            }
            return r0 + e.a.a.a.fR(8, this.sUs);
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
            ax axVar = (ax) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axVar.url = aVar3.Avy.readString();
                    return 0;
                case 2:
                    axVar.fyY = aVar3.Avy.readString();
                    return 0;
                case 3:
                    axVar.fDI = aVar3.Avy.readString();
                    return 0;
                case 4:
                    axVar.sUr = aVar3.Avy.readString();
                    return 0;
                case 5:
                    axVar.title = aVar3.Avy.readString();
                    return 0;
                case 6:
                    axVar.sAb = aVar3.Avy.readString();
                    return 0;
                case 7:
                    axVar.sAc = aVar3.Avy.readString();
                    return 0;
                case 8:
                    axVar.sUs = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
