package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bfx extends bcv {
    public int ksO;
    public LinkedList<ara> ksP = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            aVar.fU(1, this.ksO);
            aVar.d(2, 8, this.ksP);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.fR(1, this.ksO) + 0) + e.a.a.a.c(2, 8, this.ksP);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.ksP.clear();
                e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = bcv.a(aVar2); a > 0; a = bcv.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                bfx com_tencent_mm_protocal_c_bfx = (bfx) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        com_tencent_mm_protocal_c_bfx.ksO = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        LinkedList Jl = aVar3.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            com.tencent.mm.bq.a com_tencent_mm_protocal_c_ara = new ara();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_ara.a(aVar4, com_tencent_mm_protocal_c_ara, bcv.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_bfx.ksP.add(com_tencent_mm_protocal_c_ara);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
