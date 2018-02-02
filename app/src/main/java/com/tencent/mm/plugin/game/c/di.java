package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class di extends a {
    public String niS;
    public LinkedList<dj> njP = new LinkedList();
    public String njQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.njP);
            if (this.niS != null) {
                aVar.g(2, this.niS);
            }
            if (this.njQ != null) {
                aVar.g(3, this.njQ);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.c(1, 8, this.njP) + 0;
            if (this.niS != null) {
                r0 += e.a.a.b.b.a.h(2, this.niS);
            }
            if (this.njQ != null) {
                return r0 + e.a.a.b.b.a.h(3, this.njQ);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.njP.clear();
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
            di diVar = (di) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a djVar = new dj();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = djVar.a(aVar4, djVar, a.a(aVar4))) {
                        }
                        diVar.njP.add(djVar);
                    }
                    return 0;
                case 2:
                    diVar.niS = aVar3.Avy.readString();
                    return 0;
                case 3:
                    diVar.njQ = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
