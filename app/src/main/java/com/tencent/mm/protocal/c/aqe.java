package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class aqe extends a {
    public aqf wwY;
    public aqd wwZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wwY == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.wwZ == null) {
                throw new b("Not all required fields were included: AesReqData");
            } else {
                if (this.wwY != null) {
                    aVar.fW(1, this.wwY.bke());
                    this.wwY.a(aVar);
                }
                if (this.wwZ == null) {
                    return 0;
                }
                aVar.fW(2, this.wwZ.bke());
                this.wwZ.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wwY != null) {
                r0 = e.a.a.a.fT(1, this.wwY.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wwZ != null) {
                r0 += e.a.a.a.fT(2, this.wwZ.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wwY == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.wwZ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AesReqData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aqe com_tencent_mm_protocal_c_aqe = (aqe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_aqf;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aqf = new aqf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aqf.a(aVar4, com_tencent_mm_protocal_c_aqf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqe.wwY = com_tencent_mm_protocal_c_aqf;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_aqf = new aqd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aqf.a(aVar4, com_tencent_mm_protocal_c_aqf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqe.wwZ = com_tencent_mm_protocal_c_aqf;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
