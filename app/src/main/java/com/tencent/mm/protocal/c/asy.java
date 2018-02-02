package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class asy extends a {
    public aki vMq;
    public il vMr;
    public asx vMs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vMq != null) {
                aVar.fW(1, this.vMq.bke());
                this.vMq.a(aVar);
            }
            if (this.vMs != null) {
                aVar.fW(2, this.vMs.bke());
                this.vMs.a(aVar);
            }
            if (this.vMr == null) {
                return 0;
            }
            aVar.fW(3, this.vMr.bke());
            this.vMr.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.vMq != null) {
                r0 = e.a.a.a.fT(1, this.vMq.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vMs != null) {
                r0 += e.a.a.a.fT(2, this.vMs.bke());
            }
            if (this.vMr != null) {
                r0 += e.a.a.a.fT(3, this.vMr.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            asy com_tencent_mm_protocal_c_asy = (asy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_aki;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aki = new aki();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aki.a(aVar4, com_tencent_mm_protocal_c_aki, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asy.vMq = com_tencent_mm_protocal_c_aki;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aki = new asx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aki.a(aVar4, com_tencent_mm_protocal_c_aki, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asy.vMs = com_tencent_mm_protocal_c_aki;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aki = new il();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aki.a(aVar4, com_tencent_mm_protocal_c_aki, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asy.vMr = com_tencent_mm_protocal_c_aki;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
