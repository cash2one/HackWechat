package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class atl extends a {
    public long wBA;
    public int wBy;
    public long wBz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wBy);
            aVar.S(2, this.wBz);
            aVar.S(3, this.wBA);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.fR(1, this.wBy) + 0) + e.a.a.a.R(2, this.wBz)) + e.a.a.a.R(3, this.wBA);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                atl com_tencent_mm_protocal_c_atl = (atl) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_atl.wBy = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_atl.wBz = aVar3.Avy.rz();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_atl.wBA = aVar3.Avy.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
