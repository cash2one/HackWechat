package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class hl extends a {
    public String kNz;
    public String vNr;
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
            return r0 + e.a.a.a.fR(3, this.ver);
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
            hl hlVar = (hl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hlVar.vNr = aVar3.Avy.readString();
                    return 0;
                case 2:
                    hlVar.kNz = aVar3.Avy.readString();
                    return 0;
                case 3:
                    hlVar.ver = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
