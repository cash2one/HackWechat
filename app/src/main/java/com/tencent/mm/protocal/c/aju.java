package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aju extends bdf {
    public bdn vIZ;
    public bdn wqW;
    public bdn wqX;
    public int wqY;
    public int wqZ;
    public int wra;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vIZ == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else if (this.wqW == null) {
                throw new b("Not all required fields were included: SessionBuffer");
            } else if (this.wqX == null) {
                throw new b("Not all required fields were included: KeyBuffer");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                if (this.vIZ != null) {
                    aVar.fW(2, this.vIZ.bke());
                    this.vIZ.a(aVar);
                }
                if (this.wqW != null) {
                    aVar.fW(3, this.wqW.bke());
                    this.wqW.a(aVar);
                }
                if (this.wqX != null) {
                    aVar.fW(4, this.wqX.bke());
                    this.wqX.a(aVar);
                }
                aVar.fU(5, this.wqY);
                aVar.fU(6, this.wqZ);
                aVar.fU(7, this.wra);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vIZ != null) {
                r0 += e.a.a.a.fT(2, this.vIZ.bke());
            }
            if (this.wqW != null) {
                r0 += e.a.a.a.fT(3, this.wqW.bke());
            }
            if (this.wqX != null) {
                r0 += e.a.a.a.fT(4, this.wqX.bke());
            }
            return ((r0 + e.a.a.a.fR(5, this.wqY)) + e.a.a.a.fR(6, this.wqZ)) + e.a.a.a.fR(7, this.wra);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vIZ == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else if (this.wqW == null) {
                throw new b("Not all required fields were included: SessionBuffer");
            } else if (this.wqX != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: KeyBuffer");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aju com_tencent_mm_protocal_c_aju = (aju) objArr[1];
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
                        com_tencent_mm_protocal_c_aju.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aju.vIZ = feVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aju.wqW = feVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aju.wqX = feVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aju.wqY = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aju.wqZ = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aju.wra = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
