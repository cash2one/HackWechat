package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class dc extends a {
    public b vIm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vIm == null) {
                throw new e.a.a.b("Not all required fields were included: Cookies");
            } else if (this.vIm == null) {
                return 0;
            } else {
                aVar.b(1, this.vIm);
                return 0;
            }
        } else if (i == 1) {
            if (this.vIm != null) {
                r0 = e.a.a.a.a(1, this.vIm) + 0;
            } else {
                r0 = 0;
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vIm != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: Cookies");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dc dcVar = (dc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dcVar.vIm = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
