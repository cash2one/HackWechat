package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class pc extends a {
    public int ktm;
    public int vGW;
    public long vHe;
    public String vYg;
    public int vYh;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vGW);
            if (this.vYg != null) {
                aVar.g(2, this.vYg);
            }
            aVar.fU(3, this.ktm);
            aVar.fU(4, this.vYh);
            aVar.S(5, this.vHe);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vGW) + 0;
            if (this.vYg != null) {
                r0 += e.a.a.b.b.a.h(2, this.vYg);
            }
            return ((r0 + e.a.a.a.fR(3, this.ktm)) + e.a.a.a.fR(4, this.vYh)) + e.a.a.a.R(5, this.vHe);
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
            pc pcVar = (pc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pcVar.vGW = aVar3.Avy.ry();
                    return 0;
                case 2:
                    pcVar.vYg = aVar3.Avy.readString();
                    return 0;
                case 3:
                    pcVar.ktm = aVar3.Avy.ry();
                    return 0;
                case 4:
                    pcVar.vYh = aVar3.Avy.ry();
                    return 0;
                case 5:
                    pcVar.vHe = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
