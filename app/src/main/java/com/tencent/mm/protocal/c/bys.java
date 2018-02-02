package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bys extends a {
    public boolean wYP;
    public boolean wYx;
    public LinkedList<byq> woc = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.al(1, this.wYx);
            aVar.d(2, 8, this.woc);
            aVar.al(3, this.wYP);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.b.b.a.dX(1) + 1) + 0) + e.a.a.a.c(2, 8, this.woc)) + (e.a.a.b.b.a.dX(3) + 1);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.woc.clear();
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
                bys com_tencent_mm_protocal_c_bys = (bys) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        com_tencent_mm_protocal_c_bys.wYx = aVar3.cJC();
                        return 0;
                    case 2:
                        LinkedList Jl = aVar3.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            a com_tencent_mm_protocal_c_byq = new byq();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_byq.a(aVar4, com_tencent_mm_protocal_c_byq, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_bys.woc.add(com_tencent_mm_protocal_c_byq);
                        }
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_bys.wYP = aVar3.cJC();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
