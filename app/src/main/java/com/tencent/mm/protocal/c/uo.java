package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class uo extends a {
    public long wcw;
    public long wcx;
    public LinkedList<bnq> wcy = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.wcw);
            aVar.S(2, this.wcx);
            aVar.d(3, 8, this.wcy);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.R(1, this.wcw) + 0) + e.a.a.a.R(2, this.wcx)) + e.a.a.a.c(3, 8, this.wcy);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.wcy.clear();
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
                uo uoVar = (uo) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        uoVar.wcw = aVar3.Avy.rz();
                        return 0;
                    case 2:
                        uoVar.wcx = aVar3.Avy.rz();
                        return 0;
                    case 3:
                        LinkedList Jl = aVar3.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            a com_tencent_mm_protocal_c_bnq = new bnq();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_bnq.a(aVar4, com_tencent_mm_protocal_c_bnq, a.a(aVar4))) {
                            }
                            uoVar.wcy.add(com_tencent_mm_protocal_c_bnq);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
