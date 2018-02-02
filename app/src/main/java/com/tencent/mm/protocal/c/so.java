package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class so extends a {
    public String nfT;
    public String vIR;
    public int waA;
    public String waB;
    public String waC;
    public String waD;
    public String waE;
    public String waI;
    public int waZ;
    public String war;
    public String was;
    public String wat;
    public String wau;
    public int wav;
    public int waw;
    public String waz;
    public String wba;
    public String wbb;
    public String wbc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vIR != null) {
                aVar.g(1, this.vIR);
            }
            if (this.nfT != null) {
                aVar.g(2, this.nfT);
            }
            if (this.war != null) {
                aVar.g(3, this.war);
            }
            if (this.was != null) {
                aVar.g(4, this.was);
            }
            if (this.wat != null) {
                aVar.g(5, this.wat);
            }
            if (this.wau != null) {
                aVar.g(6, this.wau);
            }
            aVar.fU(7, this.wav);
            aVar.fU(8, this.waw);
            if (this.waz != null) {
                aVar.g(9, this.waz);
            }
            aVar.fU(10, this.waA);
            if (this.waB != null) {
                aVar.g(11, this.waB);
            }
            aVar.fU(12, this.waZ);
            if (this.waE != null) {
                aVar.g(13, this.waE);
            }
            if (this.waC != null) {
                aVar.g(14, this.waC);
            }
            if (this.waD != null) {
                aVar.g(15, this.waD);
            }
            if (this.wba != null) {
                aVar.g(16, this.wba);
            }
            if (this.waI != null) {
                aVar.g(17, this.waI);
            }
            if (this.wbb != null) {
                aVar.g(18, this.wbb);
            }
            if (this.wbc == null) {
                return 0;
            }
            aVar.g(19, this.wbc);
            return 0;
        } else if (i == 1) {
            if (this.vIR != null) {
                r0 = e.a.a.b.b.a.h(1, this.vIR) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfT != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfT);
            }
            if (this.war != null) {
                r0 += e.a.a.b.b.a.h(3, this.war);
            }
            if (this.was != null) {
                r0 += e.a.a.b.b.a.h(4, this.was);
            }
            if (this.wat != null) {
                r0 += e.a.a.b.b.a.h(5, this.wat);
            }
            if (this.wau != null) {
                r0 += e.a.a.b.b.a.h(6, this.wau);
            }
            r0 = (r0 + e.a.a.a.fR(7, this.wav)) + e.a.a.a.fR(8, this.waw);
            if (this.waz != null) {
                r0 += e.a.a.b.b.a.h(9, this.waz);
            }
            r0 += e.a.a.a.fR(10, this.waA);
            if (this.waB != null) {
                r0 += e.a.a.b.b.a.h(11, this.waB);
            }
            r0 += e.a.a.a.fR(12, this.waZ);
            if (this.waE != null) {
                r0 += e.a.a.b.b.a.h(13, this.waE);
            }
            if (this.waC != null) {
                r0 += e.a.a.b.b.a.h(14, this.waC);
            }
            if (this.waD != null) {
                r0 += e.a.a.b.b.a.h(15, this.waD);
            }
            if (this.wba != null) {
                r0 += e.a.a.b.b.a.h(16, this.wba);
            }
            if (this.waI != null) {
                r0 += e.a.a.b.b.a.h(17, this.waI);
            }
            if (this.wbb != null) {
                r0 += e.a.a.b.b.a.h(18, this.wbb);
            }
            if (this.wbc != null) {
                r0 += e.a.a.b.b.a.h(19, this.wbc);
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
            so soVar = (so) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    soVar.vIR = aVar3.Avy.readString();
                    return 0;
                case 2:
                    soVar.nfT = aVar3.Avy.readString();
                    return 0;
                case 3:
                    soVar.war = aVar3.Avy.readString();
                    return 0;
                case 4:
                    soVar.was = aVar3.Avy.readString();
                    return 0;
                case 5:
                    soVar.wat = aVar3.Avy.readString();
                    return 0;
                case 6:
                    soVar.wau = aVar3.Avy.readString();
                    return 0;
                case 7:
                    soVar.wav = aVar3.Avy.ry();
                    return 0;
                case 8:
                    soVar.waw = aVar3.Avy.ry();
                    return 0;
                case 9:
                    soVar.waz = aVar3.Avy.readString();
                    return 0;
                case 10:
                    soVar.waA = aVar3.Avy.ry();
                    return 0;
                case 11:
                    soVar.waB = aVar3.Avy.readString();
                    return 0;
                case 12:
                    soVar.waZ = aVar3.Avy.ry();
                    return 0;
                case 13:
                    soVar.waE = aVar3.Avy.readString();
                    return 0;
                case 14:
                    soVar.waC = aVar3.Avy.readString();
                    return 0;
                case 15:
                    soVar.waD = aVar3.Avy.readString();
                    return 0;
                case 16:
                    soVar.wba = aVar3.Avy.readString();
                    return 0;
                case 17:
                    soVar.waI = aVar3.Avy.readString();
                    return 0;
                case 18:
                    soVar.wbb = aVar3.Avy.readString();
                    return 0;
                case 19:
                    soVar.wbc = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
