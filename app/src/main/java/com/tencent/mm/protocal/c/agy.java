package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class agy extends bdf {
    public int vIB;
    public int vIC;
    public int vID;
    public bdn vXz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vXz == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                aVar.fU(2, this.vIB);
                aVar.fU(3, this.vIC);
                aVar.fU(4, this.vID);
                if (this.vXz == null) {
                    return 0;
                }
                aVar.fW(5, this.vXz.bke());
                this.vXz.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + e.a.a.a.fR(2, this.vIB)) + e.a.a.a.fR(3, this.vIC)) + e.a.a.a.fR(4, this.vID);
            if (this.vXz != null) {
                r0 += e.a.a.a.fT(5, this.vXz.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vXz != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            agy com_tencent_mm_protocal_c_agy = (agy) objArr[1];
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
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_agy.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_agy.vIB = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_agy.vIC = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_agy.vID = aVar3.Avy.ry();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_agy.vXz = feVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
