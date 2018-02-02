package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ak extends a {
    public String nfK;
    public String nfO;
    public LinkedList<do> ngS = new LinkedList();
    public String ngT;
    public String ngU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfO != null) {
                aVar.g(1, this.nfO);
            }
            aVar.d(2, 8, this.ngS);
            if (this.ngT != null) {
                aVar.g(3, this.ngT);
            }
            if (this.ngU != null) {
                aVar.g(4, this.ngU);
            }
            if (this.nfK == null) {
                return 0;
            }
            aVar.g(5, this.nfK);
            return 0;
        } else if (i == 1) {
            if (this.nfO != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfO) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.c(2, 8, this.ngS);
            if (this.ngT != null) {
                r0 += e.a.a.b.b.a.h(3, this.ngT);
            }
            if (this.ngU != null) {
                r0 += e.a.a.b.b.a.h(4, this.ngU);
            }
            if (this.nfK != null) {
                r0 += e.a.a.b.b.a.h(5, this.nfK);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ngS.clear();
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
            ak akVar = (ak) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    akVar.nfO = aVar3.Avy.readString();
                    return 0;
                case 2:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a doVar = new do();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = doVar.a(aVar4, doVar, a.a(aVar4))) {
                        }
                        akVar.ngS.add(doVar);
                    }
                    return 0;
                case 3:
                    akVar.ngT = aVar3.Avy.readString();
                    return 0;
                case 4:
                    akVar.ngU = aVar3.Avy.readString();
                    return 0;
                case 5:
                    akVar.nfK = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
