package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class blc extends bdf {
    public LinkedList<bjv> vLo = new LinkedList();
    public String wMJ;
    public int wMN;
    public bkm wMP;
    public int wOk;
    public int wOt;
    public long wOu;
    public bla wvl;
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
            aVar.fU(5, this.wOt);
            if (this.wvl != null) {
                aVar.fW(6, this.wvl.bke());
                this.wvl.a(aVar);
            }
            aVar.fU(7, this.wOk);
            aVar.fU(8, this.wMN);
            if (this.wMP != null) {
                aVar.fW(9, this.wMP.bke());
                this.wMP.a(aVar);
            }
            aVar.S(10, this.wOu);
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
            r0 = ((r0 + e.a.a.a.fR(3, this.wzD)) + e.a.a.a.c(4, 8, this.vLo)) + e.a.a.a.fR(5, this.wOt);
            if (this.wvl != null) {
                r0 += e.a.a.a.fT(6, this.wvl.bke());
            }
            r0 = (r0 + e.a.a.a.fR(7, this.wOk)) + e.a.a.a.fR(8, this.wMN);
            if (this.wMP != null) {
                r0 += e.a.a.a.fT(9, this.wMP.bke());
            }
            return r0 + e.a.a.a.R(10, this.wOu);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vLo.clear();
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
            blc com_tencent_mm_protocal_c_blc = (blc) objArr[1];
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
                        com_tencent_mm_protocal_c_blc.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_blc.wMJ = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_blc.wzD = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bjv();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blc.vLo.add(feVar);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_blc.wOt = aVar3.Avy.ry();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bla();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blc.wvl = feVar;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_blc.wOk = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_blc.wMN = aVar3.Avy.ry();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bkm();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blc.wMP = feVar;
                    }
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_blc.wOu = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
