package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ra extends a {
    public String kJQ;
    public String title;
    public int vZc;
    public LinkedList<oq> vZd = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.kJQ != null) {
                aVar.g(2, this.kJQ);
            }
            aVar.fU(3, this.vZc);
            aVar.d(4, 8, this.vZd);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.kJQ != null) {
                r0 += e.a.a.b.b.a.h(2, this.kJQ);
            }
            return (r0 + e.a.a.a.fR(3, this.vZc)) + e.a.a.a.c(4, 8, this.vZd);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vZd.clear();
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
            ra raVar = (ra) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    raVar.title = aVar3.Avy.readString();
                    return 0;
                case 2:
                    raVar.kJQ = aVar3.Avy.readString();
                    return 0;
                case 3:
                    raVar.vZc = aVar3.Avy.ry();
                    return 0;
                case 4:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a oqVar = new oq();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = oqVar.a(aVar4, oqVar, a.a(aVar4))) {
                        }
                        raVar.vZd.add(oqVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
