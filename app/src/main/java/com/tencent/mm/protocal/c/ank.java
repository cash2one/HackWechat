package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class ank extends a {
    public int ksO;
    public int vZk;
    public int wuu;
    public b wuv;
    public int wuw;
    public int wux;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wuu);
            if (this.wuv != null) {
                aVar.b(2, this.wuv);
            }
            aVar.fU(3, this.wuw);
            aVar.fU(4, this.vZk);
            aVar.fU(5, this.ksO);
            aVar.fU(6, this.wux);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wuu) + 0;
            if (this.wuv != null) {
                r0 += e.a.a.a.a(2, this.wuv);
            }
            return (((r0 + e.a.a.a.fR(3, this.wuw)) + e.a.a.a.fR(4, this.vZk)) + e.a.a.a.fR(5, this.ksO)) + e.a.a.a.fR(6, this.wux);
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
            ank com_tencent_mm_protocal_c_ank = (ank) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ank.wuu = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ank.wuv = aVar3.cJD();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ank.wuw = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ank.vZk = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ank.ksO = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ank.wux = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
