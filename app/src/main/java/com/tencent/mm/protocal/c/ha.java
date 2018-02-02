package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ha extends bdf {
    public int ktm;
    public int vFA;
    public int vFx;
    public bdn vHb;
    public bdn vJc;
    public bdn vJi;
    public String vMC;
    public bdo vMF;
    public bdn vMG;
    public int vMI;
    public String vMJ;
    public String vMK;
    public bdr vMv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vHb == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                if (this.vMC != null) {
                    aVar.g(2, this.vMC);
                }
                if (this.vHb != null) {
                    aVar.fW(3, this.vHb.bke());
                    this.vHb.a(aVar);
                }
                aVar.fU(4, this.vFA);
                aVar.fU(5, this.vMI);
                if (this.vMJ != null) {
                    aVar.g(6, this.vMJ);
                }
                aVar.fU(7, this.ktm);
                if (this.vMK != null) {
                    aVar.g(8, this.vMK);
                }
                if (this.vMF != null) {
                    aVar.fW(9, this.vMF.bke());
                    this.vMF.a(aVar);
                }
                if (this.vJi != null) {
                    aVar.fW(10, this.vJi.bke());
                    this.vJi.a(aVar);
                }
                if (this.vMG != null) {
                    aVar.fW(11, this.vMG.bke());
                    this.vMG.a(aVar);
                }
                if (this.vMv != null) {
                    aVar.fW(12, this.vMv.bke());
                    this.vMv.a(aVar);
                }
                aVar.fU(13, this.vFx);
                if (this.vJc == null) {
                    return 0;
                }
                aVar.fW(14, this.vJc.bke());
                this.vJc.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vMC != null) {
                r0 += e.a.a.b.b.a.h(2, this.vMC);
            }
            if (this.vHb != null) {
                r0 += e.a.a.a.fT(3, this.vHb.bke());
            }
            r0 = (r0 + e.a.a.a.fR(4, this.vFA)) + e.a.a.a.fR(5, this.vMI);
            if (this.vMJ != null) {
                r0 += e.a.a.b.b.a.h(6, this.vMJ);
            }
            r0 += e.a.a.a.fR(7, this.ktm);
            if (this.vMK != null) {
                r0 += e.a.a.b.b.a.h(8, this.vMK);
            }
            if (this.vMF != null) {
                r0 += e.a.a.a.fT(9, this.vMF.bke());
            }
            if (this.vJi != null) {
                r0 += e.a.a.a.fT(10, this.vJi.bke());
            }
            if (this.vMG != null) {
                r0 += e.a.a.a.fT(11, this.vMG.bke());
            }
            if (this.vMv != null) {
                r0 += e.a.a.a.fT(12, this.vMv.bke());
            }
            r0 += e.a.a.a.fR(13, this.vFx);
            if (this.vJc != null) {
                r0 += e.a.a.a.fT(14, this.vJc.bke());
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
            } else if (this.vHb != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ha haVar = (ha) objArr[1];
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
                        haVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    haVar.vMC = aVar3.Avy.readString();
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
                        haVar.vHb = feVar;
                    }
                    return 0;
                case 4:
                    haVar.vFA = aVar3.Avy.ry();
                    return 0;
                case 5:
                    haVar.vMI = aVar3.Avy.ry();
                    return 0;
                case 6:
                    haVar.vMJ = aVar3.Avy.readString();
                    return 0;
                case 7:
                    haVar.ktm = aVar3.Avy.ry();
                    return 0;
                case 8:
                    haVar.vMK = aVar3.Avy.readString();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        haVar.vMF = feVar;
                    }
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        haVar.vJi = feVar;
                    }
                    return 0;
                case 11:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        haVar.vMG = feVar;
                    }
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        haVar.vMv = feVar;
                    }
                    return 0;
                case 13:
                    haVar.vFx = aVar3.Avy.ry();
                    return 0;
                case 14:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        haVar.vJc = feVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
