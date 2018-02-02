package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ym extends bdf {
    public ei mHz;
    public int vEa;
    public int vEe;
    public String vEf;
    public bio vEg;
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
            aVar.fU(2, this.vEe);
            aVar.fU(3, this.vEo);
            if (this.vEf != null) {
                aVar.g(4, this.vEf);
            }
            if (this.vEg != null) {
                aVar.fW(5, this.vEg.bke());
                this.vEg.a(aVar);
            }
            if (this.mHz != null) {
                aVar.fW(6, this.mHz.bke());
                this.mHz.a(aVar);
            }
            aVar.fU(7, this.vEa);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.vEe)) + e.a.a.a.fR(3, this.vEo);
            if (this.vEf != null) {
                r0 += e.a.a.b.b.a.h(4, this.vEf);
            }
            if (this.vEg != null) {
                r0 += e.a.a.a.fT(5, this.vEg.bke());
            }
            if (this.mHz != null) {
                r0 += e.a.a.a.fT(6, this.mHz.bke());
            }
            return r0 + e.a.a.a.fR(7, this.vEa);
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
            ym ymVar = (ym) objArr[1];
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
                        ymVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    ymVar.vEe = aVar3.Avy.ry();
                    return 0;
                case 3:
                    ymVar.vEo = aVar3.Avy.ry();
                    return 0;
                case 4:
                    ymVar.vEf = aVar3.Avy.readString();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bio();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        ymVar.vEg = feVar;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new ei();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        ymVar.mHz = feVar;
                    }
                    return 0;
                case 7:
                    ymVar.vEa = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
