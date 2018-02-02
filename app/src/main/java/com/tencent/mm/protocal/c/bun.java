package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bun extends bdf {
    public int vJO;
    public LinkedList<btg> vJP = new LinkedList();
    public int wFB;
    public int wUB;
    public LinkedList<bup> wUC = new LinkedList();
    public int wUD;
    public int wUE;
    public int wUF;
    public int wUG;
    public int wUH;
    public int wUI;
    public int wUJ;
    public int wUK;
    public int wUL;
    public int wUM;
    public int wUN;
    public int wUO;
    public int wUP;
    public int wUQ;
    public buo wUs;
    public int wUt;
    public int wUu;
    public int wUv;
    public int wUw;
    public int wVA;
    public int wVB;
    public int wVz;
    public int wbh;
    public long wbi;

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
            aVar.fU(2, this.wbh);
            aVar.fU(3, this.vJO);
            aVar.d(4, 8, this.vJP);
            aVar.S(5, this.wbi);
            aVar.fU(6, this.wFB);
            if (this.wUs != null) {
                aVar.fW(7, this.wUs.bke());
                this.wUs.a(aVar);
            }
            aVar.fU(8, this.wUB);
            aVar.d(9, 8, this.wUC);
            aVar.fU(10, this.wUD);
            aVar.fU(11, this.wUE);
            aVar.fU(12, this.wUF);
            aVar.fU(13, this.wUG);
            aVar.fU(14, this.wVz);
            aVar.fU(15, this.wUH);
            aVar.fU(16, this.wUI);
            aVar.fU(17, this.wUt);
            aVar.fU(18, this.wUJ);
            aVar.fU(19, this.wUK);
            aVar.fU(20, this.wUu);
            aVar.fU(21, this.wUL);
            aVar.fU(22, this.wUM);
            aVar.fU(23, this.wUN);
            aVar.fU(24, this.wVA);
            aVar.fU(25, this.wUO);
            aVar.fU(26, this.wVB);
            aVar.fU(27, this.wUv);
            aVar.fU(28, this.wUw);
            aVar.fU(29, this.wUP);
            aVar.fU(30, this.wUQ);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + e.a.a.a.fR(2, this.wbh)) + e.a.a.a.fR(3, this.vJO)) + e.a.a.a.c(4, 8, this.vJP)) + e.a.a.a.R(5, this.wbi)) + e.a.a.a.fR(6, this.wFB);
            if (this.wUs != null) {
                r0 += e.a.a.a.fT(7, this.wUs.bke());
            }
            return ((((((((((((((((((((((r0 + e.a.a.a.fR(8, this.wUB)) + e.a.a.a.c(9, 8, this.wUC)) + e.a.a.a.fR(10, this.wUD)) + e.a.a.a.fR(11, this.wUE)) + e.a.a.a.fR(12, this.wUF)) + e.a.a.a.fR(13, this.wUG)) + e.a.a.a.fR(14, this.wVz)) + e.a.a.a.fR(15, this.wUH)) + e.a.a.a.fR(16, this.wUI)) + e.a.a.a.fR(17, this.wUt)) + e.a.a.a.fR(18, this.wUJ)) + e.a.a.a.fR(19, this.wUK)) + e.a.a.a.fR(20, this.wUu)) + e.a.a.a.fR(21, this.wUL)) + e.a.a.a.fR(22, this.wUM)) + e.a.a.a.fR(23, this.wUN)) + e.a.a.a.fR(24, this.wVA)) + e.a.a.a.fR(25, this.wUO)) + e.a.a.a.fR(26, this.wVB)) + e.a.a.a.fR(27, this.wUv)) + e.a.a.a.fR(28, this.wUw)) + e.a.a.a.fR(29, this.wUP)) + e.a.a.a.fR(30, this.wUQ);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vJP.clear();
            this.wUC.clear();
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
            bun com_tencent_mm_protocal_c_bun = (bun) objArr[1];
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
                        com_tencent_mm_protocal_c_bun.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bun.wbh = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bun.vJO = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new btg();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bun.vJP.add(feVar);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bun.wbi = aVar3.Avy.rz();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bun.wFB = aVar3.Avy.ry();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new buo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bun.wUs = feVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bun.wUB = aVar3.Avy.ry();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bup();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bun.wUC.add(feVar);
                    }
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bun.wUD = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bun.wUE = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bun.wUF = aVar3.Avy.ry();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bun.wUG = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bun.wVz = aVar3.Avy.ry();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bun.wUH = aVar3.Avy.ry();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bun.wUI = aVar3.Avy.ry();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_bun.wUt = aVar3.Avy.ry();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_bun.wUJ = aVar3.Avy.ry();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_bun.wUK = aVar3.Avy.ry();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_bun.wUu = aVar3.Avy.ry();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_bun.wUL = aVar3.Avy.ry();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_bun.wUM = aVar3.Avy.ry();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_bun.wUN = aVar3.Avy.ry();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_bun.wVA = aVar3.Avy.ry();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_bun.wUO = aVar3.Avy.ry();
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_bun.wVB = aVar3.Avy.ry();
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_bun.wUv = aVar3.Avy.ry();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_bun.wUw = aVar3.Avy.ry();
                    return 0;
                case 29:
                    com_tencent_mm_protocal_c_bun.wUP = aVar3.Avy.ry();
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_bun.wUQ = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
