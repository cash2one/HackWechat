package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bq.a;

public final class b extends a {
    public int ksA;
    public com.tencent.mm.bq.b ksB;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.ksA);
            if (this.ksB != null) {
                aVar.b(2, this.ksB);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.ksA) + 0;
            if (this.ksB != null) {
                return r0 + e.a.a.a.a(2, this.ksB);
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
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.ksA = aVar3.Avy.ry();
                    return 0;
                case 2:
                    bVar.ksB = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
