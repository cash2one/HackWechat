package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class awc extends bdf {
    public int fts;
    public String ftt;
    public int okQ;
    public String sPT;
    public bxc wDE;
    public bwz wDF;
    public bwx wDG;
    public bxa wDH;
    public boolean wDI;
    public LinkedList<String> wDJ = new LinkedList();

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
            aVar.fU(2, this.fts);
            if (this.ftt != null) {
                aVar.g(3, this.ftt);
            }
            if (this.wDE != null) {
                aVar.fW(4, this.wDE.bke());
                this.wDE.a(aVar);
            }
            if (this.wDF != null) {
                aVar.fW(5, this.wDF.bke());
                this.wDF.a(aVar);
            }
            if (this.wDG != null) {
                aVar.fW(6, this.wDG.bke());
                this.wDG.a(aVar);
            }
            if (this.wDH != null) {
                aVar.fW(7, this.wDH.bke());
                this.wDH.a(aVar);
            }
            aVar.fU(8, this.okQ);
            aVar.al(9, this.wDI);
            if (this.sPT != null) {
                aVar.g(10, this.sPT);
            }
            aVar.d(11, 1, this.wDJ);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.fts);
            if (this.ftt != null) {
                r0 += e.a.a.b.b.a.h(3, this.ftt);
            }
            if (this.wDE != null) {
                r0 += e.a.a.a.fT(4, this.wDE.bke());
            }
            if (this.wDF != null) {
                r0 += e.a.a.a.fT(5, this.wDF.bke());
            }
            if (this.wDG != null) {
                r0 += e.a.a.a.fT(6, this.wDG.bke());
            }
            if (this.wDH != null) {
                r0 += e.a.a.a.fT(7, this.wDH.bke());
            }
            r0 = (r0 + e.a.a.a.fR(8, this.okQ)) + (e.a.a.b.b.a.dX(9) + 1);
            if (this.sPT != null) {
                r0 += e.a.a.b.b.a.h(10, this.sPT);
            }
            return r0 + e.a.a.a.c(11, 1, this.wDJ);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wDJ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
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
            awc com_tencent_mm_protocal_c_awc = (awc) objArr[1];
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
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awc.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_awc.fts = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_awc.ftt = aVar3.Avy.readString();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bxc();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awc.wDE = feVar;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bwz();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awc.wDF = feVar;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bwx();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awc.wDG = feVar;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bxa();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awc.wDH = feVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_awc.okQ = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_awc.wDI = aVar3.cJC();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_awc.sPT = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_awc.wDJ.add(aVar3.Avy.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
