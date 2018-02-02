package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bll extends a {
    public int wOB;
    public int wOC;
    public int wOD;
    public btg wOE;
    public int wOF;
    public int wOG;
    public int wOH;
    public int wOI;
    public LinkedList<Integer> wOJ = new LinkedList();
    public int wOK;
    public LinkedList<Integer> wOL = new LinkedList();
    public int wOM;
    public LinkedList<Integer> wON = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wOE == null) {
                throw new b("Not all required fields were included: Addr");
            }
            aVar.fU(1, this.wOB);
            aVar.fU(2, this.wOC);
            aVar.fU(3, this.wOD);
            if (this.wOE != null) {
                aVar.fW(4, this.wOE.bke());
                this.wOE.a(aVar);
            }
            aVar.fU(5, this.wOF);
            aVar.fU(6, this.wOG);
            aVar.fU(7, this.wOH);
            aVar.fU(8, this.wOI);
            aVar.c(9, this.wOJ);
            aVar.fU(10, this.wOK);
            aVar.c(11, this.wOL);
            aVar.fU(12, this.wOM);
            aVar.c(13, this.wON);
            return 0;
        } else if (i == 1) {
            r0 = ((e.a.a.a.fR(1, this.wOB) + 0) + e.a.a.a.fR(2, this.wOC)) + e.a.a.a.fR(3, this.wOD);
            if (this.wOE != null) {
                r0 += e.a.a.a.fT(4, this.wOE.bke());
            }
            return ((((((((r0 + e.a.a.a.fR(5, this.wOF)) + e.a.a.a.fR(6, this.wOG)) + e.a.a.a.fR(7, this.wOH)) + e.a.a.a.fR(8, this.wOI)) + e.a.a.a.b(9, this.wOJ)) + e.a.a.a.fR(10, this.wOK)) + e.a.a.a.b(11, this.wOL)) + e.a.a.a.fR(12, this.wOM)) + e.a.a.a.b(13, this.wON);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wOJ.clear();
            this.wOL.clear();
            this.wON.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wOE != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Addr");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bll com_tencent_mm_protocal_c_bll = (bll) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bll.wOB = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bll.wOC = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bll.wOD = aVar3.Avy.ry();
                    return 0;
                case 4:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_btg = new btg();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_btg.a(aVar4, com_tencent_mm_protocal_c_btg, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bll.wOE = com_tencent_mm_protocal_c_btg;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bll.wOF = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bll.wOG = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bll.wOH = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bll.wOI = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bll.wOJ = new e.a.a.a.a(aVar3.cJD().oz, unknownTagHandler).cJA();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bll.wOK = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bll.wOL = new e.a.a.a.a(aVar3.cJD().oz, unknownTagHandler).cJA();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bll.wOM = aVar3.Avy.ry();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bll.wON = new e.a.a.a.a(aVar3.cJD().oz, unknownTagHandler).cJA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
