package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class axj extends a {
    public String hvC;
    public String hvv;
    public float vQt;
    public float vQu;
    public String wEA;
    public long wEB;
    public String wEz;
    public String wrN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wEz != null) {
                aVar.g(1, this.wEz);
            }
            if (this.hvC != null) {
                aVar.g(2, this.hvC);
            }
            if (this.hvv != null) {
                aVar.g(3, this.hvv);
            }
            if (this.wrN != null) {
                aVar.g(4, this.wrN);
            }
            aVar.m(5, this.vQu);
            aVar.m(6, this.vQt);
            if (this.wEA != null) {
                aVar.g(7, this.wEA);
            }
            aVar.S(8, this.wEB);
            return 0;
        } else if (i == 1) {
            if (this.wEz != null) {
                r0 = e.a.a.b.b.a.h(1, this.wEz) + 0;
            } else {
                r0 = 0;
            }
            if (this.hvC != null) {
                r0 += e.a.a.b.b.a.h(2, this.hvC);
            }
            if (this.hvv != null) {
                r0 += e.a.a.b.b.a.h(3, this.hvv);
            }
            if (this.wrN != null) {
                r0 += e.a.a.b.b.a.h(4, this.wrN);
            }
            r0 = (r0 + (e.a.a.b.b.a.dX(5) + 4)) + (e.a.a.b.b.a.dX(6) + 4);
            if (this.wEA != null) {
                r0 += e.a.a.b.b.a.h(7, this.wEA);
            }
            return r0 + e.a.a.a.R(8, this.wEB);
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
            axj com_tencent_mm_protocal_c_axj = (axj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_axj.wEz = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axj.hvC = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axj.hvv = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axj.wrN = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_axj.vQu = aVar3.Avy.readFloat();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_axj.vQt = aVar3.Avy.readFloat();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_axj.wEA = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_axj.wEB = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
