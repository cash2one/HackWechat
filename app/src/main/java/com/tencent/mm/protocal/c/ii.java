package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ii extends a {
    public String fFm;
    public int vOA;
    public int vOB;
    public String vOC;
    public int vOu;
    public int vOv;
    public String vOw;
    public int vOx;
    public String vOy;
    public int vOz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fFm != null) {
                aVar.g(1, this.fFm);
            }
            aVar.fU(2, this.vOu);
            aVar.fU(3, this.vOv);
            if (this.vOw != null) {
                aVar.g(4, this.vOw);
            }
            aVar.fU(5, this.vOx);
            if (this.vOy != null) {
                aVar.g(6, this.vOy);
            }
            aVar.fU(7, this.vOz);
            aVar.fU(8, this.vOA);
            aVar.fU(9, this.vOB);
            if (this.vOC == null) {
                return 0;
            }
            aVar.g(10, this.vOC);
            return 0;
        } else if (i == 1) {
            if (this.fFm != null) {
                r0 = e.a.a.b.b.a.h(1, this.fFm) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.vOu)) + e.a.a.a.fR(3, this.vOv);
            if (this.vOw != null) {
                r0 += e.a.a.b.b.a.h(4, this.vOw);
            }
            r0 += e.a.a.a.fR(5, this.vOx);
            if (this.vOy != null) {
                r0 += e.a.a.b.b.a.h(6, this.vOy);
            }
            r0 = ((r0 + e.a.a.a.fR(7, this.vOz)) + e.a.a.a.fR(8, this.vOA)) + e.a.a.a.fR(9, this.vOB);
            if (this.vOC != null) {
                r0 += e.a.a.b.b.a.h(10, this.vOC);
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
            ii iiVar = (ii) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iiVar.fFm = aVar3.Avy.readString();
                    return 0;
                case 2:
                    iiVar.vOu = aVar3.Avy.ry();
                    return 0;
                case 3:
                    iiVar.vOv = aVar3.Avy.ry();
                    return 0;
                case 4:
                    iiVar.vOw = aVar3.Avy.readString();
                    return 0;
                case 5:
                    iiVar.vOx = aVar3.Avy.ry();
                    return 0;
                case 6:
                    iiVar.vOy = aVar3.Avy.readString();
                    return 0;
                case 7:
                    iiVar.vOz = aVar3.Avy.ry();
                    return 0;
                case 8:
                    iiVar.vOA = aVar3.Avy.ry();
                    return 0;
                case 9:
                    iiVar.vOB = aVar3.Avy.ry();
                    return 0;
                case 10:
                    iiVar.vOC = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
