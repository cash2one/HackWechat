package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ako extends a {
    public String fon;
    public int ktN;
    public String nfX;
    public String niZ;
    public String vWd;
    public String wrO;
    public String wrP;
    public String wrQ;
    public String wrR;
    public int wrS;
    public String wrT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon != null) {
                aVar.g(1, this.fon);
            }
            if (this.wrO != null) {
                aVar.g(2, this.wrO);
            }
            aVar.fU(3, this.ktN);
            if (this.nfX != null) {
                aVar.g(4, this.nfX);
            }
            if (this.wrP != null) {
                aVar.g(5, this.wrP);
            }
            if (this.vWd != null) {
                aVar.g(6, this.vWd);
            }
            if (this.wrQ != null) {
                aVar.g(7, this.wrQ);
            }
            if (this.niZ != null) {
                aVar.g(8, this.niZ);
            }
            if (this.wrR != null) {
                aVar.g(9, this.wrR);
            }
            aVar.fU(10, this.wrS);
            if (this.wrT == null) {
                return 0;
            }
            aVar.g(11, this.wrT);
            return 0;
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            if (this.wrO != null) {
                r0 += e.a.a.b.b.a.h(2, this.wrO);
            }
            r0 += e.a.a.a.fR(3, this.ktN);
            if (this.nfX != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfX);
            }
            if (this.wrP != null) {
                r0 += e.a.a.b.b.a.h(5, this.wrP);
            }
            if (this.vWd != null) {
                r0 += e.a.a.b.b.a.h(6, this.vWd);
            }
            if (this.wrQ != null) {
                r0 += e.a.a.b.b.a.h(7, this.wrQ);
            }
            if (this.niZ != null) {
                r0 += e.a.a.b.b.a.h(8, this.niZ);
            }
            if (this.wrR != null) {
                r0 += e.a.a.b.b.a.h(9, this.wrR);
            }
            r0 += e.a.a.a.fR(10, this.wrS);
            if (this.wrT != null) {
                r0 += e.a.a.b.b.a.h(11, this.wrT);
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
            ako com_tencent_mm_protocal_c_ako = (ako) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ako.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ako.wrO = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ako.ktN = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ako.nfX = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ako.wrP = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ako.vWd = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ako.wrQ = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ako.niZ = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ako.wrR = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ako.wrS = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ako.wrT = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
