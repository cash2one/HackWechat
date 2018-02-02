package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bsf extends bdf {
    public bdn vHb;
    public bdn vJc;
    public String vJh;
    public bdn vJi;
    public bdo vMF;
    public bdn vMG;
    public String vZK;
    public bdo woX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.woX == null) {
                throw new b("Not all required fields were included: ImgSid");
            } else if (this.vHb == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                if (this.woX != null) {
                    aVar.fW(2, this.woX.bke());
                    this.woX.a(aVar);
                }
                if (this.vHb != null) {
                    aVar.fW(3, this.vHb.bke());
                    this.vHb.a(aVar);
                }
                if (this.vZK != null) {
                    aVar.g(4, this.vZK);
                }
                if (this.vMF != null) {
                    aVar.fW(5, this.vMF.bke());
                    this.vMF.a(aVar);
                }
                if (this.vJi != null) {
                    aVar.fW(6, this.vJi.bke());
                    this.vJi.a(aVar);
                }
                if (this.vMG != null) {
                    aVar.fW(7, this.vMG.bke());
                    this.vMG.a(aVar);
                }
                if (this.vJh != null) {
                    aVar.g(8, this.vJh);
                }
                if (this.vJc == null) {
                    return 0;
                }
                aVar.fW(9, this.vJc.bke());
                this.vJc.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.woX != null) {
                r0 += e.a.a.a.fT(2, this.woX.bke());
            }
            if (this.vHb != null) {
                r0 += e.a.a.a.fT(3, this.vHb.bke());
            }
            if (this.vZK != null) {
                r0 += e.a.a.b.b.a.h(4, this.vZK);
            }
            if (this.vMF != null) {
                r0 += e.a.a.a.fT(5, this.vMF.bke());
            }
            if (this.vJi != null) {
                r0 += e.a.a.a.fT(6, this.vJi.bke());
            }
            if (this.vMG != null) {
                r0 += e.a.a.a.fT(7, this.vMG.bke());
            }
            if (this.vJh != null) {
                r0 += e.a.a.b.b.a.h(8, this.vJh);
            }
            if (this.vJc != null) {
                r0 += e.a.a.a.fT(9, this.vJc.bke());
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
            } else if (this.woX == null) {
                throw new b("Not all required fields were included: ImgSid");
            } else if (this.vHb != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsf com_tencent_mm_protocal_c_bsf = (bsf) objArr[1];
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
                        com_tencent_mm_protocal_c_bsf.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bsf.woX = feVar;
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
                        com_tencent_mm_protocal_c_bsf.vHb = feVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bsf.vZK = aVar3.Avy.readString();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bsf.vMF = feVar;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bsf.vJi = feVar;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bsf.vMG = feVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bsf.vJh = aVar3.Avy.readString();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bsf.vJc = feVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
