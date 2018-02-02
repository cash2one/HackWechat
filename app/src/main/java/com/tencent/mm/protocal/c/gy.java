package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class gy extends bdf {
    public String frP;
    public int vFx;
    public String vIy;
    public bin vJk;
    public String vJl;
    public int vJp;
    public int vMl;
    public String vMm;
    public String vMn;
    public int vMo;
    public String vMp;
    public aki vMq;
    public il vMr;
    public asx vMs;
    public String vMt;
    public int vMu;
    public bdr vMv;
    public String vMw;
    public String vMx;
    public String vMy;
    public String vMz;

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
            if (this.frP != null) {
                aVar.g(2, this.frP);
            }
            if (this.vMn != null) {
                aVar.g(3, this.vMn);
            }
            aVar.fU(4, this.vMo);
            if (this.vMp != null) {
                aVar.g(5, this.vMp);
            }
            if (this.vIy != null) {
                aVar.g(6, this.vIy);
            }
            if (this.vMq != null) {
                aVar.fW(7, this.vMq.bke());
                this.vMq.a(aVar);
            }
            if (this.vMr != null) {
                aVar.fW(8, this.vMr.bke());
                this.vMr.a(aVar);
            }
            if (this.vMs != null) {
                aVar.fW(9, this.vMs.bke());
                this.vMs.a(aVar);
            }
            if (this.vJl != null) {
                aVar.g(10, this.vJl);
            }
            aVar.fU(11, this.vFx);
            if (this.vMt != null) {
                aVar.g(12, this.vMt);
            }
            aVar.fU(13, this.vMu);
            if (this.vMv != null) {
                aVar.fW(14, this.vMv.bke());
                this.vMv.a(aVar);
            }
            if (this.vMw != null) {
                aVar.g(15, this.vMw);
            }
            if (this.vMx != null) {
                aVar.g(16, this.vMx);
            }
            if (this.vJk != null) {
                aVar.fW(17, this.vJk.bke());
                this.vJk.a(aVar);
            }
            aVar.fU(18, this.vJp);
            if (this.vMy != null) {
                aVar.g(19, this.vMy);
            }
            if (this.vMz != null) {
                aVar.g(20, this.vMz);
            }
            aVar.fU(21, this.vMl);
            if (this.vMm == null) {
                return 0;
            }
            aVar.g(22, this.vMm);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.frP != null) {
                r0 += e.a.a.b.b.a.h(2, this.frP);
            }
            if (this.vMn != null) {
                r0 += e.a.a.b.b.a.h(3, this.vMn);
            }
            r0 += e.a.a.a.fR(4, this.vMo);
            if (this.vMp != null) {
                r0 += e.a.a.b.b.a.h(5, this.vMp);
            }
            if (this.vIy != null) {
                r0 += e.a.a.b.b.a.h(6, this.vIy);
            }
            if (this.vMq != null) {
                r0 += e.a.a.a.fT(7, this.vMq.bke());
            }
            if (this.vMr != null) {
                r0 += e.a.a.a.fT(8, this.vMr.bke());
            }
            if (this.vMs != null) {
                r0 += e.a.a.a.fT(9, this.vMs.bke());
            }
            if (this.vJl != null) {
                r0 += e.a.a.b.b.a.h(10, this.vJl);
            }
            r0 += e.a.a.a.fR(11, this.vFx);
            if (this.vMt != null) {
                r0 += e.a.a.b.b.a.h(12, this.vMt);
            }
            r0 += e.a.a.a.fR(13, this.vMu);
            if (this.vMv != null) {
                r0 += e.a.a.a.fT(14, this.vMv.bke());
            }
            if (this.vMw != null) {
                r0 += e.a.a.b.b.a.h(15, this.vMw);
            }
            if (this.vMx != null) {
                r0 += e.a.a.b.b.a.h(16, this.vMx);
            }
            if (this.vJk != null) {
                r0 += e.a.a.a.fT(17, this.vJk.bke());
            }
            r0 += e.a.a.a.fR(18, this.vJp);
            if (this.vMy != null) {
                r0 += e.a.a.b.b.a.h(19, this.vMy);
            }
            if (this.vMz != null) {
                r0 += e.a.a.b.b.a.h(20, this.vMz);
            }
            r0 += e.a.a.a.fR(21, this.vMl);
            if (this.vMm != null) {
                r0 += e.a.a.b.b.a.h(22, this.vMm);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            gy gyVar = (gy) objArr[1];
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
                        gyVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    gyVar.frP = aVar3.Avy.readString();
                    return 0;
                case 3:
                    gyVar.vMn = aVar3.Avy.readString();
                    return 0;
                case 4:
                    gyVar.vMo = aVar3.Avy.ry();
                    return 0;
                case 5:
                    gyVar.vMp = aVar3.Avy.readString();
                    return 0;
                case 6:
                    gyVar.vIy = aVar3.Avy.readString();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new aki();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        gyVar.vMq = feVar;
                    }
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new il();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        gyVar.vMr = feVar;
                    }
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new asx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        gyVar.vMs = feVar;
                    }
                    return 0;
                case 10:
                    gyVar.vJl = aVar3.Avy.readString();
                    return 0;
                case 11:
                    gyVar.vFx = aVar3.Avy.ry();
                    return 0;
                case 12:
                    gyVar.vMt = aVar3.Avy.readString();
                    return 0;
                case 13:
                    gyVar.vMu = aVar3.Avy.ry();
                    return 0;
                case 14:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        gyVar.vMv = feVar;
                    }
                    return 0;
                case 15:
                    gyVar.vMw = aVar3.Avy.readString();
                    return 0;
                case 16:
                    gyVar.vMx = aVar3.Avy.readString();
                    return 0;
                case 17:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bin();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        gyVar.vJk = feVar;
                    }
                    return 0;
                case 18:
                    gyVar.vJp = aVar3.Avy.ry();
                    return 0;
                case 19:
                    gyVar.vMy = aVar3.Avy.readString();
                    return 0;
                case 20:
                    gyVar.vMz = aVar3.Avy.readString();
                    return 0;
                case 21:
                    gyVar.vMl = aVar3.Avy.ry();
                    return 0;
                case 22:
                    gyVar.vMm = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
