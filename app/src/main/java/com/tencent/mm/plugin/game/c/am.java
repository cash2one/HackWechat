package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class am extends a {
    public LinkedList<dd> nfN = new LinkedList();
    public da ngV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.nfN);
            if (this.ngV != null) {
                aVar.fW(2, this.ngV.bke());
                this.ngV.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.c(1, 8, this.nfN) + 0;
            if (this.ngV != null) {
                return r0 + e.a.a.a.fT(2, this.ngV.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.nfN.clear();
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
            am amVar = (am) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a ddVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        ddVar = new dd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ddVar.a(aVar4, ddVar, a.a(aVar4))) {
                        }
                        amVar.nfN.add(ddVar);
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        ddVar = new da();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ddVar.a(aVar4, ddVar, a.a(aVar4))) {
                        }
                        amVar.ngV = ddVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
