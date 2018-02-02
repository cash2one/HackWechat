package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bsm extends bcv {
    public int vJL;
    public int wTL;
    public LinkedList<bsk> wTM = new LinkedList();
    public int wTN;
    public LinkedList<Integer> wTO = new LinkedList();
    public int wTP;
    public LinkedList<bsl> wTQ = new LinkedList();
    public String wnL;
    public bdn wvs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.vJL);
            aVar.fU(3, this.wTL);
            aVar.d(4, 8, this.wTM);
            if (this.wnL != null) {
                aVar.g(5, this.wnL);
            }
            aVar.fU(6, this.wTN);
            aVar.c(7, this.wTO);
            aVar.fU(8, this.wTP);
            aVar.d(9, 8, this.wTQ);
            if (this.wvs == null) {
                return 0;
            }
            aVar.fW(10, this.wvs.bke());
            this.wvs.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + e.a.a.a.fR(2, this.vJL)) + e.a.a.a.fR(3, this.wTL)) + e.a.a.a.c(4, 8, this.wTM);
            if (this.wnL != null) {
                r0 += e.a.a.b.b.a.h(5, this.wnL);
            }
            r0 = (((r0 + e.a.a.a.fR(6, this.wTN)) + e.a.a.a.b(7, this.wTO)) + e.a.a.a.fR(8, this.wTP)) + e.a.a.a.c(9, 8, this.wTQ);
            if (this.wvs != null) {
                r0 += e.a.a.a.fT(10, this.wvs.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wTM.clear();
            this.wTO.clear();
            this.wTQ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsm com_tencent_mm_protocal_c_bsm = (bsm) objArr[1];
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
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bsm.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bsm.vJL = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bsm.wTL = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bsk();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bsm.wTM.add(fdVar);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bsm.wnL = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bsm.wTN = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bsm.wTO = new e.a.a.a.a(aVar3.cJD().oz, unknownTagHandler).cJA();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bsm.wTP = aVar3.Avy.ry();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bsl();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bsm.wTQ.add(fdVar);
                    }
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bsm.wvs = fdVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
