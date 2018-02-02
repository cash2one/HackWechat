package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aua extends bdf {
    public int bME;
    public int kLO;
    public String kLP;
    public ape wBS;
    public int wBT;
    public int wBU;
    public int wBV;
    public LinkedList<rf> wBW = new LinkedList();

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
            aVar.fU(5, this.wBT);
            aVar.fU(6, this.wBU);
            aVar.fU(7, this.wBV);
            aVar.d(8, 8, this.wBW);
            if (this.wBS == null) {
                return 0;
            }
            aVar.fW(9, this.wBS.bke());
            this.wBS.a(aVar);
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
            r0 = ((((r0 + e.a.a.a.fR(4, this.bME)) + e.a.a.a.fR(5, this.wBT)) + e.a.a.a.fR(6, this.wBU)) + e.a.a.a.fR(7, this.wBV)) + e.a.a.a.c(8, 8, this.wBW);
            if (this.wBS != null) {
                r0 += e.a.a.a.fT(9, this.wBS.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wBW.clear();
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
            aua com_tencent_mm_protocal_c_aua = (aua) objArr[1];
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
                        com_tencent_mm_protocal_c_aua.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aua.kLO = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aua.kLP = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aua.bME = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aua.wBT = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aua.wBU = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aua.wBV = aVar3.Avy.ry();
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new rf();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aua.wBW.add(feVar);
                    }
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new ape();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aua.wBS = feVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
