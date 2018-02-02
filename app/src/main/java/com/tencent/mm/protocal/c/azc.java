package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class azc extends a {
    public int ksO;
    public LinkedList<azb> wGf = new LinkedList();
    public int wmO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wmO);
            aVar.fU(2, this.ksO);
            aVar.d(3, 8, this.wGf);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.fR(1, this.wmO) + 0) + e.a.a.a.fR(2, this.ksO)) + e.a.a.a.c(3, 8, this.wGf);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.wGf.clear();
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
                azc com_tencent_mm_protocal_c_azc = (azc) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        com_tencent_mm_protocal_c_azc.wmO = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_azc.ksO = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        LinkedList Jl = aVar3.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            a com_tencent_mm_protocal_c_azb = new azb();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_azb.a(aVar4, com_tencent_mm_protocal_c_azb, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_azc.wGf.add(com_tencent_mm_protocal_c_azb);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
