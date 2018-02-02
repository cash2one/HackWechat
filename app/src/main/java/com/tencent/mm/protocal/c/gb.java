package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class gb extends a {
    public LinkedList<ga> vLt = new LinkedList();
    public fz vLu;
    public int vLv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.vLt);
            if (this.vLu != null) {
                aVar.fW(2, this.vLu.bke());
                this.vLu.a(aVar);
            }
            aVar.fU(3, this.vLv);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.c(1, 8, this.vLt) + 0;
            if (this.vLu != null) {
                r0 += e.a.a.a.fT(2, this.vLu.bke());
            }
            return r0 + e.a.a.a.fR(3, this.vLv);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vLt.clear();
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
            gb gbVar = (gb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a gaVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        gaVar = new ga();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = gaVar.a(aVar4, gaVar, a.a(aVar4))) {
                        }
                        gbVar.vLt.add(gaVar);
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        gaVar = new fz();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = gaVar.a(aVar4, gaVar, a.a(aVar4))) {
                        }
                        gbVar.vLu = gaVar;
                    }
                    return 0;
                case 3:
                    gbVar.vLv = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
