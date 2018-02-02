package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public class afq extends bdf {
    public String nGK;
    public LinkedList<bim> wnx = new LinkedList();
    public int wny;
    public int wnz;

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
            aVar.d(2, 8, this.wnx);
            if (this.nGK != null) {
                aVar.g(3, this.nGK);
            }
            aVar.fU(4, this.wny);
            aVar.fU(5, this.wnz);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.c(2, 8, this.wnx);
            if (this.nGK != null) {
                r0 += e.a.a.b.b.a.h(3, this.nGK);
            }
            return (r0 + e.a.a.a.fR(4, this.wny)) + e.a.a.a.fR(5, this.wnz);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wnx.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
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
            afq com_tencent_mm_protocal_c_afq = (afq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_afq.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bim();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_afq.wnx.add(feVar);
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_afq.nGK = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_afq.wny = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_afq.wnz = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
