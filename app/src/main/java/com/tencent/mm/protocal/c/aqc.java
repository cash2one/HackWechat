package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class aqc extends a {
    public boolean wwO;
    public boolean wwP;
    public int wwQ;
    public int wwR;
    public String wwS;
    public boolean wwT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.al(1, this.wwO);
            aVar.al(2, this.wwP);
            aVar.fU(3, this.wwQ);
            aVar.fU(4, this.wwR);
            if (this.wwS != null) {
                aVar.g(5, this.wwS);
            }
            aVar.al(6, this.wwT);
            return 0;
        } else if (i == 1) {
            r0 = ((((e.a.a.b.b.a.dX(1) + 1) + 0) + (e.a.a.b.b.a.dX(2) + 1)) + e.a.a.a.fR(3, this.wwQ)) + e.a.a.a.fR(4, this.wwR);
            if (this.wwS != null) {
                r0 += e.a.a.b.b.a.h(5, this.wwS);
            }
            return r0 + (e.a.a.b.b.a.dX(6) + 1);
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
            aqc com_tencent_mm_protocal_c_aqc = (aqc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aqc.wwO = aVar3.cJC();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aqc.wwP = aVar3.cJC();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aqc.wwQ = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aqc.wwR = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aqc.wwS = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aqc.wwT = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
