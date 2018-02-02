package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bqn extends bcv {
    public String ksU;
    public int vJL;
    public String vMb;
    public int wRV;
    public int wRW;
    public LinkedList<apf> wRX = new LinkedList();
    public LinkedList<arf> wvB = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.ksU != null) {
                aVar.g(2, this.ksU);
            }
            aVar.fU(3, this.vJL);
            if (this.vMb != null) {
                aVar.g(4, this.vMb);
            }
            aVar.fU(5, this.wRV);
            aVar.d(6, 8, this.wvB);
            aVar.fU(7, this.wRW);
            aVar.d(8, 8, this.wRX);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(2, this.ksU);
            }
            r0 += e.a.a.a.fR(3, this.vJL);
            if (this.vMb != null) {
                r0 += e.a.a.b.b.a.h(4, this.vMb);
            }
            return (((r0 + e.a.a.a.fR(5, this.wRV)) + e.a.a.a.c(6, 8, this.wvB)) + e.a.a.a.fR(7, this.wRW)) + e.a.a.a.c(8, 8, this.wRX);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wvB.clear();
            this.wRX.clear();
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
            bqn com_tencent_mm_protocal_c_bqn = (bqn) objArr[1];
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
                        com_tencent_mm_protocal_c_bqn.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bqn.ksU = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bqn.vJL = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bqn.vMb = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bqn.wRV = aVar3.Avy.ry();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new arf();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqn.wvB.add(fdVar);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bqn.wRW = aVar3.Avy.ry();
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new apf();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqn.wRX.add(fdVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
