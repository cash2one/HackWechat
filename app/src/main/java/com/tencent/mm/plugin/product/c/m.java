package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class m extends a {
    public String peV;
    public String peW;
    public LinkedList<h> peX = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.peV != null) {
                aVar.g(1, this.peV);
            }
            if (this.peW != null) {
                aVar.g(2, this.peW);
            }
            aVar.d(3, 8, this.peX);
            return 0;
        } else if (i == 1) {
            if (this.peV != null) {
                r0 = e.a.a.b.b.a.h(1, this.peV) + 0;
            } else {
                r0 = 0;
            }
            if (this.peW != null) {
                r0 += e.a.a.b.b.a.h(2, this.peW);
            }
            return r0 + e.a.a.a.c(3, 8, this.peX);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.peX.clear();
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
            m mVar = (m) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    mVar.peV = aVar3.Avy.readString();
                    return 0;
                case 2:
                    mVar.peW = aVar3.Avy.readString();
                    return 0;
                case 3:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a hVar = new h();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                        }
                        mVar.peX.add(hVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
