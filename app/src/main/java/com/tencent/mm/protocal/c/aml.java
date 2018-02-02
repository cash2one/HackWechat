package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aml extends bdf {
    public String hvw;
    public String vDZ;
    public String vEm;
    public alu wte;
    public String wtg;
    public String wth;
    public String wti;
    public int wtj;

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
            if (this.wte != null) {
                aVar.fW(2, this.wte.bke());
                this.wte.a(aVar);
            }
            if (this.wth != null) {
                aVar.g(3, this.wth);
            }
            if (this.vEm != null) {
                aVar.g(4, this.vEm);
            }
            if (this.vDZ != null) {
                aVar.g(5, this.vDZ);
            }
            if (this.wti != null) {
                aVar.g(6, this.wti);
            }
            aVar.fU(7, this.wtj);
            if (this.wtg != null) {
                aVar.g(8, this.wtg);
            }
            if (this.hvw == null) {
                return 0;
            }
            aVar.g(9, this.hvw);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wte != null) {
                r0 += e.a.a.a.fT(2, this.wte.bke());
            }
            if (this.wth != null) {
                r0 += e.a.a.b.b.a.h(3, this.wth);
            }
            if (this.vEm != null) {
                r0 += e.a.a.b.b.a.h(4, this.vEm);
            }
            if (this.vDZ != null) {
                r0 += e.a.a.b.b.a.h(5, this.vDZ);
            }
            if (this.wti != null) {
                r0 += e.a.a.b.b.a.h(6, this.wti);
            }
            r0 += e.a.a.a.fR(7, this.wtj);
            if (this.wtg != null) {
                r0 += e.a.a.b.b.a.h(8, this.wtg);
            }
            if (this.hvw != null) {
                r0 += e.a.a.b.b.a.h(9, this.hvw);
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
            aml com_tencent_mm_protocal_c_aml = (aml) objArr[1];
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
                        com_tencent_mm_protocal_c_aml.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new alu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aml.wte = feVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aml.wth = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aml.vEm = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aml.vDZ = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aml.wti = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aml.wtj = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aml.wtg = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aml.hvw = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
