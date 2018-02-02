package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class ayc extends a {
    public int wFo;
    public String wvP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wvP == null) {
                throw new b("Not all required fields were included: Ip");
            }
            if (this.wvP != null) {
                aVar.g(1, this.wvP);
            }
            aVar.fU(2, this.wFo);
            return 0;
        } else if (i == 1) {
            if (this.wvP != null) {
                r0 = e.a.a.b.b.a.h(1, this.wvP) + 0;
            } else {
                r0 = 0;
            }
            return r0 + e.a.a.a.fR(2, this.wFo);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wvP != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Ip");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ayc com_tencent_mm_protocal_c_ayc = (ayc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ayc.wvP = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ayc.wFo = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
