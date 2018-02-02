package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class dn extends a {
    public String ksU;
    public int njV;
    public long njW;
    public String njX;
    public boolean njY;
    public int njZ;
    public String nka;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ksU == null) {
                throw new b("Not all required fields were included: UserName");
            }
            if (this.ksU != null) {
                aVar.g(1, this.ksU);
            }
            aVar.fU(2, this.njV);
            aVar.S(3, this.njW);
            if (this.njX != null) {
                aVar.g(4, this.njX);
            }
            aVar.al(5, this.njY);
            aVar.fU(6, this.njZ);
            if (this.nka == null) {
                return 0;
            }
            aVar.g(7, this.nka);
            return 0;
        } else if (i == 1) {
            if (this.ksU != null) {
                r0 = e.a.a.b.b.a.h(1, this.ksU) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.njV)) + e.a.a.a.R(3, this.njW);
            if (this.njX != null) {
                r0 += e.a.a.b.b.a.h(4, this.njX);
            }
            r0 = (r0 + (e.a.a.b.b.a.dX(5) + 1)) + e.a.a.a.fR(6, this.njZ);
            if (this.nka != null) {
                r0 += e.a.a.b.b.a.h(7, this.nka);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.ksU != null) {
                return 0;
            }
            throw new b("Not all required fields were included: UserName");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dn dnVar = (dn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dnVar.ksU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    dnVar.njV = aVar3.Avy.ry();
                    return 0;
                case 3:
                    dnVar.njW = aVar3.Avy.rz();
                    return 0;
                case 4:
                    dnVar.njX = aVar3.Avy.readString();
                    return 0;
                case 5:
                    dnVar.njY = aVar3.cJC();
                    return 0;
                case 6:
                    dnVar.njZ = aVar3.Avy.ry();
                    return 0;
                case 7:
                    dnVar.nka = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
