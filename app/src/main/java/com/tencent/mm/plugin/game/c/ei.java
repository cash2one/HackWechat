package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class ei extends a {
    public String ksU;
    public String nfK;
    public String nfT;
    public String ngo;
    public String niZ;
    public String nkx;
    public int nky;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ngo == null) {
                throw new b("Not all required fields were included: AppId");
            }
            if (this.ngo != null) {
                aVar.g(1, this.ngo);
            }
            if (this.niZ != null) {
                aVar.g(2, this.niZ);
            }
            if (this.nfT != null) {
                aVar.g(3, this.nfT);
            }
            if (this.ksU != null) {
                aVar.g(4, this.ksU);
            }
            if (this.nkx != null) {
                aVar.g(5, this.nkx);
            }
            aVar.fU(6, this.nky);
            if (this.nfK == null) {
                return 0;
            }
            aVar.g(7, this.nfK);
            return 0;
        } else if (i == 1) {
            if (this.ngo != null) {
                r0 = e.a.a.b.b.a.h(1, this.ngo) + 0;
            } else {
                r0 = 0;
            }
            if (this.niZ != null) {
                r0 += e.a.a.b.b.a.h(2, this.niZ);
            }
            if (this.nfT != null) {
                r0 += e.a.a.b.b.a.h(3, this.nfT);
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(4, this.ksU);
            }
            if (this.nkx != null) {
                r0 += e.a.a.b.b.a.h(5, this.nkx);
            }
            r0 += e.a.a.a.fR(6, this.nky);
            if (this.nfK != null) {
                r0 += e.a.a.b.b.a.h(7, this.nfK);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.ngo != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AppId");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ei eiVar = (ei) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eiVar.ngo = aVar3.Avy.readString();
                    return 0;
                case 2:
                    eiVar.niZ = aVar3.Avy.readString();
                    return 0;
                case 3:
                    eiVar.nfT = aVar3.Avy.readString();
                    return 0;
                case 4:
                    eiVar.ksU = aVar3.Avy.readString();
                    return 0;
                case 5:
                    eiVar.nkx = aVar3.Avy.readString();
                    return 0;
                case 6:
                    eiVar.nky = aVar3.Avy.ry();
                    return 0;
                case 7:
                    eiVar.nfK = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
