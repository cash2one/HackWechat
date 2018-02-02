package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ab extends bdf {
    public int vDW;
    public String vEc;
    public int vEd;
    public int vEe;
    public String vEf;
    public bio vEg;
    public bbs vEh;
    public bio vEi;
    public azp vEj;
    public wi vEk;
    public ei vEl;
    public String vEm;
    public String vEn;
    public int vEo;

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
            if (this.vEc != null) {
                aVar.g(2, this.vEc);
            }
            aVar.fU(3, this.vEd);
            aVar.fU(4, this.vEe);
            if (this.vEf != null) {
                aVar.g(5, this.vEf);
            }
            if (this.vEg != null) {
                aVar.fW(6, this.vEg.bke());
                this.vEg.a(aVar);
            }
            aVar.fU(7, this.vDW);
            if (this.vEh != null) {
                aVar.fW(8, this.vEh.bke());
                this.vEh.a(aVar);
            }
            if (this.vEi != null) {
                aVar.fW(9, this.vEi.bke());
                this.vEi.a(aVar);
            }
            if (this.vEj != null) {
                aVar.fW(10, this.vEj.bke());
                this.vEj.a(aVar);
            }
            if (this.vEk != null) {
                aVar.fW(11, this.vEk.bke());
                this.vEk.a(aVar);
            }
            if (this.vEl != null) {
                aVar.fW(12, this.vEl.bke());
                this.vEl.a(aVar);
            }
            if (this.vEm != null) {
                aVar.g(13, this.vEm);
            }
            if (this.vEn != null) {
                aVar.g(14, this.vEn);
            }
            aVar.fU(15, this.vEo);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vEc != null) {
                r0 += e.a.a.b.b.a.h(2, this.vEc);
            }
            r0 = (r0 + e.a.a.a.fR(3, this.vEd)) + e.a.a.a.fR(4, this.vEe);
            if (this.vEf != null) {
                r0 += e.a.a.b.b.a.h(5, this.vEf);
            }
            if (this.vEg != null) {
                r0 += e.a.a.a.fT(6, this.vEg.bke());
            }
            r0 += e.a.a.a.fR(7, this.vDW);
            if (this.vEh != null) {
                r0 += e.a.a.a.fT(8, this.vEh.bke());
            }
            if (this.vEi != null) {
                r0 += e.a.a.a.fT(9, this.vEi.bke());
            }
            if (this.vEj != null) {
                r0 += e.a.a.a.fT(10, this.vEj.bke());
            }
            if (this.vEk != null) {
                r0 += e.a.a.a.fT(11, this.vEk.bke());
            }
            if (this.vEl != null) {
                r0 += e.a.a.a.fT(12, this.vEl.bke());
            }
            if (this.vEm != null) {
                r0 += e.a.a.b.b.a.h(13, this.vEm);
            }
            if (this.vEn != null) {
                r0 += e.a.a.b.b.a.h(14, this.vEn);
            }
            return r0 + e.a.a.a.fR(15, this.vEo);
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
            ab abVar = (ab) objArr[1];
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
                        abVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    abVar.vEc = aVar3.Avy.readString();
                    return 0;
                case 3:
                    abVar.vEd = aVar3.Avy.ry();
                    return 0;
                case 4:
                    abVar.vEe = aVar3.Avy.ry();
                    return 0;
                case 5:
                    abVar.vEf = aVar3.Avy.readString();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bio();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        abVar.vEg = feVar;
                    }
                    return 0;
                case 7:
                    abVar.vDW = aVar3.Avy.ry();
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bbs();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        abVar.vEh = feVar;
                    }
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bio();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        abVar.vEi = feVar;
                    }
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new azp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        abVar.vEj = feVar;
                    }
                    return 0;
                case 11:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new wi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        abVar.vEk = feVar;
                    }
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new ei();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        abVar.vEl = feVar;
                    }
                    return 0;
                case 13:
                    abVar.vEm = aVar3.Avy.readString();
                    return 0;
                case 14:
                    abVar.vEn = aVar3.Avy.readString();
                    return 0;
                case 15:
                    abVar.vEo = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
