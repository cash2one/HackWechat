package com.tencent.mm.z;

import com.tencent.mm.bq.a;

public final class bm extends a {
    public String hhA;
    public long hhB;
    public int key;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.key);
            if (this.hhA != null) {
                aVar.g(2, this.hhA);
            }
            aVar.S(3, this.hhB);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.key) + 0;
            if (this.hhA != null) {
                r0 += e.a.a.b.b.a.h(2, this.hhA);
            }
            return r0 + e.a.a.a.R(3, this.hhB);
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
            bm bmVar = (bm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bmVar.key = aVar3.Avy.ry();
                    return 0;
                case 2:
                    bmVar.hhA = aVar3.Avy.readString();
                    return 0;
                case 3:
                    bmVar.hhB = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
