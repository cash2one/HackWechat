package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class bts extends a {
    public long wUT;
    public int wVd;
    public int wVe;
    public int wVf;
    public int wVg;
    public b wVh;
    public long wbi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.wUT);
            aVar.S(2, this.wbi);
            aVar.fU(3, this.wVd);
            aVar.fU(4, this.wVe);
            aVar.fU(5, this.wVf);
            aVar.fU(6, this.wVg);
            if (this.wVh != null) {
                aVar.b(7, this.wVh);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((((e.a.a.a.R(1, this.wUT) + 0) + e.a.a.a.R(2, this.wbi)) + e.a.a.a.fR(3, this.wVd)) + e.a.a.a.fR(4, this.wVe)) + e.a.a.a.fR(5, this.wVf)) + e.a.a.a.fR(6, this.wVg);
            if (this.wVh != null) {
                return r0 + e.a.a.a.a(7, this.wVh);
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
            bts com_tencent_mm_protocal_c_bts = (bts) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bts.wUT = aVar3.Avy.rz();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bts.wbi = aVar3.Avy.rz();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bts.wVd = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bts.wVe = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bts.wVf = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bts.wVg = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bts.wVh = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
