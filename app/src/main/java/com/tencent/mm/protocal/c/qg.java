package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class qg extends a {
    public int ksO;
    public bdo vYI;
    public LinkedList<Integer> vYP = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vYI == null) {
                throw new b("Not all required fields were included: UserName");
            }
            if (this.vYI != null) {
                aVar.fW(1, this.vYI.bke());
                this.vYI.a(aVar);
            }
            aVar.fU(2, this.ksO);
            aVar.c(3, this.vYP);
            return 0;
        } else if (i == 1) {
            if (this.vYI != null) {
                r0 = e.a.a.a.fT(1, this.vYI.bke()) + 0;
            } else {
                r0 = 0;
            }
            return (r0 + e.a.a.a.fR(2, this.ksO)) + e.a.a.a.b(3, this.vYP);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vYP.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vYI != null) {
                return 0;
            }
            throw new b("Not all required fields were included: UserName");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            qg qgVar = (qg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bdo = new bdo();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        qgVar.vYI = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 2:
                    qgVar.ksO = aVar3.Avy.ry();
                    return 0;
                case 3:
                    qgVar.vYP = new e.a.a.a.a(aVar3.cJD().oz, unknownTagHandler).cJA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
