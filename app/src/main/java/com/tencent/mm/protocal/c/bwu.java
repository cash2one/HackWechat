package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bwu extends a {
    public int ksO;
    public LinkedList<bwt> wXJ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.wXJ);
            aVar.fU(2, this.ksO);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.c(1, 8, this.wXJ) + 0) + e.a.a.a.fR(2, this.ksO);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.wXJ.clear();
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
                bwu com_tencent_mm_protocal_c_bwu = (bwu) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList Jl = aVar3.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            a com_tencent_mm_protocal_c_bwt = new bwt();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_bwt.a(aVar4, com_tencent_mm_protocal_c_bwt, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_bwu.wXJ.add(com_tencent_mm_protocal_c_bwt);
                        }
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bwu.ksO = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
