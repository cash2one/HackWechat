package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class aod extends a {
    public String kNf;
    public double latitude;
    public double longitude;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.b(1, this.latitude);
            aVar.b(2, this.longitude);
            if (this.kNf != null) {
                aVar.g(3, this.kNf);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((e.a.a.b.b.a.dX(1) + 8) + 0) + (e.a.a.b.b.a.dX(2) + 8);
            if (this.kNf != null) {
                return r0 + e.a.a.b.b.a.h(3, this.kNf);
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
            aod com_tencent_mm_protocal_c_aod = (aod) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aod.latitude = aVar3.Avy.readDouble();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aod.longitude = aVar3.Avy.readDouble();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aod.kNf = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
