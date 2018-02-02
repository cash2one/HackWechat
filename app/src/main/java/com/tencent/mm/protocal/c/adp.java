package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class adp extends bcv {
    public int nhx;
    public int rYW;
    public String vZU;
    public int wmf;
    public LinkedList<arf> wmg = new LinkedList();
    public int wmh;
    public LinkedList<apf> wmi = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.nhx);
            if (this.vZU != null) {
                aVar.g(3, this.vZU);
            }
            aVar.fU(4, this.wmf);
            aVar.d(5, 8, this.wmg);
            aVar.fU(6, this.wmh);
            aVar.d(7, 8, this.wmi);
            aVar.fU(8, this.rYW);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.nhx);
            if (this.vZU != null) {
                r0 += e.a.a.b.b.a.h(3, this.vZU);
            }
            return ((((r0 + e.a.a.a.fR(4, this.wmf)) + e.a.a.a.c(5, 8, this.wmg)) + e.a.a.a.fR(6, this.wmh)) + e.a.a.a.c(7, 8, this.wmi)) + e.a.a.a.fR(8, this.rYW);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wmg.clear();
            this.wmi.clear();
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
            adp com_tencent_mm_protocal_c_adp = (adp) objArr[1];
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
                        com_tencent_mm_protocal_c_adp.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_adp.nhx = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_adp.vZU = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_adp.wmf = aVar3.Avy.ry();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new arf();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adp.wmg.add(fdVar);
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_adp.wmh = aVar3.Avy.ry();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new apf();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adp.wmi.add(fdVar);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_adp.rYW = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
