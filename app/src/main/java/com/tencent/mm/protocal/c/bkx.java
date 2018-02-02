package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bkx extends bdf {
    public LinkedList<bjv> vLo = new LinkedList();
    public String wMJ;
    public int wMN;
    public int wMO;
    public bkm wMP;
    public bdn wMo;
    public int wOk;
    public int wOl;
    public LinkedList<cc> wOm = new LinkedList();
    public int wOn;
    public LinkedList<bbj> wOo = new LinkedList();
    public int wzD;

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
            if (this.wMJ != null) {
                aVar.g(2, this.wMJ);
            }
            aVar.fU(3, this.wzD);
            aVar.d(4, 8, this.vLo);
            aVar.fU(5, this.wOk);
            aVar.fU(6, this.wMN);
            aVar.fU(7, this.wMO);
            if (this.wMP != null) {
                aVar.fW(8, this.wMP.bke());
                this.wMP.a(aVar);
            }
            aVar.fU(9, this.wOl);
            aVar.d(10, 8, this.wOm);
            if (this.wMo != null) {
                aVar.fW(11, this.wMo.bke());
                this.wMo.a(aVar);
            }
            aVar.fU(12, this.wOn);
            aVar.d(13, 8, this.wOo);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wMJ != null) {
                r0 += e.a.a.b.b.a.h(2, this.wMJ);
            }
            r0 = ((((r0 + e.a.a.a.fR(3, this.wzD)) + e.a.a.a.c(4, 8, this.vLo)) + e.a.a.a.fR(5, this.wOk)) + e.a.a.a.fR(6, this.wMN)) + e.a.a.a.fR(7, this.wMO);
            if (this.wMP != null) {
                r0 += e.a.a.a.fT(8, this.wMP.bke());
            }
            r0 = (r0 + e.a.a.a.fR(9, this.wOl)) + e.a.a.a.c(10, 8, this.wOm);
            if (this.wMo != null) {
                r0 += e.a.a.a.fT(11, this.wMo.bke());
            }
            return (r0 + e.a.a.a.fR(12, this.wOn)) + e.a.a.a.c(13, 8, this.wOo);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vLo.clear();
            this.wOm.clear();
            this.wOo.clear();
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
            bkx com_tencent_mm_protocal_c_bkx = (bkx) objArr[1];
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
                        com_tencent_mm_protocal_c_bkx.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bkx.wMJ = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bkx.wzD = aVar3.Avy.ry();
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
                        com_tencent_mm_protocal_c_bkx.vLo.add(feVar);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bkx.wOk = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bkx.wMN = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bkx.wMO = aVar3.Avy.ry();
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
                        com_tencent_mm_protocal_c_bkx.wMP = feVar;
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bkx.wOl = aVar3.Avy.ry();
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new cc();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkx.wOm.add(feVar);
                    }
                    return 0;
                case 11:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkx.wMo = feVar;
                    }
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bkx.wOn = aVar3.Avy.ry();
                    return 0;
                case 13:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bbj();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkx.wOo.add(feVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
