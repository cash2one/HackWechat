package com.tencent.mm.plugin.game.c;

import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.fe;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bf extends bdf {
    public boolean nhI;
    public ap nhJ;
    public String nhK;
    public f nhL;
    public af nhM;
    public g nhN;
    public dw nhO;

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
            aVar.al(2, this.nhI);
            if (this.nhJ != null) {
                aVar.fW(3, this.nhJ.bke());
                this.nhJ.a(aVar);
            }
            if (this.nhK != null) {
                aVar.g(4, this.nhK);
            }
            if (this.nhL != null) {
                aVar.fW(5, this.nhL.bke());
                this.nhL.a(aVar);
            }
            if (this.nhM != null) {
                aVar.fW(6, this.nhM.bke());
                this.nhM.a(aVar);
            }
            if (this.nhN != null) {
                aVar.fW(7, this.nhN.bke());
                this.nhN.a(aVar);
            }
            if (this.nhO == null) {
                return 0;
            }
            aVar.fW(8, this.nhO.bke());
            this.nhO.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.b.b.a.dX(2) + 1;
            if (this.nhJ != null) {
                r0 += e.a.a.a.fT(3, this.nhJ.bke());
            }
            if (this.nhK != null) {
                r0 += e.a.a.b.b.a.h(4, this.nhK);
            }
            if (this.nhL != null) {
                r0 += e.a.a.a.fT(5, this.nhL.bke());
            }
            if (this.nhM != null) {
                r0 += e.a.a.a.fT(6, this.nhM.bke());
            }
            if (this.nhN != null) {
                r0 += e.a.a.a.fT(7, this.nhN.bke());
            }
            if (this.nhO != null) {
                r0 += e.a.a.a.fT(8, this.nhO.bke());
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
            bf bfVar = (bf) objArr[1];
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
                        bfVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    bfVar.nhI = aVar3.cJC();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new ap();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bfVar.nhJ = feVar;
                    }
                    return 0;
                case 4:
                    bfVar.nhK = aVar3.Avy.readString();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new f();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bfVar.nhL = feVar;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new af();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bfVar.nhM = feVar;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new g();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bfVar.nhN = feVar;
                    }
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new dw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bfVar.nhO = feVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
