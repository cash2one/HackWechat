package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public class bcd extends a {
    public int njV;
    public String vNg;
    public long wIq;
    public int wIr;
    public boolean wIs;
    public boolean wIt;
    public int wIu;
    public boolean wIv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNg != null) {
                aVar.g(1, this.vNg);
            }
            aVar.S(2, this.wIq);
            aVar.fU(3, this.wIr);
            aVar.al(4, this.wIs);
            aVar.al(5, this.wIt);
            aVar.fU(6, this.wIu);
            aVar.fU(7, this.njV);
            aVar.al(8, this.wIv);
            return 0;
        } else if (i == 1) {
            if (this.vNg != null) {
                r0 = e.a.a.b.b.a.h(1, this.vNg) + 0;
            } else {
                r0 = 0;
            }
            return ((((((r0 + e.a.a.a.R(2, this.wIq)) + e.a.a.a.fR(3, this.wIr)) + (e.a.a.b.b.a.dX(4) + 1)) + (e.a.a.b.b.a.dX(5) + 1)) + e.a.a.a.fR(6, this.wIu)) + e.a.a.a.fR(7, this.njV)) + (e.a.a.b.b.a.dX(8) + 1);
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
            bcd com_tencent_mm_protocal_c_bcd = (bcd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bcd.vNg = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bcd.wIq = aVar3.Avy.rz();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bcd.wIr = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bcd.wIs = aVar3.cJC();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bcd.wIt = aVar3.cJC();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bcd.wIu = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bcd.njV = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bcd.wIv = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
