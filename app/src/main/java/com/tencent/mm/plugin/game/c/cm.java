package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;

public final class cm extends a {
    public String fon;
    public String nfe;
    public String nff;
    public String nfg;
    public int njh;
    public String nji;
    public boolean njj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon != null) {
                aVar.g(1, this.fon);
            }
            if (this.nfe != null) {
                aVar.g(2, this.nfe);
            }
            if (this.nff != null) {
                aVar.g(3, this.nff);
            }
            aVar.fU(4, this.njh);
            if (this.nfg != null) {
                aVar.g(6, this.nfg);
            }
            if (this.nji != null) {
                aVar.g(7, this.nji);
            }
            aVar.al(8, this.njj);
            return 0;
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfe);
            }
            if (this.nff != null) {
                r0 += e.a.a.b.b.a.h(3, this.nff);
            }
            r0 += e.a.a.a.fR(4, this.njh);
            if (this.nfg != null) {
                r0 += e.a.a.b.b.a.h(6, this.nfg);
            }
            if (this.nji != null) {
                r0 += e.a.a.b.b.a.h(7, this.nji);
            }
            return r0 + (e.a.a.b.b.a.dX(8) + 1);
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
            cm cmVar = (cm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cmVar.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    cmVar.nfe = aVar3.Avy.readString();
                    return 0;
                case 3:
                    cmVar.nff = aVar3.Avy.readString();
                    return 0;
                case 4:
                    cmVar.njh = aVar3.Avy.ry();
                    return 0;
                case 6:
                    cmVar.nfg = aVar3.Avy.readString();
                    return 0;
                case 7:
                    cmVar.nji = aVar3.Avy.readString();
                    return 0;
                case 8:
                    cmVar.njj = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
