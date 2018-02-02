package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class abz extends bdf {
    public bdn vHG;
    public int wkH;
    public LinkedList<so> wkI = new LinkedList();
    public sd wkJ;
    public int wkK;
    public LinkedList<sd> wkL = new LinkedList();
    public int wkM;
    public LinkedList<sh> wkN = new LinkedList();
    public int wkO;
    public LinkedList<sf> wkP = new LinkedList();
    public int wkQ;
    public int wkR;
    public int wkS;
    public LinkedList<sf> wkT = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vHG == null) {
                throw new b("Not all required fields were included: ReqBuf");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                if (this.vHG != null) {
                    aVar.fW(2, this.vHG.bke());
                    this.vHG.a(aVar);
                }
                aVar.fU(3, this.wkH);
                aVar.d(4, 8, this.wkI);
                if (this.wkJ != null) {
                    aVar.fW(5, this.wkJ.bke());
                    this.wkJ.a(aVar);
                }
                aVar.fU(6, this.wkK);
                aVar.d(7, 8, this.wkL);
                aVar.fU(8, this.wkM);
                aVar.d(9, 8, this.wkN);
                aVar.fU(10, this.wkO);
                aVar.d(11, 8, this.wkP);
                aVar.fU(12, this.wkQ);
                aVar.fU(13, this.wkR);
                aVar.fU(14, this.wkS);
                aVar.d(15, 8, this.wkT);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vHG != null) {
                r0 += e.a.a.a.fT(2, this.vHG.bke());
            }
            r0 = (r0 + e.a.a.a.fR(3, this.wkH)) + e.a.a.a.c(4, 8, this.wkI);
            if (this.wkJ != null) {
                r0 += e.a.a.a.fT(5, this.wkJ.bke());
            }
            return (((((((((r0 + e.a.a.a.fR(6, this.wkK)) + e.a.a.a.c(7, 8, this.wkL)) + e.a.a.a.fR(8, this.wkM)) + e.a.a.a.c(9, 8, this.wkN)) + e.a.a.a.fR(10, this.wkO)) + e.a.a.a.c(11, 8, this.wkP)) + e.a.a.a.fR(12, this.wkQ)) + e.a.a.a.fR(13, this.wkR)) + e.a.a.a.fR(14, this.wkS)) + e.a.a.a.c(15, 8, this.wkT);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wkI.clear();
            this.wkL.clear();
            this.wkN.clear();
            this.wkP.clear();
            this.wkT.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vHG != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ReqBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abz com_tencent_mm_protocal_c_abz = (abz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abz.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abz.vHG = feVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_abz.wkH = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new so();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abz.wkI.add(feVar);
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new sd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abz.wkJ = feVar;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_abz.wkK = aVar3.Avy.ry();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new sd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abz.wkL.add(feVar);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_abz.wkM = aVar3.Avy.ry();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new sh();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abz.wkN.add(feVar);
                    }
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_abz.wkO = aVar3.Avy.ry();
                    return 0;
                case 11:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new sf();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abz.wkP.add(feVar);
                    }
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_abz.wkQ = aVar3.Avy.ry();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_abz.wkR = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_abz.wkS = aVar3.Avy.ry();
                    return 0;
                case 15:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new sf();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abz.wkT.add(feVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
