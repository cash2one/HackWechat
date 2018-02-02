package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class uu extends a {
    public LinkedList<aru> mqQ = new LinkedList();
    public LinkedList<arx> weD = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.mqQ);
            aVar.d(2, 8, this.weD);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.c(1, 8, this.mqQ) + 0) + e.a.a.a.c(2, 8, this.weD);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.mqQ.clear();
                this.weD.clear();
                e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                uu uuVar = (uu) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList Jl;
                int size;
                a com_tencent_mm_protocal_c_aru;
                e.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        Jl = aVar3.Jl(intValue);
                        size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            com_tencent_mm_protocal_c_aru = new aru();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = com_tencent_mm_protocal_c_aru.a(aVar4, com_tencent_mm_protocal_c_aru, a.a(aVar4))) {
                            }
                            uuVar.mqQ.add(com_tencent_mm_protocal_c_aru);
                        }
                        return 0;
                    case 2:
                        Jl = aVar3.Jl(intValue);
                        size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            com_tencent_mm_protocal_c_aru = new arx();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = com_tencent_mm_protocal_c_aru.a(aVar4, com_tencent_mm_protocal_c_aru, a.a(aVar4))) {
                            }
                            uuVar.weD.add(com_tencent_mm_protocal_c_aru);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
