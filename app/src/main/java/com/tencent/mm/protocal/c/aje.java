package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class aje extends a {
    public String ksU;
    public String kub;
    public int vJU;
    public String vLO;
    public String whR;
    public String wqD;
    public String wqE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vLO != null) {
                aVar.g(1, this.vLO);
            }
            if (this.ksU != null) {
                aVar.g(2, this.ksU);
            }
            if (this.wqD != null) {
                aVar.g(3, this.wqD);
            }
            if (this.wqE != null) {
                aVar.g(4, this.wqE);
            }
            aVar.fU(5, this.vJU);
            if (this.kub != null) {
                aVar.g(6, this.kub);
            }
            if (this.whR == null) {
                return 0;
            }
            aVar.g(7, this.whR);
            return 0;
        } else if (i == 1) {
            if (this.vLO != null) {
                r0 = e.a.a.b.b.a.h(1, this.vLO) + 0;
            } else {
                r0 = 0;
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(2, this.ksU);
            }
            if (this.wqD != null) {
                r0 += e.a.a.b.b.a.h(3, this.wqD);
            }
            if (this.wqE != null) {
                r0 += e.a.a.b.b.a.h(4, this.wqE);
            }
            r0 += e.a.a.a.fR(5, this.vJU);
            if (this.kub != null) {
                r0 += e.a.a.b.b.a.h(6, this.kub);
            }
            if (this.whR != null) {
                r0 += e.a.a.b.b.a.h(7, this.whR);
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
            aje com_tencent_mm_protocal_c_aje = (aje) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aje.vLO = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aje.ksU = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aje.wqD = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aje.wqE = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aje.vJU = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aje.kub = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aje.whR = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
