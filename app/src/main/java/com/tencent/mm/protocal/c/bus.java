package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bus extends bdf {
    public int wFB;
    public LinkedList<btg> wVc = new LinkedList();
    public int wWk;
    public LinkedList<btg> wWl = new LinkedList();
    public int wWm;
    public LinkedList<btg> wWn = new LinkedList();
    public int wWo;
    public int wWp;
    public int wWq;
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
            aVar.fU(3, this.wWk);
            aVar.d(4, 8, this.wWl);
            aVar.fU(5, this.wWm);
            aVar.d(6, 8, this.wWn);
            aVar.S(7, this.wbi);
            aVar.fU(8, this.wFB);
            aVar.fU(9, this.wWo);
            aVar.d(10, 8, this.wVc);
            aVar.fU(11, this.wWp);
            aVar.fU(12, this.wWq);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            return ((((((((((r0 + e.a.a.a.fR(2, this.wbh)) + e.a.a.a.fR(3, this.wWk)) + e.a.a.a.c(4, 8, this.wWl)) + e.a.a.a.fR(5, this.wWm)) + e.a.a.a.c(6, 8, this.wWn)) + e.a.a.a.R(7, this.wbi)) + e.a.a.a.fR(8, this.wFB)) + e.a.a.a.fR(9, this.wWo)) + e.a.a.a.c(10, 8, this.wVc)) + e.a.a.a.fR(11, this.wWp)) + e.a.a.a.fR(12, this.wWq);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wWl.clear();
            this.wWn.clear();
            this.wVc.clear();
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
            bus com_tencent_mm_protocal_c_bus = (bus) objArr[1];
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
                        com_tencent_mm_protocal_c_bus.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bus.wbh = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bus.wWk = aVar3.Avy.ry();
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
                        com_tencent_mm_protocal_c_bus.wWl.add(feVar);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bus.wWm = aVar3.Avy.ry();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new btg();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bus.wWn.add(feVar);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bus.wbi = aVar3.Avy.rz();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bus.wFB = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bus.wWo = aVar3.Avy.ry();
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new btg();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bus.wVc.add(feVar);
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bus.wWp = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bus.wWq = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
