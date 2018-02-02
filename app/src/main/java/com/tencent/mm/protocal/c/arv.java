package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class arv extends bcv {
    public int rYW;
    public int vGM;
    public LinkedList<arx> vLo = new LinkedList();
    public int wzB;
    public LinkedList<aru> wzC = new LinkedList();
    public int wzD;
    public String wzE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.vGM);
            aVar.fU(3, this.wzB);
            aVar.d(4, 8, this.wzC);
            aVar.fU(5, this.wzD);
            aVar.d(6, 8, this.vLo);
            if (this.wzE != null) {
                aVar.g(7, this.wzE);
            }
            aVar.fU(8, this.rYW);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + e.a.a.a.fR(2, this.vGM)) + e.a.a.a.fR(3, this.wzB)) + e.a.a.a.c(4, 8, this.wzC)) + e.a.a.a.fR(5, this.wzD)) + e.a.a.a.c(6, 8, this.vLo);
            if (this.wzE != null) {
                r0 += e.a.a.b.b.a.h(7, this.wzE);
            }
            return r0 + e.a.a.a.fR(8, this.rYW);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wzC.clear();
            this.vLo.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            arv com_tencent_mm_protocal_c_arv = (arv) objArr[1];
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
                        com_tencent_mm_protocal_c_arv.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_arv.vGM = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_arv.wzB = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new aru();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_arv.wzC.add(fdVar);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_arv.wzD = aVar3.Avy.ry();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new arx();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_arv.vLo.add(fdVar);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_arv.wzE = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_arv.rYW = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
