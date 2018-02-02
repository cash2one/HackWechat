package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class akt extends a {
    public double hLU;
    public int major;
    public int minor;
    public String ned;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ned != null) {
                aVar.g(1, this.ned);
            }
            aVar.fU(2, this.major);
            aVar.fU(3, this.minor);
            aVar.b(4, this.hLU);
            return 0;
        } else if (i == 1) {
            if (this.ned != null) {
                r0 = e.a.a.b.b.a.h(1, this.ned) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + e.a.a.a.fR(2, this.major)) + e.a.a.a.fR(3, this.minor)) + (e.a.a.b.b.a.dX(4) + 8);
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
            akt com_tencent_mm_protocal_c_akt = (akt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_akt.ned = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_akt.major = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_akt.minor = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_akt.hLU = aVar3.Avy.readDouble();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
