package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class aq extends a {
    public String hvy;
    public String ksU;
    public int ktm;
    public String kub;
    public int vFA;
    public String vFB;
    public int vFr;
    public String vFs;
    public String vFt;
    public int vFu;
    public int vFv;
    public String vFw;
    public int vFx;
    public String vFy;
    public String vFz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ksU != null) {
                aVar.g(1, this.ksU);
            }
            if (this.kub != null) {
                aVar.g(2, this.kub);
            }
            aVar.fU(3, this.vFr);
            if (this.vFs != null) {
                aVar.g(4, this.vFs);
            }
            if (this.vFt != null) {
                aVar.g(5, this.vFt);
            }
            if (this.hvy != null) {
                aVar.g(6, this.hvy);
            }
            aVar.fU(8, this.ktm);
            aVar.fU(9, this.vFu);
            aVar.fU(10, this.vFv);
            if (this.vFw != null) {
                aVar.g(11, this.vFw);
            }
            aVar.fU(12, this.vFx);
            if (this.vFy != null) {
                aVar.g(13, this.vFy);
            }
            if (this.vFz != null) {
                aVar.g(14, this.vFz);
            }
            aVar.fU(15, this.vFA);
            if (this.vFB == null) {
                return 0;
            }
            aVar.g(16, this.vFB);
            return 0;
        } else if (i == 1) {
            if (this.ksU != null) {
                r0 = e.a.a.b.b.a.h(1, this.ksU) + 0;
            } else {
                r0 = 0;
            }
            if (this.kub != null) {
                r0 += e.a.a.b.b.a.h(2, this.kub);
            }
            r0 += e.a.a.a.fR(3, this.vFr);
            if (this.vFs != null) {
                r0 += e.a.a.b.b.a.h(4, this.vFs);
            }
            if (this.vFt != null) {
                r0 += e.a.a.b.b.a.h(5, this.vFt);
            }
            if (this.hvy != null) {
                r0 += e.a.a.b.b.a.h(6, this.hvy);
            }
            r0 = ((r0 + e.a.a.a.fR(8, this.ktm)) + e.a.a.a.fR(9, this.vFu)) + e.a.a.a.fR(10, this.vFv);
            if (this.vFw != null) {
                r0 += e.a.a.b.b.a.h(11, this.vFw);
            }
            r0 += e.a.a.a.fR(12, this.vFx);
            if (this.vFy != null) {
                r0 += e.a.a.b.b.a.h(13, this.vFy);
            }
            if (this.vFz != null) {
                r0 += e.a.a.b.b.a.h(14, this.vFz);
            }
            r0 += e.a.a.a.fR(15, this.vFA);
            if (this.vFB != null) {
                r0 += e.a.a.b.b.a.h(16, this.vFB);
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
            aq aqVar = (aq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aqVar.ksU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    aqVar.kub = aVar3.Avy.readString();
                    return 0;
                case 3:
                    aqVar.vFr = aVar3.Avy.ry();
                    return 0;
                case 4:
                    aqVar.vFs = aVar3.Avy.readString();
                    return 0;
                case 5:
                    aqVar.vFt = aVar3.Avy.readString();
                    return 0;
                case 6:
                    aqVar.hvy = aVar3.Avy.readString();
                    return 0;
                case 8:
                    aqVar.ktm = aVar3.Avy.ry();
                    return 0;
                case 9:
                    aqVar.vFu = aVar3.Avy.ry();
                    return 0;
                case 10:
                    aqVar.vFv = aVar3.Avy.ry();
                    return 0;
                case 11:
                    aqVar.vFw = aVar3.Avy.readString();
                    return 0;
                case 12:
                    aqVar.vFx = aVar3.Avy.ry();
                    return 0;
                case 13:
                    aqVar.vFy = aVar3.Avy.readString();
                    return 0;
                case 14:
                    aqVar.vFz = aVar3.Avy.readString();
                    return 0;
                case 15:
                    aqVar.vFA = aVar3.Avy.ry();
                    return 0;
                case 16:
                    aqVar.vFB = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
