package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bxt extends a {
    public String ksY;
    public String vJA;
    public String vOf;
    public String vOg;
    public String vOh;
    public String vOi;
    public String wYt;
    public String wYu;
    public String wYv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vJA != null) {
                aVar.g(1, this.vJA);
            }
            if (this.vOg != null) {
                aVar.g(2, this.vOg);
            }
            if (this.vOf != null) {
                aVar.g(3, this.vOf);
            }
            if (this.ksY != null) {
                aVar.g(4, this.ksY);
            }
            if (this.wYt != null) {
                aVar.g(5, this.wYt);
            }
            if (this.vOh != null) {
                aVar.g(6, this.vOh);
            }
            if (this.vOi != null) {
                aVar.g(7, this.vOi);
            }
            if (this.wYu != null) {
                aVar.g(8, this.wYu);
            }
            if (this.wYv == null) {
                return 0;
            }
            aVar.g(9, this.wYv);
            return 0;
        } else if (i == 1) {
            if (this.vJA != null) {
                r0 = e.a.a.b.b.a.h(1, this.vJA) + 0;
            } else {
                r0 = 0;
            }
            if (this.vOg != null) {
                r0 += e.a.a.b.b.a.h(2, this.vOg);
            }
            if (this.vOf != null) {
                r0 += e.a.a.b.b.a.h(3, this.vOf);
            }
            if (this.ksY != null) {
                r0 += e.a.a.b.b.a.h(4, this.ksY);
            }
            if (this.wYt != null) {
                r0 += e.a.a.b.b.a.h(5, this.wYt);
            }
            if (this.vOh != null) {
                r0 += e.a.a.b.b.a.h(6, this.vOh);
            }
            if (this.vOi != null) {
                r0 += e.a.a.b.b.a.h(7, this.vOi);
            }
            if (this.wYu != null) {
                r0 += e.a.a.b.b.a.h(8, this.wYu);
            }
            if (this.wYv != null) {
                r0 += e.a.a.b.b.a.h(9, this.wYv);
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
            bxt com_tencent_mm_protocal_c_bxt = (bxt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bxt.vJA = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bxt.vOg = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bxt.vOf = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bxt.ksY = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bxt.wYt = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bxt.vOh = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bxt.vOi = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bxt.wYu = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bxt.wYv = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
