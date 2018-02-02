package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class hf extends a {
    public String nfp;
    public int nfu;
    public String ngo;
    public String vFY;
    public String vFZ;
    public String vIO;
    public String vIU;
    public String vIW;
    public String vMR;
    public String vMS;
    public String vMT;
    public String vMU;
    public String vMV;
    public String vMW;
    public String vMX;
    public String vMY;
    public String vMZ;
    public int vNa;
    public int vNb;
    public String vNc;
    public String vNd;
    public String vNe;
    public long vNf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ngo != null) {
                aVar.g(1, this.ngo);
            }
            if (this.nfp != null) {
                aVar.g(2, this.nfp);
            }
            if (this.vIO != null) {
                aVar.g(3, this.vIO);
            }
            if (this.vMR != null) {
                aVar.g(4, this.vMR);
            }
            if (this.vMS != null) {
                aVar.g(5, this.vMS);
            }
            if (this.vMT != null) {
                aVar.g(6, this.vMT);
            }
            if (this.vMU != null) {
                aVar.g(7, this.vMU);
            }
            if (this.vMV != null) {
                aVar.g(8, this.vMV);
            }
            if (this.vMW != null) {
                aVar.g(9, this.vMW);
            }
            if (this.vMX != null) {
                aVar.g(10, this.vMX);
            }
            if (this.vMY != null) {
                aVar.g(11, this.vMY);
            }
            if (this.vFY != null) {
                aVar.g(12, this.vFY);
            }
            if (this.vMZ != null) {
                aVar.g(13, this.vMZ);
            }
            if (this.vIU != null) {
                aVar.g(14, this.vIU);
            }
            if (this.vIW != null) {
                aVar.g(15, this.vIW);
            }
            aVar.fU(16, this.nfu);
            aVar.fU(17, this.vNa);
            aVar.fU(18, this.vNb);
            if (this.vNc != null) {
                aVar.g(19, this.vNc);
            }
            if (this.vNd != null) {
                aVar.g(20, this.vNd);
            }
            if (this.vNe != null) {
                aVar.g(21, this.vNe);
            }
            if (this.vFZ != null) {
                aVar.g(22, this.vFZ);
            }
            aVar.S(23, this.vNf);
            return 0;
        } else if (i == 1) {
            if (this.ngo != null) {
                r0 = e.a.a.b.b.a.h(1, this.ngo) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfp != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfp);
            }
            if (this.vIO != null) {
                r0 += e.a.a.b.b.a.h(3, this.vIO);
            }
            if (this.vMR != null) {
                r0 += e.a.a.b.b.a.h(4, this.vMR);
            }
            if (this.vMS != null) {
                r0 += e.a.a.b.b.a.h(5, this.vMS);
            }
            if (this.vMT != null) {
                r0 += e.a.a.b.b.a.h(6, this.vMT);
            }
            if (this.vMU != null) {
                r0 += e.a.a.b.b.a.h(7, this.vMU);
            }
            if (this.vMV != null) {
                r0 += e.a.a.b.b.a.h(8, this.vMV);
            }
            if (this.vMW != null) {
                r0 += e.a.a.b.b.a.h(9, this.vMW);
            }
            if (this.vMX != null) {
                r0 += e.a.a.b.b.a.h(10, this.vMX);
            }
            if (this.vMY != null) {
                r0 += e.a.a.b.b.a.h(11, this.vMY);
            }
            if (this.vFY != null) {
                r0 += e.a.a.b.b.a.h(12, this.vFY);
            }
            if (this.vMZ != null) {
                r0 += e.a.a.b.b.a.h(13, this.vMZ);
            }
            if (this.vIU != null) {
                r0 += e.a.a.b.b.a.h(14, this.vIU);
            }
            if (this.vIW != null) {
                r0 += e.a.a.b.b.a.h(15, this.vIW);
            }
            r0 = ((r0 + e.a.a.a.fR(16, this.nfu)) + e.a.a.a.fR(17, this.vNa)) + e.a.a.a.fR(18, this.vNb);
            if (this.vNc != null) {
                r0 += e.a.a.b.b.a.h(19, this.vNc);
            }
            if (this.vNd != null) {
                r0 += e.a.a.b.b.a.h(20, this.vNd);
            }
            if (this.vNe != null) {
                r0 += e.a.a.b.b.a.h(21, this.vNe);
            }
            if (this.vFZ != null) {
                r0 += e.a.a.b.b.a.h(22, this.vFZ);
            }
            return r0 + e.a.a.a.R(23, this.vNf);
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
            hf hfVar = (hf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hfVar.ngo = aVar3.Avy.readString();
                    return 0;
                case 2:
                    hfVar.nfp = aVar3.Avy.readString();
                    return 0;
                case 3:
                    hfVar.vIO = aVar3.Avy.readString();
                    return 0;
                case 4:
                    hfVar.vMR = aVar3.Avy.readString();
                    return 0;
                case 5:
                    hfVar.vMS = aVar3.Avy.readString();
                    return 0;
                case 6:
                    hfVar.vMT = aVar3.Avy.readString();
                    return 0;
                case 7:
                    hfVar.vMU = aVar3.Avy.readString();
                    return 0;
                case 8:
                    hfVar.vMV = aVar3.Avy.readString();
                    return 0;
                case 9:
                    hfVar.vMW = aVar3.Avy.readString();
                    return 0;
                case 10:
                    hfVar.vMX = aVar3.Avy.readString();
                    return 0;
                case 11:
                    hfVar.vMY = aVar3.Avy.readString();
                    return 0;
                case 12:
                    hfVar.vFY = aVar3.Avy.readString();
                    return 0;
                case 13:
                    hfVar.vMZ = aVar3.Avy.readString();
                    return 0;
                case 14:
                    hfVar.vIU = aVar3.Avy.readString();
                    return 0;
                case 15:
                    hfVar.vIW = aVar3.Avy.readString();
                    return 0;
                case 16:
                    hfVar.nfu = aVar3.Avy.ry();
                    return 0;
                case 17:
                    hfVar.vNa = aVar3.Avy.ry();
                    return 0;
                case 18:
                    hfVar.vNb = aVar3.Avy.ry();
                    return 0;
                case 19:
                    hfVar.vNc = aVar3.Avy.readString();
                    return 0;
                case 20:
                    hfVar.vNd = aVar3.Avy.readString();
                    return 0;
                case 21:
                    hfVar.vNe = aVar3.Avy.readString();
                    return 0;
                case 22:
                    hfVar.vFZ = aVar3.Avy.readString();
                    return 0;
                case 23:
                    hfVar.vNf = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
