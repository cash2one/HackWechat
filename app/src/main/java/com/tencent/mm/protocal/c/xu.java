package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class xu extends a {
    public int ktN;
    public String ngo;
    public int vHI;
    public int wiq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ngo != null) {
                aVar.g(1, this.ngo);
            }
            aVar.fU(2, this.ktN);
            aVar.fU(3, this.vHI);
            aVar.fU(4, this.wiq);
            return 0;
        } else if (i == 1) {
            if (this.ngo != null) {
                r0 = e.a.a.b.b.a.h(1, this.ngo) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + e.a.a.a.fR(2, this.ktN)) + e.a.a.a.fR(3, this.vHI)) + e.a.a.a.fR(4, this.wiq);
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
            xu xuVar = (xu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xuVar.ngo = aVar3.Avy.readString();
                    return 0;
                case 2:
                    xuVar.ktN = aVar3.Avy.ry();
                    return 0;
                case 3:
                    xuVar.vHI = aVar3.Avy.ry();
                    return 0;
                case 4:
                    xuVar.wiq = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
