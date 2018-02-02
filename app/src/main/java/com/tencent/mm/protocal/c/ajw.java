package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class ajw extends a {
    public b vKZ;
    public b vLb;
    public b wrc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vLb != null) {
                aVar.b(1, this.vLb);
            }
            if (this.vKZ != null) {
                aVar.b(2, this.vKZ);
            }
            if (this.wrc == null) {
                return 0;
            }
            aVar.b(3, this.wrc);
            return 0;
        } else if (i == 1) {
            if (this.vLb != null) {
                r0 = e.a.a.a.a(1, this.vLb) + 0;
            } else {
                r0 = 0;
            }
            if (this.vKZ != null) {
                r0 += e.a.a.a.a(2, this.vKZ);
            }
            if (this.wrc != null) {
                r0 += e.a.a.a.a(3, this.wrc);
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
            ajw com_tencent_mm_protocal_c_ajw = (ajw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ajw.vLb = aVar3.cJD();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ajw.vKZ = aVar3.cJD();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ajw.wrc = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
