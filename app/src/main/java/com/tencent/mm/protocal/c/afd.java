package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class afd extends bdf {
    public int wmY;
    public bdn wmZ;
    public String wna;
    public String wnb;
    public String wnc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wmZ == null) {
                throw new b("Not all required fields were included: QRCode");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                if (this.wmZ != null) {
                    aVar.fW(2, this.wmZ.bke());
                    this.wmZ.a(aVar);
                }
                aVar.fU(5, this.wmY);
                if (this.wna != null) {
                    aVar.g(6, this.wna);
                }
                if (this.wnb != null) {
                    aVar.g(7, this.wnb);
                }
                if (this.wnc == null) {
                    return 0;
                }
                aVar.g(8, this.wnc);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wmZ != null) {
                r0 += e.a.a.a.fT(2, this.wmZ.bke());
            }
            r0 += e.a.a.a.fR(5, this.wmY);
            if (this.wna != null) {
                r0 += e.a.a.b.b.a.h(6, this.wna);
            }
            if (this.wnb != null) {
                r0 += e.a.a.b.b.a.h(7, this.wnb);
            }
            if (this.wnc != null) {
                r0 += e.a.a.b.b.a.h(8, this.wnc);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wmZ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: QRCode");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            afd com_tencent_mm_protocal_c_afd = (afd) objArr[1];
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
                        com_tencent_mm_protocal_c_afd.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_afd.wmZ = feVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_afd.wmY = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_afd.wna = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_afd.wnb = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_afd.wnc = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
