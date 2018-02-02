package com.tencent.mm.plugin.report.service;

import java.util.LinkedList;

public final class a extends com.tencent.mm.bq.a {
    public int ksO;
    public LinkedList<b> pQi = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.ksO);
            aVar.d(2, 8, this.pQi);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.fR(1, this.ksO) + 0) + e.a.a.a.c(2, 8, this.pQi);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.pQi.clear();
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
                switch (intValue) {
                    case 1:
                        aVar4.ksO = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        LinkedList Jl = aVar3.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            com.tencent.mm.bq.a bVar = new b();
                            e.a.a.a.a aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = bVar.a(aVar5, bVar, com.tencent.mm.bq.a.a(aVar5))) {
                            }
                            aVar4.pQi.add(bVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
