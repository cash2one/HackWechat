package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class byr extends a {
    public String vIy;
    public long wFp;
    public boolean wYP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vIy == null) {
                throw new b("Not all required fields were included: Username");
            }
            if (this.vIy != null) {
                aVar.g(1, this.vIy);
            }
            aVar.S(2, this.wFp);
            aVar.al(3, this.wYP);
            return 0;
        } else if (i == 1) {
            if (this.vIy != null) {
                r0 = e.a.a.b.b.a.h(1, this.vIy) + 0;
            } else {
                r0 = 0;
            }
            return (r0 + e.a.a.a.R(2, this.wFp)) + (e.a.a.b.b.a.dX(3) + 1);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vIy != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Username");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            byr com_tencent_mm_protocal_c_byr = (byr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_byr.vIy = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_byr.wFp = aVar3.Avy.rz();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_byr.wYP = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
