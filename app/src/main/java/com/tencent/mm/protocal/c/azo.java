package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class azo extends bdf {
    public int bME;
    public int fKV;
    public int kLO;
    public String kLP;
    public int vXn;
    public String wFU;
    public String wGA;
    public String wGB;
    public String wGC;
    public String wGD;
    public int wGE;
    public LinkedList<rf> wGF = new LinkedList();
    public int wGG;
    public LinkedList<rf> wGH = new LinkedList();
    public rf wGI;
    public LinkedList<rf> wGJ = new LinkedList();
    public rf wGK;
    public ard wGL;
    public String wGM;
    public int wGN;
    public String wGO;
    public int wGP;
    public boolean wGQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            aVar.fU(2, this.kLO);
            if (this.kLP != null) {
                aVar.g(3, this.kLP);
            }
            aVar.fU(4, this.bME);
            if (this.wGB != null) {
                aVar.g(5, this.wGB);
            }
            if (this.wGC != null) {
                aVar.g(6, this.wGC);
            }
            if (this.wGD != null) {
                aVar.g(7, this.wGD);
            }
            aVar.fU(8, this.wGE);
            aVar.d(9, 8, this.wGF);
            aVar.fU(10, this.fKV);
            aVar.fU(11, this.wGG);
            aVar.d(12, 8, this.wGH);
            if (this.wFU != null) {
                aVar.g(13, this.wFU);
            }
            if (this.wGI != null) {
                aVar.fW(14, this.wGI.bke());
                this.wGI.a(aVar);
            }
            aVar.d(15, 8, this.wGJ);
            if (this.wGK != null) {
                aVar.fW(16, this.wGK.bke());
                this.wGK.a(aVar);
            }
            if (this.wGL != null) {
                aVar.fW(17, this.wGL.bke());
                this.wGL.a(aVar);
            }
            if (this.wGM != null) {
                aVar.g(18, this.wGM);
            }
            aVar.fU(19, this.wGN);
            if (this.wGO != null) {
                aVar.g(20, this.wGO);
            }
            if (this.wGA != null) {
                aVar.g(21, this.wGA);
            }
            aVar.fU(22, this.wGP);
            aVar.al(23, this.wGQ);
            aVar.fU(24, this.vXn);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.kLO);
            if (this.kLP != null) {
                r0 += e.a.a.b.b.a.h(3, this.kLP);
            }
            r0 += e.a.a.a.fR(4, this.bME);
            if (this.wGB != null) {
                r0 += e.a.a.b.b.a.h(5, this.wGB);
            }
            if (this.wGC != null) {
                r0 += e.a.a.b.b.a.h(6, this.wGC);
            }
            if (this.wGD != null) {
                r0 += e.a.a.b.b.a.h(7, this.wGD);
            }
            r0 = ((((r0 + e.a.a.a.fR(8, this.wGE)) + e.a.a.a.c(9, 8, this.wGF)) + e.a.a.a.fR(10, this.fKV)) + e.a.a.a.fR(11, this.wGG)) + e.a.a.a.c(12, 8, this.wGH);
            if (this.wFU != null) {
                r0 += e.a.a.b.b.a.h(13, this.wFU);
            }
            if (this.wGI != null) {
                r0 += e.a.a.a.fT(14, this.wGI.bke());
            }
            r0 += e.a.a.a.c(15, 8, this.wGJ);
            if (this.wGK != null) {
                r0 += e.a.a.a.fT(16, this.wGK.bke());
            }
            if (this.wGL != null) {
                r0 += e.a.a.a.fT(17, this.wGL.bke());
            }
            if (this.wGM != null) {
                r0 += e.a.a.b.b.a.h(18, this.wGM);
            }
            r0 += e.a.a.a.fR(19, this.wGN);
            if (this.wGO != null) {
                r0 += e.a.a.b.b.a.h(20, this.wGO);
            }
            if (this.wGA != null) {
                r0 += e.a.a.b.b.a.h(21, this.wGA);
            }
            return ((r0 + e.a.a.a.fR(22, this.wGP)) + (e.a.a.b.b.a.dX(23) + 1)) + e.a.a.a.fR(24, this.vXn);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wGF.clear();
            this.wGH.clear();
            this.wGJ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            azo com_tencent_mm_protocal_c_azo = (azo) objArr[1];
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
                        com_tencent_mm_protocal_c_azo.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_azo.kLO = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_azo.kLP = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_azo.bME = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_azo.wGB = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_azo.wGC = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_azo.wGD = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_azo.wGE = aVar3.Avy.ry();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new rf();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azo.wGF.add(feVar);
                    }
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_azo.fKV = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_azo.wGG = aVar3.Avy.ry();
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new rf();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azo.wGH.add(feVar);
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_azo.wFU = aVar3.Avy.readString();
                    return 0;
                case 14:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new rf();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azo.wGI = feVar;
                    }
                    return 0;
                case 15:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new rf();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azo.wGJ.add(feVar);
                    }
                    return 0;
                case 16:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new rf();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azo.wGK = feVar;
                    }
                    return 0;
                case 17:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new ard();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azo.wGL = feVar;
                    }
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_azo.wGM = aVar3.Avy.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_azo.wGN = aVar3.Avy.ry();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_azo.wGO = aVar3.Avy.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_azo.wGA = aVar3.Avy.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_azo.wGP = aVar3.Avy.ry();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_azo.wGQ = aVar3.cJC();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_azo.vXn = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
