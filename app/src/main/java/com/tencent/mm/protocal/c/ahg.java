package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ahg extends bdf {
    public String bhd;
    public String lOU;
    public String lOW;
    public boolean lPf;
    public int lVM;
    public LinkedList<wb> vGV = new LinkedList();
    public LinkedList<bmb> vHx = new LinkedList();
    public String woA;
    public ccb woB;
    public LinkedList<ccd> woC = new LinkedList();
    public LinkedList<ccc> woD = new LinkedList();
    public LinkedList<String> woE = new LinkedList();
    public String woF;
    public String woG;
    public LinkedList<jm> woH = new LinkedList();
    public boolean woI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.woA == null) {
                throw new b("Not all required fields were included: coverurl");
            } else if (this.lOW == null) {
                throw new b("Not all required fields were included: motto");
            } else if (this.woB == null) {
                throw new b("Not all required fields were included: rankdesc");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                if (this.woA != null) {
                    aVar.g(2, this.woA);
                }
                if (this.lOW != null) {
                    aVar.g(3, this.lOW);
                }
                if (this.woB != null) {
                    aVar.fW(4, this.woB.bke());
                    this.woB.a(aVar);
                }
                aVar.d(5, 8, this.woC);
                aVar.d(6, 8, this.woD);
                if (this.bhd != null) {
                    aVar.g(7, this.bhd);
                }
                aVar.d(8, 1, this.woE);
                if (this.woF != null) {
                    aVar.g(9, this.woF);
                }
                if (this.woG != null) {
                    aVar.g(10, this.woG);
                }
                aVar.d(14, 8, this.vHx);
                aVar.d(15, 8, this.vGV);
                aVar.al(16, this.lPf);
                aVar.d(17, 8, this.woH);
                aVar.al(18, this.woI);
                aVar.fU(19, this.lVM);
                if (this.lOU == null) {
                    return 0;
                }
                aVar.g(20, this.lOU);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.woA != null) {
                r0 += e.a.a.b.b.a.h(2, this.woA);
            }
            if (this.lOW != null) {
                r0 += e.a.a.b.b.a.h(3, this.lOW);
            }
            if (this.woB != null) {
                r0 += e.a.a.a.fT(4, this.woB.bke());
            }
            r0 = (r0 + e.a.a.a.c(5, 8, this.woC)) + e.a.a.a.c(6, 8, this.woD);
            if (this.bhd != null) {
                r0 += e.a.a.b.b.a.h(7, this.bhd);
            }
            r0 += e.a.a.a.c(8, 1, this.woE);
            if (this.woF != null) {
                r0 += e.a.a.b.b.a.h(9, this.woF);
            }
            if (this.woG != null) {
                r0 += e.a.a.b.b.a.h(10, this.woG);
            }
            r0 = (((((r0 + e.a.a.a.c(14, 8, this.vHx)) + e.a.a.a.c(15, 8, this.vGV)) + (e.a.a.b.b.a.dX(16) + 1)) + e.a.a.a.c(17, 8, this.woH)) + (e.a.a.b.b.a.dX(18) + 1)) + e.a.a.a.fR(19, this.lVM);
            if (this.lOU != null) {
                r0 += e.a.a.b.b.a.h(20, this.lOU);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.woC.clear();
            this.woD.clear();
            this.woE.clear();
            this.vHx.clear();
            this.vGV.clear();
            this.woH.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.woA == null) {
                throw new b("Not all required fields were included: coverurl");
            } else if (this.lOW == null) {
                throw new b("Not all required fields were included: motto");
            } else if (this.woB != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: rankdesc");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ahg com_tencent_mm_protocal_c_ahg = (ahg) objArr[1];
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
                        com_tencent_mm_protocal_c_ahg.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ahg.woA = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ahg.lOW = aVar3.Avy.readString();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new ccb();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahg.woB = feVar;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new ccd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahg.woC.add(feVar);
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new ccc();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahg.woD.add(feVar);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ahg.bhd = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ahg.woE.add(aVar3.Avy.readString());
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ahg.woF = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ahg.woG = aVar3.Avy.readString();
                    return 0;
                case 14:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bmb();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahg.vHx.add(feVar);
                    }
                    return 0;
                case 15:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new wb();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahg.vGV.add(feVar);
                    }
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_ahg.lPf = aVar3.cJC();
                    return 0;
                case 17:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new jm();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahg.woH.add(feVar);
                    }
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_ahg.woI = aVar3.cJC();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_ahg.lVM = aVar3.Avy.ry();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_ahg.lOU = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
