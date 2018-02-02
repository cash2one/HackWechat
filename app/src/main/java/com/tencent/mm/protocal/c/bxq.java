package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bxq extends bcv {
    public String fDj;
    public String fFm;
    public int id;
    public LinkedList<Integer> wYq = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.fFm != null) {
                aVar.g(2, this.fFm);
            }
            aVar.fU(3, this.id);
            aVar.d(4, 2, this.wYq);
            if (this.fDj == null) {
                return 0;
            }
            aVar.g(5, this.fDj);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fFm != null) {
                r0 += e.a.a.b.b.a.h(2, this.fFm);
            }
            r0 = (r0 + e.a.a.a.fR(3, this.id)) + e.a.a.a.c(4, 2, this.wYq);
            if (this.fDj != null) {
                r0 += e.a.a.b.b.a.h(5, this.fDj);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wYq.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bxq com_tencent_mm_protocal_c_bxq = (bxq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bxq.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bxq.fFm = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bxq.id = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bxq.wYq.add(Integer.valueOf(aVar3.Avy.ry()));
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bxq.fDj = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
