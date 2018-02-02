package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class wj extends a {
    public LinkedList<hl> vNs = new LinkedList();
    public hj wgJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wgJ != null) {
                aVar.fW(1, this.wgJ.bke());
                this.wgJ.a(aVar);
            }
            aVar.d(2, 8, this.vNs);
            return 0;
        } else if (i == 1) {
            if (this.wgJ != null) {
                r0 = e.a.a.a.fT(1, this.wgJ.bke()) + 0;
            } else {
                r0 = 0;
            }
            return r0 + e.a.a.a.c(2, 8, this.vNs);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vNs.clear();
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
            wj wjVar = (wj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a hjVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        hjVar = new hj();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = hjVar.a(aVar4, hjVar, a.a(aVar4))) {
                        }
                        wjVar.wgJ = hjVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        hjVar = new hl();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = hjVar.a(aVar4, hjVar, a.a(aVar4))) {
                        }
                        wjVar.vNs.add(hjVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
