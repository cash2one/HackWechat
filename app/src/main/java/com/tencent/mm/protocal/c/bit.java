package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class bit extends a {
    public String vIR;
    public int vLg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vIR == null) {
                throw new b("Not all required fields were included: ProductID");
            }
            if (this.vIR != null) {
                aVar.g(1, this.vIR);
            }
            aVar.fU(2, this.vLg);
            return 0;
        } else if (i == 1) {
            if (this.vIR != null) {
                r0 = e.a.a.b.b.a.h(1, this.vIR) + 0;
            } else {
                r0 = 0;
            }
            return r0 + e.a.a.a.fR(2, this.vLg);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vIR != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ProductID");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bit com_tencent_mm_protocal_c_bit = (bit) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bit.vIR = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bit.vLg = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
