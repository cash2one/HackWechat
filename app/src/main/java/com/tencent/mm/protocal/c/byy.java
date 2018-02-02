package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class byy extends a {
    public int wPs;
    public String wXG;
    public b wYW;
    public b wYX;
    public String wYY;
    public String wYZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wXG == null) {
                throw new e.a.a.b("Not all required fields were included: Msg");
            }
            aVar.fU(1, this.wPs);
            if (this.wXG != null) {
                aVar.g(2, this.wXG);
            }
            if (this.wYW != null) {
                aVar.b(3, this.wYW);
            }
            if (this.wYX != null) {
                aVar.b(4, this.wYX);
            }
            if (this.wYY != null) {
                aVar.g(5, this.wYY);
            }
            if (this.wYZ != null) {
                aVar.g(6, this.wYZ);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wPs) + 0;
            if (this.wXG != null) {
                r0 += e.a.a.b.b.a.h(2, this.wXG);
            }
            if (this.wYW != null) {
                r0 += e.a.a.a.a(3, this.wYW);
            }
            if (this.wYX != null) {
                r0 += e.a.a.a.a(4, this.wYX);
            }
            if (this.wYY != null) {
                r0 += e.a.a.b.b.a.h(5, this.wYY);
            }
            if (this.wYZ != null) {
                return r0 + e.a.a.b.b.a.h(6, this.wYZ);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wXG != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: Msg");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            byy com_tencent_mm_protocal_c_byy = (byy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_byy.wPs = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_byy.wXG = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_byy.wYW = aVar3.cJD();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_byy.wYX = aVar3.cJD();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_byy.wYY = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_byy.wYZ = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
