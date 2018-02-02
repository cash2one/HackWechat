package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bwl extends a {
    public String fon;
    public String vIR;
    public String wEW;
    public String wXA;
    public String wXB;
    public String wXC;
    public String wXD;
    public int wXy;
    public String wXz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon != null) {
                aVar.g(1, this.fon);
            }
            if (this.vIR != null) {
                aVar.g(2, this.vIR);
            }
            aVar.fU(3, this.wXy);
            if (this.wXz != null) {
                aVar.g(4, this.wXz);
            }
            if (this.wEW != null) {
                aVar.g(5, this.wEW);
            }
            if (this.wXA != null) {
                aVar.g(6, this.wXA);
            }
            if (this.wXB != null) {
                aVar.g(7, this.wXB);
            }
            if (this.wXC != null) {
                aVar.g(8, this.wXC);
            }
            if (this.wXD == null) {
                return 0;
            }
            aVar.g(9, this.wXD);
            return 0;
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            if (this.vIR != null) {
                r0 += e.a.a.b.b.a.h(2, this.vIR);
            }
            r0 += e.a.a.a.fR(3, this.wXy);
            if (this.wXz != null) {
                r0 += e.a.a.b.b.a.h(4, this.wXz);
            }
            if (this.wEW != null) {
                r0 += e.a.a.b.b.a.h(5, this.wEW);
            }
            if (this.wXA != null) {
                r0 += e.a.a.b.b.a.h(6, this.wXA);
            }
            if (this.wXB != null) {
                r0 += e.a.a.b.b.a.h(7, this.wXB);
            }
            if (this.wXC != null) {
                r0 += e.a.a.b.b.a.h(8, this.wXC);
            }
            if (this.wXD != null) {
                r0 += e.a.a.b.b.a.h(9, this.wXD);
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
            bwl com_tencent_mm_protocal_c_bwl = (bwl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bwl.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bwl.vIR = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bwl.wXy = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bwl.wXz = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bwl.wEW = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bwl.wXA = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bwl.wXB = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bwl.wXC = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bwl.wXD = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
