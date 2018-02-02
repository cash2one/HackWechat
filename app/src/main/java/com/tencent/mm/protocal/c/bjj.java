package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bjj extends bdf {
    public String vIO;
    public LinkedList<bjv> vLo = new LinkedList();
    public String wMJ;
    public int wMN;
    public int wMO;
    public bkm wMP;
    public int wzD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wMP == null) {
                throw new b("Not all required fields were included: ServerConfig");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                if (this.wMJ != null) {
                    aVar.g(2, this.wMJ);
                }
                aVar.fU(3, this.wzD);
                aVar.d(4, 8, this.vLo);
                aVar.fU(5, this.wMN);
                if (this.vIO != null) {
                    aVar.g(6, this.vIO);
                }
                aVar.fU(7, this.wMO);
                if (this.wMP == null) {
                    return 0;
                }
                aVar.fW(8, this.wMP.bke());
                this.wMP.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wMJ != null) {
                r0 += e.a.a.b.b.a.h(2, this.wMJ);
            }
            r0 = ((r0 + e.a.a.a.fR(3, this.wzD)) + e.a.a.a.c(4, 8, this.vLo)) + e.a.a.a.fR(5, this.wMN);
            if (this.vIO != null) {
                r0 += e.a.a.b.b.a.h(6, this.vIO);
            }
            r0 += e.a.a.a.fR(7, this.wMO);
            if (this.wMP != null) {
                r0 += e.a.a.a.fT(8, this.wMP.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vLo.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wMP != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ServerConfig");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bjj com_tencent_mm_protocal_c_bjj = (bjj) objArr[1];
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
                        com_tencent_mm_protocal_c_bjj.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bjj.wMJ = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bjj.wzD = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bjv();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjj.vLo.add(feVar);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bjj.wMN = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bjj.vIO = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bjj.wMO = aVar3.Avy.ry();
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bkm();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjj.wMP = feVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
