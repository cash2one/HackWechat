package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ce extends a {
    public String fon;
    public String niR;
    public String niS;
    public LinkedList<cf> niW = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            }
            if (this.fon != null) {
                aVar.g(1, this.fon);
            }
            aVar.d(2, 8, this.niW);
            if (this.niR != null) {
                aVar.g(3, this.niR);
            }
            if (this.niS == null) {
                return 0;
            }
            aVar.g(4, this.niS);
            return 0;
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.c(2, 8, this.niW);
            if (this.niR != null) {
                r0 += e.a.a.b.b.a.h(3, this.niR);
            }
            if (this.niS != null) {
                r0 += e.a.a.b.b.a.h(4, this.niS);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.niW.clear();
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
            ce ceVar = (ce) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ceVar.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a cfVar = new cf();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = cfVar.a(aVar4, cfVar, a.a(aVar4))) {
                        }
                        ceVar.niW.add(cfVar);
                    }
                    return 0;
                case 3:
                    ceVar.niR = aVar3.Avy.readString();
                    return 0;
                case 4:
                    ceVar.niS = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
