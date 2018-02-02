package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bvg extends bdf {
    public int vPq;
    public bdn vRA;
    public bud wWI;
    public int wbh;
    public long wbi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vRA == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else if (this.wWI == null) {
                throw new b("Not all required fields were included: CmdList");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                aVar.fU(3, this.wbh);
                if (this.vRA != null) {
                    aVar.fW(4, this.vRA.bke());
                    this.vRA.a(aVar);
                }
                if (this.wWI != null) {
                    aVar.fW(5, this.wWI.bke());
                    this.wWI.a(aVar);
                }
                aVar.fU(7, this.vPq);
                aVar.S(8, this.wbi);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(3, this.wbh);
            if (this.vRA != null) {
                r0 += e.a.a.a.fT(4, this.vRA.bke());
            }
            if (this.wWI != null) {
                r0 += e.a.a.a.fT(5, this.wWI.bke());
            }
            return (r0 + e.a.a.a.fR(7, this.vPq)) + e.a.a.a.R(8, this.wbi);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vRA == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else if (this.wWI != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: CmdList");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bvg com_tencent_mm_protocal_c_bvg = (bvg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bvg.wJr = feVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bvg.wbh = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bvg.vRA = feVar;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bud();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bvg.wWI = feVar;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bvg.vPq = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bvg.wbi = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
