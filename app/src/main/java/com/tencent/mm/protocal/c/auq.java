package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class auq extends bdf {
    public int kLO;
    public String kLP;
    public String vLJ;
    public axk vLL;
    public String wCC;
    public boolean wCD;

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
            aVar.fU(2, this.kLO);
            if (this.kLP != null) {
                aVar.g(3, this.kLP);
            }
            if (this.wCC != null) {
                aVar.g(4, this.wCC);
            }
            if (this.vLJ != null) {
                aVar.g(7, this.vLJ);
            }
            if (this.vLL != null) {
                aVar.fW(8, this.vLL.bke());
                this.vLL.a(aVar);
            }
            aVar.al(9, this.wCD);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.kLO);
            if (this.kLP != null) {
                r0 += e.a.a.b.b.a.h(3, this.kLP);
            }
            if (this.wCC != null) {
                r0 += e.a.a.b.b.a.h(4, this.wCC);
            }
            if (this.vLJ != null) {
                r0 += e.a.a.b.b.a.h(7, this.vLJ);
            }
            if (this.vLL != null) {
                r0 += e.a.a.a.fT(8, this.vLL.bke());
            }
            return r0 + (e.a.a.b.b.a.dX(9) + 1);
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
            auq com_tencent_mm_protocal_c_auq = (auq) objArr[1];
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
                        com_tencent_mm_protocal_c_auq.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_auq.kLO = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_auq.kLP = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_auq.wCC = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_auq.vLJ = aVar3.Avy.readString();
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new axk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_auq.vLL = feVar;
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_auq.wCD = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
