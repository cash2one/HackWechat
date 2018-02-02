package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class dt extends a {
    public String nfK;
    public String nfT;
    public String nfn;
    public String niZ;
    public String vIU;
    public String vIV;
    public String vIW;
    public int vIl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfn != null) {
                aVar.g(1, this.nfn);
            }
            if (this.vIU != null) {
                aVar.g(2, this.vIU);
            }
            if (this.nfT != null) {
                aVar.g(3, this.nfT);
            }
            if (this.niZ != null) {
                aVar.g(4, this.niZ);
            }
            aVar.fU(5, this.vIl);
            if (this.nfK != null) {
                aVar.g(6, this.nfK);
            }
            if (this.vIV != null) {
                aVar.g(7, this.vIV);
            }
            if (this.vIW == null) {
                return 0;
            }
            aVar.g(8, this.vIW);
            return 0;
        } else if (i == 1) {
            if (this.nfn != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfn) + 0;
            } else {
                r0 = 0;
            }
            if (this.vIU != null) {
                r0 += e.a.a.b.b.a.h(2, this.vIU);
            }
            if (this.nfT != null) {
                r0 += e.a.a.b.b.a.h(3, this.nfT);
            }
            if (this.niZ != null) {
                r0 += e.a.a.b.b.a.h(4, this.niZ);
            }
            r0 += e.a.a.a.fR(5, this.vIl);
            if (this.nfK != null) {
                r0 += e.a.a.b.b.a.h(6, this.nfK);
            }
            if (this.vIV != null) {
                r0 += e.a.a.b.b.a.h(7, this.vIV);
            }
            if (this.vIW != null) {
                r0 += e.a.a.b.b.a.h(8, this.vIW);
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
            dt dtVar = (dt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dtVar.nfn = aVar3.Avy.readString();
                    return 0;
                case 2:
                    dtVar.vIU = aVar3.Avy.readString();
                    return 0;
                case 3:
                    dtVar.nfT = aVar3.Avy.readString();
                    return 0;
                case 4:
                    dtVar.niZ = aVar3.Avy.readString();
                    return 0;
                case 5:
                    dtVar.vIl = aVar3.Avy.ry();
                    return 0;
                case 6:
                    dtVar.nfK = aVar3.Avy.readString();
                    return 0;
                case 7:
                    dtVar.vIV = aVar3.Avy.readString();
                    return 0;
                case 8:
                    dtVar.vIW = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
