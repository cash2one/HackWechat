package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bkp extends a {
    public int ksO;
    public LinkedList<bdo> ksP = new LinkedList();
    public String niX;
    public long wOd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.wOd);
            if (this.niX != null) {
                aVar.g(2, this.niX);
            }
            aVar.fU(3, this.ksO);
            aVar.d(4, 8, this.ksP);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.R(1, this.wOd) + 0;
            if (this.niX != null) {
                r0 += e.a.a.b.b.a.h(2, this.niX);
            }
            return (r0 + e.a.a.a.fR(3, this.ksO)) + e.a.a.a.c(4, 8, this.ksP);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ksP.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
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
            bkp com_tencent_mm_protocal_c_bkp = (bkp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bkp.wOd = aVar3.Avy.rz();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bkp.niX = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bkp.ksO = aVar3.Avy.ry();
                    return 0;
                case 4:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bdo = new bdo();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkp.ksP.add(com_tencent_mm_protocal_c_bdo);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
