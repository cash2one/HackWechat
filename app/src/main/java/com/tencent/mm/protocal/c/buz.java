package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class buz extends bcv {
    public int vWK;
    public int wOO;
    public int wOP;
    public int wOQ;
    public int wOR;
    public int wOS;
    public LinkedList<Integer> wOT = new LinkedList();
    public int wOU;
    public int wOV;
    public LinkedList<Integer> wOW = new LinkedList();
    public int wOX;
    public int wOY;
    public int wbh;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.wbh);
            aVar.fU(3, this.wOO);
            aVar.fU(4, this.vWK);
            aVar.fU(5, this.wOP);
            aVar.fU(6, this.wOQ);
            aVar.fU(7, this.wOR);
            aVar.fU(8, this.wOS);
            aVar.c(9, this.wOT);
            aVar.fU(10, this.wOU);
            aVar.fU(11, this.wOV);
            aVar.c(12, this.wOW);
            aVar.fU(13, this.wOX);
            aVar.fU(14, this.wOY);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            return ((((((((((((r0 + e.a.a.a.fR(2, this.wbh)) + e.a.a.a.fR(3, this.wOO)) + e.a.a.a.fR(4, this.vWK)) + e.a.a.a.fR(5, this.wOP)) + e.a.a.a.fR(6, this.wOQ)) + e.a.a.a.fR(7, this.wOR)) + e.a.a.a.fR(8, this.wOS)) + e.a.a.a.b(9, this.wOT)) + e.a.a.a.fR(10, this.wOU)) + e.a.a.a.fR(11, this.wOV)) + e.a.a.a.b(12, this.wOW)) + e.a.a.a.fR(13, this.wOX)) + e.a.a.a.fR(14, this.wOY);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wOT.clear();
            this.wOW.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            buz com_tencent_mm_protocal_c_buz = (buz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_buz.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_buz.wbh = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_buz.wOO = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_buz.vWK = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_buz.wOP = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_buz.wOQ = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_buz.wOR = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_buz.wOS = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_buz.wOT = new e.a.a.a.a(aVar3.cJD().oz, unknownTagHandler).cJA();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_buz.wOU = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_buz.wOV = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_buz.wOW = new e.a.a.a.a(aVar3.cJD().oz, unknownTagHandler).cJA();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_buz.wOX = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_buz.wOY = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
