package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ayk extends bdf {
    public int nDD;
    public String nDE;
    public int nDI;
    public int nDO;
    public int nDP;
    public int nDQ;
    public b nDR;
    public int nDT;
    public int nDW;
    public LinkedList<ayc> vJP = new LinkedList();
    public int wFB;
    public int wFC;
    public LinkedList<ayc> wFD = new LinkedList();
    public String wFE;
    public b wFF;
    public int wFG;
    public long wFs;
    public int wbh;
    public long wbi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new e.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            aVar.fU(2, this.wbh);
            aVar.S(3, this.wbi);
            aVar.fU(4, this.wFB);
            aVar.d(5, 8, this.vJP);
            aVar.fU(6, this.wFC);
            aVar.fU(7, this.nDO);
            aVar.fU(8, this.nDP);
            aVar.S(9, this.wFs);
            aVar.fU(10, this.nDQ);
            if (this.nDR != null) {
                aVar.b(11, this.nDR);
            }
            aVar.fU(12, this.nDI);
            aVar.fU(13, this.nDD);
            if (this.nDE != null) {
                aVar.g(14, this.nDE);
            }
            aVar.fU(15, this.nDT);
            aVar.d(16, 8, this.wFD);
            aVar.fU(17, this.nDW);
            if (this.wFE != null) {
                aVar.g(18, this.wFE);
            }
            if (this.wFF != null) {
                aVar.b(19, this.wFF);
            }
            aVar.fU(20, this.wFG);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((((((r0 + e.a.a.a.fR(2, this.wbh)) + e.a.a.a.R(3, this.wbi)) + e.a.a.a.fR(4, this.wFB)) + e.a.a.a.c(5, 8, this.vJP)) + e.a.a.a.fR(6, this.wFC)) + e.a.a.a.fR(7, this.nDO)) + e.a.a.a.fR(8, this.nDP)) + e.a.a.a.R(9, this.wFs)) + e.a.a.a.fR(10, this.nDQ);
            if (this.nDR != null) {
                r0 += e.a.a.a.a(11, this.nDR);
            }
            r0 = (r0 + e.a.a.a.fR(12, this.nDI)) + e.a.a.a.fR(13, this.nDD);
            if (this.nDE != null) {
                r0 += e.a.a.b.b.a.h(14, this.nDE);
            }
            r0 = ((r0 + e.a.a.a.fR(15, this.nDT)) + e.a.a.a.c(16, 8, this.wFD)) + e.a.a.a.fR(17, this.nDW);
            if (this.wFE != null) {
                r0 += e.a.a.b.b.a.h(18, this.wFE);
            }
            if (this.wFF != null) {
                r0 += e.a.a.a.a(19, this.wFF);
            }
            return r0 + e.a.a.a.fR(20, this.wFG);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vJP.clear();
            this.wFD.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ayk com_tencent_mm_protocal_c_ayk = (ayk) objArr[1];
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
                        com_tencent_mm_protocal_c_ayk.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ayk.wbh = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ayk.wbi = aVar3.Avy.rz();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ayk.wFB = aVar3.Avy.ry();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new ayc();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ayk.vJP.add(feVar);
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ayk.wFC = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ayk.nDO = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ayk.nDP = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ayk.wFs = aVar3.Avy.rz();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ayk.nDQ = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ayk.nDR = aVar3.cJD();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_ayk.nDI = aVar3.Avy.ry();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_ayk.nDD = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_ayk.nDE = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_ayk.nDT = aVar3.Avy.ry();
                    return 0;
                case 16:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new ayc();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ayk.wFD.add(feVar);
                    }
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_ayk.nDW = aVar3.Avy.ry();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_ayk.wFE = aVar3.Avy.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_ayk.wFF = aVar3.cJD();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_ayk.wFG = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
