package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class ae extends a {
    public b ksB;
    public String ktR;
    public int ktS;
    public int ktU;
    public int ktV;
    public int ktW;
    public int ktm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ktR == null) {
                throw new e.a.a.b("Not all required fields were included: DataID");
            }
            if (this.ktR != null) {
                aVar.g(1, this.ktR);
            }
            aVar.fU(2, this.ktS);
            aVar.fU(3, this.ktU);
            aVar.fU(4, this.ktV);
            aVar.fU(5, this.ktm);
            aVar.fU(6, this.ktW);
            if (this.ksB == null) {
                return 0;
            }
            aVar.b(7, this.ksB);
            return 0;
        } else if (i == 1) {
            if (this.ktR != null) {
                r0 = e.a.a.b.b.a.h(1, this.ktR) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + e.a.a.a.fR(2, this.ktS)) + e.a.a.a.fR(3, this.ktU)) + e.a.a.a.fR(4, this.ktV)) + e.a.a.a.fR(5, this.ktm)) + e.a.a.a.fR(6, this.ktW);
            if (this.ksB != null) {
                r0 += e.a.a.a.a(7, this.ksB);
            }
            return r0;
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
            throw new e.a.a.b("Not all required fields were included: DataID");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ae aeVar = (ae) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aeVar.ktR = aVar3.Avy.readString();
                    return 0;
                case 2:
                    aeVar.ktS = aVar3.Avy.ry();
                    return 0;
                case 3:
                    aeVar.ktU = aVar3.Avy.ry();
                    return 0;
                case 4:
                    aeVar.ktV = aVar3.Avy.ry();
                    return 0;
                case 5:
                    aeVar.ktm = aVar3.Avy.ry();
                    return 0;
                case 6:
                    aeVar.ktW = aVar3.Avy.ry();
                    return 0;
                case 7:
                    aeVar.ksB = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
