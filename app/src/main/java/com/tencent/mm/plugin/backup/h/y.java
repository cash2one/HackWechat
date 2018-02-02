package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class y extends a {
    public String ktR;
    public int ktS;
    public int ktU;
    public int ktV;
    public int ktm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ktR == null) {
                throw new b("Not all required fields were included: DataID");
            }
            if (this.ktR != null) {
                aVar.g(1, this.ktR);
            }
            aVar.fU(2, this.ktS);
            aVar.fU(3, this.ktU);
            aVar.fU(4, this.ktV);
            aVar.fU(5, this.ktm);
            return 0;
        } else if (i == 1) {
            if (this.ktR != null) {
                r0 = e.a.a.b.b.a.h(1, this.ktR) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + e.a.a.a.fR(2, this.ktS)) + e.a.a.a.fR(3, this.ktU)) + e.a.a.a.fR(4, this.ktV)) + e.a.a.a.fR(5, this.ktm);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.ktR != null) {
                return 0;
            }
            throw new b("Not all required fields were included: DataID");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            y yVar = (y) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    yVar.ktR = aVar3.Avy.readString();
                    return 0;
                case 2:
                    yVar.ktS = aVar3.Avy.ry();
                    return 0;
                case 3:
                    yVar.ktU = aVar3.Avy.ry();
                    return 0;
                case 4:
                    yVar.ktV = aVar3.Avy.ry();
                    return 0;
                case 5:
                    yVar.ktm = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
