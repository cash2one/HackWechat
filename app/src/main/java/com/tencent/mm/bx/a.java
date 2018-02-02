package com.tencent.mm.bx;

import java.util.LinkedList;

public final class a extends com.tencent.mm.bq.a {
    public LinkedList<d> xkn = new LinkedList();
    public LinkedList<c> xko = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(3, 8, this.xkn);
            aVar.d(4, 8, this.xko);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.c(3, 8, this.xkn) + 0) + e.a.a.a.c(4, 8, this.xko);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.xkn.clear();
                this.xko.clear();
                e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = com.tencent.mm.bq.a.a(aVar2); a > 0; a = com.tencent.mm.bq.a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                a aVar4 = (a) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList Jl;
                int size;
                com.tencent.mm.bq.a dVar;
                e.a.a.a.a aVar5;
                boolean z;
                switch (intValue) {
                    case 3:
                        Jl = aVar3.Jl(intValue);
                        size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            dVar = new d();
                            aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = dVar.a(aVar5, dVar, com.tencent.mm.bq.a.a(aVar5))) {
                            }
                            aVar4.xkn.add(dVar);
                        }
                        return 0;
                    case 4:
                        Jl = aVar3.Jl(intValue);
                        size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            dVar = new c();
                            aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = dVar.a(aVar5, dVar, com.tencent.mm.bq.a.a(aVar5))) {
                            }
                            aVar4.xko.add(dVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
