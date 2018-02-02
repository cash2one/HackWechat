package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bci extends a {
    public String ktz;
    public int qxG;
    public String vOf;
    public String vOg;
    public String vOh;
    public String vOi;
    public String wIA;
    public int wIy;
    public int wIz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ktz != null) {
                aVar.g(1, this.ktz);
            }
            aVar.fU(2, this.wIy);
            if (this.vOf != null) {
                aVar.g(3, this.vOf);
            }
            if (this.vOg != null) {
                aVar.g(4, this.vOg);
            }
            aVar.fU(5, this.qxG);
            aVar.fU(6, this.wIz);
            if (this.vOh != null) {
                aVar.g(7, this.vOh);
            }
            if (this.vOi != null) {
                aVar.g(8, this.vOi);
            }
            if (this.wIA == null) {
                return 0;
            }
            aVar.g(9, this.wIA);
            return 0;
        } else if (i == 1) {
            if (this.ktz != null) {
                r0 = e.a.a.b.b.a.h(1, this.ktz) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.wIy);
            if (this.vOf != null) {
                r0 += e.a.a.b.b.a.h(3, this.vOf);
            }
            if (this.vOg != null) {
                r0 += e.a.a.b.b.a.h(4, this.vOg);
            }
            r0 = (r0 + e.a.a.a.fR(5, this.qxG)) + e.a.a.a.fR(6, this.wIz);
            if (this.vOh != null) {
                r0 += e.a.a.b.b.a.h(7, this.vOh);
            }
            if (this.vOi != null) {
                r0 += e.a.a.b.b.a.h(8, this.vOi);
            }
            if (this.wIA != null) {
                r0 += e.a.a.b.b.a.h(9, this.wIA);
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
            bci com_tencent_mm_protocal_c_bci = (bci) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bci.ktz = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bci.wIy = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bci.vOf = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bci.vOg = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bci.qxG = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bci.wIz = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bci.vOh = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bci.vOi = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bci.wIA = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
