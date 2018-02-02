package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class avb extends a {
    public String fon;
    public String nje;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nje != null) {
                aVar.g(1, this.nje);
            }
            if (this.fon == null) {
                return 0;
            }
            aVar.g(2, this.fon);
            return 0;
        } else if (i == 1) {
            if (this.nje != null) {
                r0 = e.a.a.b.b.a.h(1, this.nje) + 0;
            } else {
                r0 = 0;
            }
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(2, this.fon);
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
            avb com_tencent_mm_protocal_c_avb = (avb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_avb.nje = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_avb.fon = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
