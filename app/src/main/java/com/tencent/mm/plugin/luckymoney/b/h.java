package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.bq.a;

public final class h extends a {
    public String nZa;
    public int obK;
    public String obP;
    public long obS;
    public long obU;
    public String obV;
    public int ocg;
    public String ocp;
    public long ocq;
    public String ocr;
    public String ocs;
    public String oct;
    public long ocu;
    public int ocv;
    public int status;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ocp != null) {
                aVar.g(1, this.ocp);
            }
            if (this.obP != null) {
                aVar.g(2, this.obP);
            }
            aVar.S(3, this.ocq);
            if (this.ocr != null) {
                aVar.g(4, this.ocr);
            }
            aVar.fU(5, this.obK);
            if (this.ocs != null) {
                aVar.g(6, this.ocs);
            }
            if (this.oct != null) {
                aVar.g(7, this.oct);
            }
            aVar.S(8, this.obU);
            aVar.S(9, this.ocu);
            aVar.S(10, this.obS);
            aVar.fU(11, this.status);
            aVar.fU(12, this.ocv);
            if (this.obV != null) {
                aVar.g(13, this.obV);
            }
            if (this.nZa != null) {
                aVar.g(14, this.nZa);
            }
            aVar.fU(15, this.ocg);
            return 0;
        } else if (i == 1) {
            if (this.ocp != null) {
                r0 = e.a.a.b.b.a.h(1, this.ocp) + 0;
            } else {
                r0 = 0;
            }
            if (this.obP != null) {
                r0 += e.a.a.b.b.a.h(2, this.obP);
            }
            r0 += e.a.a.a.R(3, this.ocq);
            if (this.ocr != null) {
                r0 += e.a.a.b.b.a.h(4, this.ocr);
            }
            r0 += e.a.a.a.fR(5, this.obK);
            if (this.ocs != null) {
                r0 += e.a.a.b.b.a.h(6, this.ocs);
            }
            if (this.oct != null) {
                r0 += e.a.a.b.b.a.h(7, this.oct);
            }
            r0 = ((((r0 + e.a.a.a.R(8, this.obU)) + e.a.a.a.R(9, this.ocu)) + e.a.a.a.R(10, this.obS)) + e.a.a.a.fR(11, this.status)) + e.a.a.a.fR(12, this.ocv);
            if (this.obV != null) {
                r0 += e.a.a.b.b.a.h(13, this.obV);
            }
            if (this.nZa != null) {
                r0 += e.a.a.b.b.a.h(14, this.nZa);
            }
            return r0 + e.a.a.a.fR(15, this.ocg);
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
            h hVar = (h) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hVar.ocp = aVar3.Avy.readString();
                    return 0;
                case 2:
                    hVar.obP = aVar3.Avy.readString();
                    return 0;
                case 3:
                    hVar.ocq = aVar3.Avy.rz();
                    return 0;
                case 4:
                    hVar.ocr = aVar3.Avy.readString();
                    return 0;
                case 5:
                    hVar.obK = aVar3.Avy.ry();
                    return 0;
                case 6:
                    hVar.ocs = aVar3.Avy.readString();
                    return 0;
                case 7:
                    hVar.oct = aVar3.Avy.readString();
                    return 0;
                case 8:
                    hVar.obU = aVar3.Avy.rz();
                    return 0;
                case 9:
                    hVar.ocu = aVar3.Avy.rz();
                    return 0;
                case 10:
                    hVar.obS = aVar3.Avy.rz();
                    return 0;
                case 11:
                    hVar.status = aVar3.Avy.ry();
                    return 0;
                case 12:
                    hVar.ocv = aVar3.Avy.ry();
                    return 0;
                case 13:
                    hVar.obV = aVar3.Avy.readString();
                    return 0;
                case 14:
                    hVar.nZa = aVar3.Avy.readString();
                    return 0;
                case 15:
                    hVar.ocg = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
