package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ey extends a {
    public String kUg;
    public String nBM;
    public String oZz;
    public String sIF;
    public String vKI;
    public String vKJ;
    public String vKK;
    public boolean vKL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nBM != null) {
                aVar.g(1, this.nBM);
            }
            if (this.oZz != null) {
                aVar.g(2, this.oZz);
            }
            if (this.kUg != null) {
                aVar.g(3, this.kUg);
            }
            if (this.sIF != null) {
                aVar.g(4, this.sIF);
            }
            if (this.vKI != null) {
                aVar.g(5, this.vKI);
            }
            if (this.vKJ != null) {
                aVar.g(6, this.vKJ);
            }
            if (this.vKK != null) {
                aVar.g(8, this.vKK);
            }
            aVar.al(9, this.vKL);
            return 0;
        } else if (i == 1) {
            if (this.nBM != null) {
                r0 = e.a.a.b.b.a.h(1, this.nBM) + 0;
            } else {
                r0 = 0;
            }
            if (this.oZz != null) {
                r0 += e.a.a.b.b.a.h(2, this.oZz);
            }
            if (this.kUg != null) {
                r0 += e.a.a.b.b.a.h(3, this.kUg);
            }
            if (this.sIF != null) {
                r0 += e.a.a.b.b.a.h(4, this.sIF);
            }
            if (this.vKI != null) {
                r0 += e.a.a.b.b.a.h(5, this.vKI);
            }
            if (this.vKJ != null) {
                r0 += e.a.a.b.b.a.h(6, this.vKJ);
            }
            if (this.vKK != null) {
                r0 += e.a.a.b.b.a.h(8, this.vKK);
            }
            return r0 + (e.a.a.b.b.a.dX(9) + 1);
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
            ey eyVar = (ey) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eyVar.nBM = aVar3.Avy.readString();
                    return 0;
                case 2:
                    eyVar.oZz = aVar3.Avy.readString();
                    return 0;
                case 3:
                    eyVar.kUg = aVar3.Avy.readString();
                    return 0;
                case 4:
                    eyVar.sIF = aVar3.Avy.readString();
                    return 0;
                case 5:
                    eyVar.vKI = aVar3.Avy.readString();
                    return 0;
                case 6:
                    eyVar.vKJ = aVar3.Avy.readString();
                    return 0;
                case 8:
                    eyVar.vKK = aVar3.Avy.readString();
                    return 0;
                case 9:
                    eyVar.vKL = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
