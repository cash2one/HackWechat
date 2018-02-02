package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class j extends a {
    public String nfK;
    public LinkedList<av> nfN = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.nfN);
            if (this.nfK != null) {
                aVar.g(2, this.nfK);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.c(1, 8, this.nfN) + 0;
            if (this.nfK != null) {
                return r0 + e.a.a.b.b.a.h(2, this.nfK);
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
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a avVar = new av();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = avVar.a(aVar4, avVar, a.a(aVar4))) {
                        }
                        jVar.nfN.add(avVar);
                    }
                    return 0;
                case 2:
                    jVar.nfK = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
