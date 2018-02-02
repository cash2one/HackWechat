package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class biw extends bcv {
    public String vGQ;
    public int vHW;
    public bdo wMi;
    public bjf wMj;
    public bdo wMk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wMj == null) {
                throw new b("Not all required fields were included: Action");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.wMj != null) {
                aVar.fW(2, this.wMj.bke());
                this.wMj.a(aVar);
            }
            if (this.vGQ != null) {
                aVar.g(3, this.vGQ);
            }
            if (this.wMi != null) {
                aVar.fW(4, this.wMi.bke());
                this.wMi.a(aVar);
            }
            aVar.fU(5, this.vHW);
            if (this.wMk == null) {
                return 0;
            }
            aVar.fW(6, this.wMk.bke());
            this.wMk.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wMj != null) {
                r0 += e.a.a.a.fT(2, this.wMj.bke());
            }
            if (this.vGQ != null) {
                r0 += e.a.a.b.b.a.h(3, this.vGQ);
            }
            if (this.wMi != null) {
                r0 += e.a.a.a.fT(4, this.wMi.bke());
            }
            r0 += e.a.a.a.fR(5, this.vHW);
            if (this.wMk != null) {
                r0 += e.a.a.a.fT(6, this.wMk.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wMj != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Action");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            biw com_tencent_mm_protocal_c_biw = (biw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_biw.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bjf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_biw.wMj = fdVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_biw.vGQ = aVar3.Avy.readString();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_biw.wMi = fdVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_biw.vHW = aVar3.Avy.ry();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_biw.wMk = fdVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
