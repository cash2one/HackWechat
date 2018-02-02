package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class adj extends bcv {
    public int rYW;
    public int vJL;
    public aog vYA;
    public String wgS;
    public bdn wlO;
    public int wlP;
    public int wlQ;
    public LinkedList<axb> wlR = new LinkedList();
    public int wlS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vYA == null) {
                throw new b("Not all required fields were included: Loc");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.vJL);
            aVar.fU(3, this.rYW);
            if (this.wlO != null) {
                aVar.fW(4, this.wlO.bke());
                this.wlO.a(aVar);
            }
            if (this.vYA != null) {
                aVar.fW(5, this.vYA.bke());
                this.vYA.a(aVar);
            }
            if (this.wgS != null) {
                aVar.g(6, this.wgS);
            }
            aVar.fU(7, this.wlP);
            aVar.fU(8, this.wlQ);
            aVar.d(11, 8, this.wlR);
            aVar.fU(12, this.wlS);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.vJL)) + e.a.a.a.fR(3, this.rYW);
            if (this.wlO != null) {
                r0 += e.a.a.a.fT(4, this.wlO.bke());
            }
            if (this.vYA != null) {
                r0 += e.a.a.a.fT(5, this.vYA.bke());
            }
            if (this.wgS != null) {
                r0 += e.a.a.b.b.a.h(6, this.wgS);
            }
            return (((r0 + e.a.a.a.fR(7, this.wlP)) + e.a.a.a.fR(8, this.wlQ)) + e.a.a.a.c(11, 8, this.wlR)) + e.a.a.a.fR(12, this.wlS);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wlR.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vYA != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Loc");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            adj com_tencent_mm_protocal_c_adj = (adj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adj.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_adj.vJL = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_adj.rYW = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adj.wlO = fdVar;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new aog();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adj.vYA = fdVar;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_adj.wgS = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_adj.wlP = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_adj.wlQ = aVar3.Avy.ry();
                    return 0;
                case 11:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new axb();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adj.wlR.add(fdVar);
                    }
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_adj.wlS = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
