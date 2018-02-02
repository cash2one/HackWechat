package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class axv extends bdf {
    public String vQO;
    public int vQP;
    public String vQQ;
    public LinkedList<ti> wET = new LinkedList();
    public LinkedList<as> wEU = new LinkedList();
    public int wEV;
    public int wlC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            aVar.fU(2, this.wlC);
            aVar.d(3, 8, this.wET);
            if (this.vQO != null) {
                aVar.g(4, this.vQO);
            }
            aVar.fU(5, this.vQP);
            if (this.vQQ != null) {
                aVar.g(6, this.vQQ);
            }
            aVar.d(7, 8, this.wEU);
            aVar.fU(8, this.wEV);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.wlC)) + e.a.a.a.c(3, 8, this.wET);
            if (this.vQO != null) {
                r0 += e.a.a.b.b.a.h(4, this.vQO);
            }
            r0 += e.a.a.a.fR(5, this.vQP);
            if (this.vQQ != null) {
                r0 += e.a.a.b.b.a.h(6, this.vQQ);
            }
            return (r0 + e.a.a.a.c(7, 8, this.wEU)) + e.a.a.a.fR(8, this.wEV);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wET.clear();
            this.wEU.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            axv com_tencent_mm_protocal_c_axv = (axv) objArr[1];
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
                        com_tencent_mm_protocal_c_axv.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axv.wlC = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new ti();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axv.wET.add(feVar);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axv.vQO = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_axv.vQP = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_axv.vQQ = aVar3.Avy.readString();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new as();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axv.wEU.add(feVar);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_axv.wEV = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
