package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ew extends a {
    public String nBM;
    public String oZA;
    public String oZz;
    public String sIF;
    public String vKD;
    public String vKE;
    public String vKF;
    public String vKG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vKD != null) {
                aVar.g(1, this.vKD);
            }
            if (this.sIF != null) {
                aVar.g(2, this.sIF);
            }
            if (this.oZz != null) {
                aVar.g(3, this.oZz);
            }
            if (this.oZA != null) {
                aVar.g(4, this.oZA);
            }
            if (this.nBM != null) {
                aVar.g(5, this.nBM);
            }
            if (this.vKE != null) {
                aVar.g(6, this.vKE);
            }
            if (this.vKF != null) {
                aVar.g(7, this.vKF);
            }
            if (this.vKG == null) {
                return 0;
            }
            aVar.g(8, this.vKG);
            return 0;
        } else if (i == 1) {
            if (this.vKD != null) {
                r0 = e.a.a.b.b.a.h(1, this.vKD) + 0;
            } else {
                r0 = 0;
            }
            if (this.sIF != null) {
                r0 += e.a.a.b.b.a.h(2, this.sIF);
            }
            if (this.oZz != null) {
                r0 += e.a.a.b.b.a.h(3, this.oZz);
            }
            if (this.oZA != null) {
                r0 += e.a.a.b.b.a.h(4, this.oZA);
            }
            if (this.nBM != null) {
                r0 += e.a.a.b.b.a.h(5, this.nBM);
            }
            if (this.vKE != null) {
                r0 += e.a.a.b.b.a.h(6, this.vKE);
            }
            if (this.vKF != null) {
                r0 += e.a.a.b.b.a.h(7, this.vKF);
            }
            if (this.vKG != null) {
                r0 += e.a.a.b.b.a.h(8, this.vKG);
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
            ew ewVar = (ew) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ewVar.vKD = aVar3.Avy.readString();
                    return 0;
                case 2:
                    ewVar.sIF = aVar3.Avy.readString();
                    return 0;
                case 3:
                    ewVar.oZz = aVar3.Avy.readString();
                    return 0;
                case 4:
                    ewVar.oZA = aVar3.Avy.readString();
                    return 0;
                case 5:
                    ewVar.nBM = aVar3.Avy.readString();
                    return 0;
                case 6:
                    ewVar.vKE = aVar3.Avy.readString();
                    return 0;
                case 7:
                    ewVar.vKF = aVar3.Avy.readString();
                    return 0;
                case 8:
                    ewVar.vKG = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
