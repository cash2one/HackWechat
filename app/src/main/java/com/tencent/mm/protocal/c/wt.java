package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class wt extends a {
    public String fon;
    public int type;
    public LinkedList<wn> whd = new LinkedList();
    public LinkedList<wv> whe = new LinkedList();
    public String whf;
    public String whg;
    public LinkedList<wu> whh = new LinkedList();
    public int whi;
    public boolean whj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon != null) {
                aVar.g(1, this.fon);
            }
            aVar.fU(2, this.type);
            aVar.d(3, 8, this.whd);
            aVar.d(4, 8, this.whe);
            if (this.whf != null) {
                aVar.g(5, this.whf);
            }
            if (this.whg != null) {
                aVar.g(6, this.whg);
            }
            aVar.d(7, 8, this.whh);
            aVar.fU(8, this.whi);
            aVar.al(9, this.whj);
            return 0;
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + e.a.a.a.fR(2, this.type)) + e.a.a.a.c(3, 8, this.whd)) + e.a.a.a.c(4, 8, this.whe);
            if (this.whf != null) {
                r0 += e.a.a.b.b.a.h(5, this.whf);
            }
            if (this.whg != null) {
                r0 += e.a.a.b.b.a.h(6, this.whg);
            }
            return ((r0 + e.a.a.a.c(7, 8, this.whh)) + e.a.a.a.fR(8, this.whi)) + (e.a.a.b.b.a.dX(9) + 1);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.whd.clear();
            this.whe.clear();
            this.whh.clear();
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
            wt wtVar = (wt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a wnVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    wtVar.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    wtVar.type = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        wnVar = new wn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = wnVar.a(aVar4, wnVar, a.a(aVar4))) {
                        }
                        wtVar.whd.add(wnVar);
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        wnVar = new wv();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = wnVar.a(aVar4, wnVar, a.a(aVar4))) {
                        }
                        wtVar.whe.add(wnVar);
                    }
                    return 0;
                case 5:
                    wtVar.whf = aVar3.Avy.readString();
                    return 0;
                case 6:
                    wtVar.whg = aVar3.Avy.readString();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        wnVar = new wu();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = wnVar.a(aVar4, wnVar, a.a(aVar4))) {
                        }
                        wtVar.whh.add(wnVar);
                    }
                    return 0;
                case 8:
                    wtVar.whi = aVar3.Avy.ry();
                    return 0;
                case 9:
                    wtVar.whj = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
