package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bcx extends bdf {
    public int liH;
    public String liI;
    public String nBM;
    public String ods;
    public String pHL;
    public String pHM;
    public String vPj;
    public cg wJa;

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
            aVar.fU(2, this.liH);
            if (this.liI != null) {
                aVar.g(3, this.liI);
            }
            if (this.ods != null) {
                aVar.g(4, this.ods);
            }
            if (this.vPj != null) {
                aVar.g(5, this.vPj);
            }
            if (this.pHL != null) {
                aVar.g(6, this.pHL);
            }
            if (this.pHM != null) {
                aVar.g(7, this.pHM);
            }
            if (this.nBM != null) {
                aVar.g(8, this.nBM);
            }
            if (this.wJa == null) {
                return 0;
            }
            aVar.fW(9, this.wJa.bke());
            this.wJa.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.liH);
            if (this.liI != null) {
                r0 += e.a.a.b.b.a.h(3, this.liI);
            }
            if (this.ods != null) {
                r0 += e.a.a.b.b.a.h(4, this.ods);
            }
            if (this.vPj != null) {
                r0 += e.a.a.b.b.a.h(5, this.vPj);
            }
            if (this.pHL != null) {
                r0 += e.a.a.b.b.a.h(6, this.pHL);
            }
            if (this.pHM != null) {
                r0 += e.a.a.b.b.a.h(7, this.pHM);
            }
            if (this.nBM != null) {
                r0 += e.a.a.b.b.a.h(8, this.nBM);
            }
            if (this.wJa != null) {
                r0 += e.a.a.a.fT(9, this.wJa.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            bcx com_tencent_mm_protocal_c_bcx = (bcx) objArr[1];
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
                        com_tencent_mm_protocal_c_bcx.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bcx.liH = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bcx.liI = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bcx.ods = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bcx.vPj = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bcx.pHL = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bcx.pHM = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bcx.nBM = aVar3.Avy.readString();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new cg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bcx.wJa = feVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
