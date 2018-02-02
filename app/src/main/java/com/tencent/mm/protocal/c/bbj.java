package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bbj extends a {
    public bkj wHL;
    public bdo wHM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wHL == null) {
                throw new b("Not all required fields were included: SnsRecommendObject");
            }
            if (this.wHL != null) {
                aVar.fW(1, this.wHL.bke());
                this.wHL.a(aVar);
            }
            if (this.wHM == null) {
                return 0;
            }
            aVar.fW(2, this.wHM.bke());
            this.wHM.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wHL != null) {
                r0 = e.a.a.a.fT(1, this.wHL.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wHM != null) {
                r0 += e.a.a.a.fT(2, this.wHM.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wHL != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SnsRecommendObject");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bbj com_tencent_mm_protocal_c_bbj = (bbj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bkj;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bkj = new bkj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bkj.a(aVar4, com_tencent_mm_protocal_c_bkj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbj.wHL = com_tencent_mm_protocal_c_bkj;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bkj = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bkj.a(aVar4, com_tencent_mm_protocal_c_bkj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbj.wHM = com_tencent_mm_protocal_c_bkj;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
