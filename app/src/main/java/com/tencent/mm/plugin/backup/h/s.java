package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bq.a;

public final class s extends a {
    public long ktF;
    public long ktG;
    public long kti;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.kti);
            aVar.S(2, this.ktF);
            aVar.S(3, this.ktG);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.R(1, this.kti) + 0) + e.a.a.a.R(2, this.ktF)) + e.a.a.a.R(3, this.ktG);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                s sVar = (s) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        sVar.kti = aVar3.Avy.rz();
                        return 0;
                    case 2:
                        sVar.ktF = aVar3.Avy.rz();
                        return 0;
                    case 3:
                        sVar.ktG = aVar3.Avy.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
