package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class cbg extends a {
    public b vNh;
    public String xaw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xaw != null) {
                aVar.g(1, this.xaw);
            }
            if (this.vNh == null) {
                return 0;
            }
            aVar.b(2, this.vNh);
            return 0;
        } else if (i == 1) {
            if (this.xaw != null) {
                r0 = e.a.a.b.b.a.h(1, this.xaw) + 0;
            } else {
                r0 = 0;
            }
            if (this.vNh != null) {
                r0 += e.a.a.a.a(2, this.vNh);
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
            cbg com_tencent_mm_protocal_c_cbg = (cbg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_cbg.xaw = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_cbg.vNh = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
