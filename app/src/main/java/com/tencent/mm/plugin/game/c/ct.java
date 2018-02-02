package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ct extends a {
    public String fon;
    public String ngs;
    public LinkedList<cz> njs = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.ngs == null) {
                throw new b("Not all required fields were included: Detail");
            } else {
                if (this.fon != null) {
                    aVar.g(1, this.fon);
                }
                aVar.d(2, 8, this.njs);
                if (this.ngs == null) {
                    return 0;
                }
                aVar.g(3, this.ngs);
                return 0;
            }
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.c(2, 8, this.njs);
            if (this.ngs != null) {
                r0 += e.a.a.b.b.a.h(3, this.ngs);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.njs.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.ngs != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Detail");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ct ctVar = (ct) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ctVar.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a czVar = new cz();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = czVar.a(aVar4, czVar, a.a(aVar4))) {
                        }
                        ctVar.njs.add(czVar);
                    }
                    return 0;
                case 3:
                    ctVar.ngs = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
