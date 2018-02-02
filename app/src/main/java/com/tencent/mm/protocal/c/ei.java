package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ei extends a {
    public String hvw;
    public String ksU;
    public String kub;
    public int mIC;
    public String nkv;
    public int vJH;
    public String vJI;
    public String vJJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkv != null) {
                aVar.g(1, this.nkv);
            }
            if (this.kub != null) {
                aVar.g(2, this.kub);
            }
            if (this.ksU != null) {
                aVar.g(3, this.ksU);
            }
            aVar.fU(4, this.vJH);
            if (this.vJI != null) {
                aVar.g(5, this.vJI);
            }
            if (this.hvw != null) {
                aVar.g(6, this.hvw);
            }
            if (this.vJJ != null) {
                aVar.g(7, this.vJJ);
            }
            aVar.fU(8, this.mIC);
            return 0;
        } else if (i == 1) {
            if (this.nkv != null) {
                r0 = e.a.a.b.b.a.h(1, this.nkv) + 0;
            } else {
                r0 = 0;
            }
            if (this.kub != null) {
                r0 += e.a.a.b.b.a.h(2, this.kub);
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(3, this.ksU);
            }
            r0 += e.a.a.a.fR(4, this.vJH);
            if (this.vJI != null) {
                r0 += e.a.a.b.b.a.h(5, this.vJI);
            }
            if (this.hvw != null) {
                r0 += e.a.a.b.b.a.h(6, this.hvw);
            }
            if (this.vJJ != null) {
                r0 += e.a.a.b.b.a.h(7, this.vJJ);
            }
            return r0 + e.a.a.a.fR(8, this.mIC);
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
            ei eiVar = (ei) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eiVar.nkv = aVar3.Avy.readString();
                    return 0;
                case 2:
                    eiVar.kub = aVar3.Avy.readString();
                    return 0;
                case 3:
                    eiVar.ksU = aVar3.Avy.readString();
                    return 0;
                case 4:
                    eiVar.vJH = aVar3.Avy.ry();
                    return 0;
                case 5:
                    eiVar.vJI = aVar3.Avy.readString();
                    return 0;
                case 6:
                    eiVar.hvw = aVar3.Avy.readString();
                    return 0;
                case 7:
                    eiVar.vJJ = aVar3.Avy.readString();
                    return 0;
                case 8:
                    eiVar.mIC = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
