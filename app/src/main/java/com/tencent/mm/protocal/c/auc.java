package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class auc extends a {
    public int wCb;
    public b wCc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wCb);
            if (this.wCc != null) {
                aVar.b(2, this.wCc);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wCb) + 0;
            if (this.wCc != null) {
                return r0 + e.a.a.a.a(2, this.wCc);
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
            auc com_tencent_mm_protocal_c_auc = (auc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_auc.wCb = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_auc.wCc = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
