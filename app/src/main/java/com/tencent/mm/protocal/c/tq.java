package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class tq extends bdf {
    public tt wbC;
    public tn wbD;
    public to wbE;
    public String wbF;
    public int wbG;
    public int wbH;

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
            if (this.wbC != null) {
                aVar.fW(2, this.wbC.bke());
                this.wbC.a(aVar);
            }
            if (this.wbD != null) {
                aVar.fW(3, this.wbD.bke());
                this.wbD.a(aVar);
            }
            if (this.wbE != null) {
                aVar.fW(4, this.wbE.bke());
                this.wbE.a(aVar);
            }
            if (this.wbF != null) {
                aVar.g(5, this.wbF);
            }
            aVar.fU(6, this.wbG);
            aVar.fU(7, this.wbH);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wbC != null) {
                r0 += e.a.a.a.fT(2, this.wbC.bke());
            }
            if (this.wbD != null) {
                r0 += e.a.a.a.fT(3, this.wbD.bke());
            }
            if (this.wbE != null) {
                r0 += e.a.a.a.fT(4, this.wbE.bke());
            }
            if (this.wbF != null) {
                r0 += e.a.a.b.b.a.h(5, this.wbF);
            }
            return (r0 + e.a.a.a.fR(6, this.wbG)) + e.a.a.a.fR(7, this.wbH);
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
            tq tqVar = (tq) objArr[1];
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
                        tqVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new tt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        tqVar.wbC = feVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new tn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        tqVar.wbD = feVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new to();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        tqVar.wbE = feVar;
                    }
                    return 0;
                case 5:
                    tqVar.wbF = aVar3.Avy.readString();
                    return 0;
                case 6:
                    tqVar.wbG = aVar3.Avy.ry();
                    return 0;
                case 7:
                    tqVar.wbH = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
