package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class ano extends a {
    public int ksO;
    public int wuC;
    public int wuD;
    public int wuu;
    public b wuv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wuu);
            if (this.wuv != null) {
                aVar.b(2, this.wuv);
            }
            aVar.fU(3, this.wuC);
            aVar.fU(4, this.ksO);
            aVar.fU(5, this.wuD);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wuu) + 0;
            if (this.wuv != null) {
                r0 += e.a.a.a.a(2, this.wuv);
            }
            return ((r0 + e.a.a.a.fR(3, this.wuC)) + e.a.a.a.fR(4, this.ksO)) + e.a.a.a.fR(5, this.wuD);
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
            ano com_tencent_mm_protocal_c_ano = (ano) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ano.wuu = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ano.wuv = aVar3.cJD();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ano.wuC = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ano.ksO = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ano.wuD = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
