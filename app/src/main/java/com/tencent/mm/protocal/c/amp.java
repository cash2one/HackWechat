package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class amp extends bdf {
    public b ksB;
    public String niZ;
    public String vFW;
    public alu wte;
    public bec wtl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new e.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            if (this.wte != null) {
                aVar.fW(2, this.wte.bke());
                this.wte.a(aVar);
            }
            if (this.ksB != null) {
                aVar.b(3, this.ksB);
            }
            if (this.wtl != null) {
                aVar.fW(4, this.wtl.bke());
                this.wtl.a(aVar);
            }
            if (this.niZ != null) {
                aVar.g(5, this.niZ);
            }
            if (this.vFW == null) {
                return 0;
            }
            aVar.g(6, this.vFW);
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
            if (this.ksB != null) {
                r0 += e.a.a.a.a(3, this.ksB);
            }
            if (this.wtl != null) {
                r0 += e.a.a.a.fT(4, this.wtl.bke());
            }
            if (this.niZ != null) {
                r0 += e.a.a.b.b.a.h(5, this.niZ);
            }
            if (this.vFW != null) {
                r0 += e.a.a.b.b.a.h(6, this.vFW);
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
            throw new e.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            amp com_tencent_mm_protocal_c_amp = (amp) objArr[1];
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
                        com_tencent_mm_protocal_c_amp.wJr = feVar;
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
                        com_tencent_mm_protocal_c_amp.wte = feVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_amp.ksB = aVar3.cJD();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bec();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_amp.wtl = feVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_amp.niZ = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_amp.vFW = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
