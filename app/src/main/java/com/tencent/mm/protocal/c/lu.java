package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class lu extends bcv {
    public String desc;
    public LinkedList<Integer> vTY = new LinkedList();
    public boolean vUx;
    public boolean vUy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.d(2, 2, this.vTY);
            if (this.desc != null) {
                aVar.g(3, this.desc);
            }
            aVar.al(4, this.vUx);
            aVar.al(5, this.vUy);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.c(2, 2, this.vTY);
            if (this.desc != null) {
                r0 += e.a.a.b.b.a.h(3, this.desc);
            }
            return (r0 + (e.a.a.b.b.a.dX(4) + 1)) + (e.a.a.b.b.a.dX(5) + 1);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vTY.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            lu luVar = (lu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        luVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    luVar.vTY.add(Integer.valueOf(aVar3.Avy.ry()));
                    return 0;
                case 3:
                    luVar.desc = aVar3.Avy.readString();
                    return 0;
                case 4:
                    luVar.vUx = aVar3.cJC();
                    return 0;
                case 5:
                    luVar.vUy = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
