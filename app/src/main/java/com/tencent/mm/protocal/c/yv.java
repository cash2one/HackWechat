package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class yv extends a {
    public au vQS;
    public String vUz;
    public LinkedList<String> wiN = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.wiN);
            if (this.vQS != null) {
                aVar.fW(2, this.vQS.bke());
                this.vQS.a(aVar);
            }
            if (this.vUz != null) {
                aVar.g(3, this.vUz);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.c(1, 1, this.wiN) + 0;
            if (this.vQS != null) {
                r0 += e.a.a.a.fT(2, this.vQS.bke());
            }
            if (this.vUz != null) {
                return r0 + e.a.a.b.b.a.h(3, this.vUz);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wiN.clear();
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
            yv yvVar = (yv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    yvVar.wiN.add(aVar3.Avy.readString());
                    return 0;
                case 2:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a auVar = new au();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = auVar.a(aVar4, auVar, a.a(aVar4))) {
                        }
                        yvVar.vQS = auVar;
                    }
                    return 0;
                case 3:
                    yvVar.vUz = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
