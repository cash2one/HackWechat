package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ath extends a {
    public int wBo;
    public int wBp;
    public int wBq;
    public int wBr;
    public int wBs;
    public int wBt;
    public int wuu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wuu);
            aVar.fU(2, this.wBo);
            aVar.fU(3, this.wBp);
            aVar.fU(4, this.wBq);
            aVar.fU(5, this.wBr);
            aVar.fU(6, this.wBs);
            aVar.fU(7, this.wBt);
            return 0;
        } else if (i == 1) {
            return ((((((e.a.a.a.fR(1, this.wuu) + 0) + e.a.a.a.fR(2, this.wBo)) + e.a.a.a.fR(3, this.wBp)) + e.a.a.a.fR(4, this.wBq)) + e.a.a.a.fR(5, this.wBr)) + e.a.a.a.fR(6, this.wBs)) + e.a.a.a.fR(7, this.wBt);
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
                ath com_tencent_mm_protocal_c_ath = (ath) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_ath.wuu = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_ath.wBo = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_ath.wBp = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_ath.wBq = aVar3.Avy.ry();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_ath.wBr = aVar3.Avy.ry();
                        return 0;
                    case 6:
                        com_tencent_mm_protocal_c_ath.wBs = aVar3.Avy.ry();
                        return 0;
                    case 7:
                        com_tencent_mm_protocal_c_ath.wBt = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
