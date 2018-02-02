package com.tencent.mm.plugin.o.a;

import java.util.LinkedList;

public final class a extends com.tencent.mm.bq.a {
    public LinkedList<b> nBH = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).d(1, 8, this.nBH);
            return 0;
        } else if (i == 1) {
            return e.a.a.a.c(1, 8, this.nBH) + 0;
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.nBH.clear();
                e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = com.tencent.mm.bq.a.a(aVar); a > 0; a = com.tencent.mm.bq.a.a(aVar)) {
                    if (!super.a(aVar, this, a)) {
                        aVar.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
                a aVar3 = (a) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList Jl = aVar2.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            com.tencent.mm.bq.a bVar = new b();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = bVar.a(aVar4, bVar, com.tencent.mm.bq.a.a(aVar4))) {
                            }
                            aVar3.nBH.add(bVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
