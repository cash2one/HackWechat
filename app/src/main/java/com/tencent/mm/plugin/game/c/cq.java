package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cq extends a {
    public String fon;
    public LinkedList<cr> njp = new LinkedList();
    public cs njq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            }
            if (this.fon != null) {
                aVar.g(1, this.fon);
            }
            aVar.d(2, 8, this.njp);
            if (this.njq == null) {
                return 0;
            }
            aVar.fW(3, this.njq.bke());
            this.njq.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.c(2, 8, this.njp);
            if (this.njq != null) {
                r0 += e.a.a.a.fT(3, this.njq.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.njp.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.fon != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Title");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cq cqVar = (cq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a crVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cqVar.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        crVar = new cr();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = crVar.a(aVar4, crVar, a.a(aVar4))) {
                        }
                        cqVar.njp.add(crVar);
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        crVar = new cs();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = crVar.a(aVar4, crVar, a.a(aVar4))) {
                        }
                        cqVar.njq = crVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
