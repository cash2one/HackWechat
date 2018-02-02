package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class p extends a {
    public String ID;
    public long ktl;
    public int kto;
    public int ktp;
    public int ktq;
    public long ktr;
    public long kts;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.g(1, this.ID);
            }
            aVar.fU(2, this.kto);
            aVar.fU(3, this.ktp);
            aVar.fU(4, this.ktq);
            aVar.S(5, this.ktl);
            aVar.S(6, this.ktr);
            aVar.S(7, this.kts);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                r0 = e.a.a.b.b.a.h(1, this.ID) + 0;
            } else {
                r0 = 0;
            }
            return (((((r0 + e.a.a.a.fR(2, this.kto)) + e.a.a.a.fR(3, this.ktp)) + e.a.a.a.fR(4, this.ktq)) + e.a.a.a.R(5, this.ktl)) + e.a.a.a.R(6, this.ktr)) + e.a.a.a.R(7, this.kts);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.ID != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            p pVar = (p) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pVar.ID = aVar3.Avy.readString();
                    return 0;
                case 2:
                    pVar.kto = aVar3.Avy.ry();
                    return 0;
                case 3:
                    pVar.ktp = aVar3.Avy.ry();
                    return 0;
                case 4:
                    pVar.ktq = aVar3.Avy.ry();
                    return 0;
                case 5:
                    pVar.ktl = aVar3.Avy.rz();
                    return 0;
                case 6:
                    pVar.ktr = aVar3.Avy.rz();
                    return 0;
                case 7:
                    pVar.kts = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
