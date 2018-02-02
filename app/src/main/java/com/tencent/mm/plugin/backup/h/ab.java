package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class ab extends a {
    public int ksA;
    public b ksB;
    public long ktl;
    public int kuc;
    public int kud;
    public long kue;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.ksA);
            if (this.ksB != null) {
                aVar.b(2, this.ksB);
            }
            aVar.fU(3, this.kuc);
            aVar.fU(4, this.kud);
            aVar.S(5, this.kue);
            aVar.S(6, this.ktl);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.ksA) + 0;
            if (this.ksB != null) {
                r0 += e.a.a.a.a(2, this.ksB);
            }
            return (((r0 + e.a.a.a.fR(3, this.kuc)) + e.a.a.a.fR(4, this.kud)) + e.a.a.a.R(5, this.kue)) + e.a.a.a.R(6, this.ktl);
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
            ab abVar = (ab) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abVar.ksA = aVar3.Avy.ry();
                    return 0;
                case 2:
                    abVar.ksB = aVar3.cJD();
                    return 0;
                case 3:
                    abVar.kuc = aVar3.Avy.ry();
                    return 0;
                case 4:
                    abVar.kud = aVar3.Avy.ry();
                    return 0;
                case 5:
                    abVar.kue = aVar3.Avy.rz();
                    return 0;
                case 6:
                    abVar.ktl = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
