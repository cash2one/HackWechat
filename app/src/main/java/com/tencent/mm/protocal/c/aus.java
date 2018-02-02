package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aus extends bdf {
    public int kLO;
    public String kLP;
    public String vLK;
    public axk vLL;
    public aux vLM;
    public String wCC;
    public String wCH;

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
            if (this.vLK != null) {
                aVar.g(5, this.vLK);
            }
            if (this.wCH != null) {
                aVar.g(6, this.wCH);
            }
            if (this.vLL != null) {
                aVar.fW(7, this.vLL.bke());
                this.vLL.a(aVar);
            }
            if (this.vLM == null) {
                return 0;
            }
            aVar.fW(8, this.vLM.bke());
            this.vLM.a(aVar);
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
            if (this.vLK != null) {
                r0 += e.a.a.b.b.a.h(5, this.vLK);
            }
            if (this.wCH != null) {
                r0 += e.a.a.b.b.a.h(6, this.wCH);
            }
            if (this.vLL != null) {
                r0 += e.a.a.a.fT(7, this.vLL.bke());
            }
            if (this.vLM != null) {
                r0 += e.a.a.a.fT(8, this.vLM.bke());
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
            aus com_tencent_mm_protocal_c_aus = (aus) objArr[1];
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
                        com_tencent_mm_protocal_c_aus.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aus.kLO = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aus.kLP = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aus.wCC = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aus.vLK = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aus.wCH = aVar3.Avy.readString();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new axk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aus.vLL = feVar;
                    }
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new aux();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aus.vLM = feVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
