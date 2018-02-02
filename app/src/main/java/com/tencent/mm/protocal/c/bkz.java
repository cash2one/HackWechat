package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bkz extends bdf {
    public int ktN;
    public String vGQ;
    public int vIB;
    public int vIC;
    public long vPO;
    public bjh wOr;
    public int wyy;
    public LinkedList<bjh> wyz = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wOr == null) {
                throw new b("Not all required fields were included: BufferUrl");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                aVar.fU(2, this.vIC);
                aVar.fU(3, this.vIB);
                if (this.vGQ != null) {
                    aVar.g(4, this.vGQ);
                }
                if (this.wOr != null) {
                    aVar.fW(5, this.wOr.bke());
                    this.wOr.a(aVar);
                }
                aVar.fU(6, this.wyy);
                aVar.d(7, 8, this.wyz);
                aVar.S(8, this.vPO);
                aVar.fU(9, this.ktN);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.vIC)) + e.a.a.a.fR(3, this.vIB);
            if (this.vGQ != null) {
                r0 += e.a.a.b.b.a.h(4, this.vGQ);
            }
            if (this.wOr != null) {
                r0 += e.a.a.a.fT(5, this.wOr.bke());
            }
            return (((r0 + e.a.a.a.fR(6, this.wyy)) + e.a.a.a.c(7, 8, this.wyz)) + e.a.a.a.R(8, this.vPO)) + e.a.a.a.fR(9, this.ktN);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wyz.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wOr != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BufferUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bkz com_tencent_mm_protocal_c_bkz = (bkz) objArr[1];
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
                        com_tencent_mm_protocal_c_bkz.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bkz.vIC = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bkz.vIB = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bkz.vGQ = aVar3.Avy.readString();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bjh();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkz.wOr = feVar;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bkz.wyy = aVar3.Avy.ry();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bjh();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkz.wyz.add(feVar);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bkz.vPO = aVar3.Avy.rz();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bkz.ktN = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
