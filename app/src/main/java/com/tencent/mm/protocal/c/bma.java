package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bma extends a {
    public int ktL;
    public int wPB;
    public int wPC;
    public int wPD;
    public int wPE;
    public int wPF;
    public int wPG;
    public int waZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.ktL);
            aVar.fU(2, this.waZ);
            aVar.fU(3, this.wPB);
            aVar.fU(4, this.wPC);
            aVar.fU(5, this.wPD);
            aVar.fU(6, this.wPE);
            aVar.fU(7, this.wPF);
            aVar.fU(8, this.wPG);
            return 0;
        } else if (i == 1) {
            return (((((((e.a.a.a.fR(1, this.ktL) + 0) + e.a.a.a.fR(2, this.waZ)) + e.a.a.a.fR(3, this.wPB)) + e.a.a.a.fR(4, this.wPC)) + e.a.a.a.fR(5, this.wPD)) + e.a.a.a.fR(6, this.wPE)) + e.a.a.a.fR(7, this.wPF)) + e.a.a.a.fR(8, this.wPG);
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
                bma com_tencent_mm_protocal_c_bma = (bma) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bma.ktL = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bma.waZ = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_bma.wPB = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_bma.wPC = aVar3.Avy.ry();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_bma.wPD = aVar3.Avy.ry();
                        return 0;
                    case 6:
                        com_tencent_mm_protocal_c_bma.wPE = aVar3.Avy.ry();
                        return 0;
                    case 7:
                        com_tencent_mm_protocal_c_bma.wPF = aVar3.Avy.ry();
                        return 0;
                    case 8:
                        com_tencent_mm_protocal_c_bma.wPG = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
