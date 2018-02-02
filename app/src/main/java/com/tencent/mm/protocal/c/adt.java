package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class adt extends a {
    public String wmk;
    public String wml;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wmk != null) {
                aVar.g(1, this.wmk);
            }
            if (this.wml == null) {
                return 0;
            }
            aVar.g(2, this.wml);
            return 0;
        } else if (i == 1) {
            if (this.wmk != null) {
                r0 = e.a.a.b.b.a.h(1, this.wmk) + 0;
            } else {
                r0 = 0;
            }
            if (this.wml != null) {
                r0 += e.a.a.b.b.a.h(2, this.wml);
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
            adt com_tencent_mm_protocal_c_adt = (adt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_adt.wmk = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_adt.wml = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
