package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class vv extends a {
    public String vUk;
    public long wfJ;
    public long wfK;
    public long wfL;
    public String wfM;
    public long wfN;
    public String wfO;
    public String wfP;
    public String wfQ;
    public String wfR;
    public String wfS;
    public String wfT;
    public int wfU;
    public String wfV;
    public int wfW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.wfJ);
            aVar.S(2, this.wfK);
            aVar.S(3, this.wfL);
            if (this.wfM != null) {
                aVar.g(4, this.wfM);
            }
            aVar.S(5, this.wfN);
            if (this.wfO != null) {
                aVar.g(6, this.wfO);
            }
            if (this.wfP != null) {
                aVar.g(7, this.wfP);
            }
            if (this.wfQ != null) {
                aVar.g(8, this.wfQ);
            }
            if (this.wfR != null) {
                aVar.g(9, this.wfR);
            }
            if (this.wfS != null) {
                aVar.g(10, this.wfS);
            }
            if (this.wfT != null) {
                aVar.g(11, this.wfT);
            }
            aVar.fU(12, this.wfU);
            if (this.wfV != null) {
                aVar.g(13, this.wfV);
            }
            aVar.fU(14, this.wfW);
            if (this.vUk != null) {
                aVar.g(15, this.vUk);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((e.a.a.a.R(1, this.wfJ) + 0) + e.a.a.a.R(2, this.wfK)) + e.a.a.a.R(3, this.wfL);
            if (this.wfM != null) {
                r0 += e.a.a.b.b.a.h(4, this.wfM);
            }
            r0 += e.a.a.a.R(5, this.wfN);
            if (this.wfO != null) {
                r0 += e.a.a.b.b.a.h(6, this.wfO);
            }
            if (this.wfP != null) {
                r0 += e.a.a.b.b.a.h(7, this.wfP);
            }
            if (this.wfQ != null) {
                r0 += e.a.a.b.b.a.h(8, this.wfQ);
            }
            if (this.wfR != null) {
                r0 += e.a.a.b.b.a.h(9, this.wfR);
            }
            if (this.wfS != null) {
                r0 += e.a.a.b.b.a.h(10, this.wfS);
            }
            if (this.wfT != null) {
                r0 += e.a.a.b.b.a.h(11, this.wfT);
            }
            r0 += e.a.a.a.fR(12, this.wfU);
            if (this.wfV != null) {
                r0 += e.a.a.b.b.a.h(13, this.wfV);
            }
            r0 += e.a.a.a.fR(14, this.wfW);
            if (this.vUk != null) {
                return r0 + e.a.a.b.b.a.h(15, this.vUk);
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
            vv vvVar = (vv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vvVar.wfJ = aVar3.Avy.rz();
                    return 0;
                case 2:
                    vvVar.wfK = aVar3.Avy.rz();
                    return 0;
                case 3:
                    vvVar.wfL = aVar3.Avy.rz();
                    return 0;
                case 4:
                    vvVar.wfM = aVar3.Avy.readString();
                    return 0;
                case 5:
                    vvVar.wfN = aVar3.Avy.rz();
                    return 0;
                case 6:
                    vvVar.wfO = aVar3.Avy.readString();
                    return 0;
                case 7:
                    vvVar.wfP = aVar3.Avy.readString();
                    return 0;
                case 8:
                    vvVar.wfQ = aVar3.Avy.readString();
                    return 0;
                case 9:
                    vvVar.wfR = aVar3.Avy.readString();
                    return 0;
                case 10:
                    vvVar.wfS = aVar3.Avy.readString();
                    return 0;
                case 11:
                    vvVar.wfT = aVar3.Avy.readString();
                    return 0;
                case 12:
                    vvVar.wfU = aVar3.Avy.ry();
                    return 0;
                case 13:
                    vvVar.wfV = aVar3.Avy.readString();
                    return 0;
                case 14:
                    vvVar.wfW = aVar3.Avy.ry();
                    return 0;
                case 15:
                    vvVar.vUk = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
