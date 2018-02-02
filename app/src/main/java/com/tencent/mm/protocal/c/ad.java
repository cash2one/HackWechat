package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ad extends bdf {
    public int vEe;
    public String vEf;
    public bio vEg;
    public bbs vEh;
    public int vEo;
    public ou vEs;
    public boolean vEt;
    public int vEu;

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
            aVar.fU(2, this.vEe);
            if (this.vEf != null) {
                aVar.g(3, this.vEf);
            }
            if (this.vEg != null) {
                aVar.fW(4, this.vEg.bke());
                this.vEg.a(aVar);
            }
            if (this.vEh != null) {
                aVar.fW(5, this.vEh.bke());
                this.vEh.a(aVar);
            }
            aVar.fU(6, this.vEo);
            if (this.vEs != null) {
                aVar.fW(7, this.vEs.bke());
                this.vEs.a(aVar);
            }
            aVar.al(8, this.vEt);
            aVar.fU(9, this.vEu);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.vEe);
            if (this.vEf != null) {
                r0 += e.a.a.b.b.a.h(3, this.vEf);
            }
            if (this.vEg != null) {
                r0 += e.a.a.a.fT(4, this.vEg.bke());
            }
            if (this.vEh != null) {
                r0 += e.a.a.a.fT(5, this.vEh.bke());
            }
            r0 += e.a.a.a.fR(6, this.vEo);
            if (this.vEs != null) {
                r0 += e.a.a.a.fT(7, this.vEs.bke());
            }
            return (r0 + (e.a.a.b.b.a.dX(8) + 1)) + e.a.a.a.fR(9, this.vEu);
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
            ad adVar = (ad) objArr[1];
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
                        adVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    adVar.vEe = aVar3.Avy.ry();
                    return 0;
                case 3:
                    adVar.vEf = aVar3.Avy.readString();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bio();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        adVar.vEg = feVar;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bbs();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        adVar.vEh = feVar;
                    }
                    return 0;
                case 6:
                    adVar.vEo = aVar3.Avy.ry();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new ou();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        adVar.vEs = feVar;
                    }
                    return 0;
                case 8:
                    adVar.vEt = aVar3.cJC();
                    return 0;
                case 9:
                    adVar.vEu = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
