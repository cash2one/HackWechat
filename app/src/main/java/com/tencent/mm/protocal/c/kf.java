package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class kf extends a {
    public String name;
    public String vDi;
    public LinkedList<pi> vQU = new LinkedList();
    public int vQV;
    public String vQW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.vQU);
            if (this.vDi != null) {
                aVar.g(2, this.vDi);
            }
            aVar.fU(3, this.vQV);
            if (this.vQW != null) {
                aVar.g(4, this.vQW);
            }
            if (this.name != null) {
                aVar.g(5, this.name);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.c(1, 8, this.vQU) + 0;
            if (this.vDi != null) {
                r0 += e.a.a.b.b.a.h(2, this.vDi);
            }
            r0 += e.a.a.a.fR(3, this.vQV);
            if (this.vQW != null) {
                r0 += e.a.a.b.b.a.h(4, this.vQW);
            }
            if (this.name != null) {
                return r0 + e.a.a.b.b.a.h(5, this.name);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vQU.clear();
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
            kf kfVar = (kf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a piVar = new pi();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = piVar.a(aVar4, piVar, a.a(aVar4))) {
                        }
                        kfVar.vQU.add(piVar);
                    }
                    return 0;
                case 2:
                    kfVar.vDi = aVar3.Avy.readString();
                    return 0;
                case 3:
                    kfVar.vQV = aVar3.Avy.ry();
                    return 0;
                case 4:
                    kfVar.vQW = aVar3.Avy.readString();
                    return 0;
                case 5:
                    kfVar.name = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
