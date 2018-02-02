package com.tencent.mm.plugin.report.service;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class c extends a {
    public boolean pQl;
    public int pQs;
    public String pQt;
    public boolean pQu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pQt == null) {
                throw new b("Not all required fields were included: Value");
            }
            aVar.fU(1, this.pQs);
            if (this.pQt != null) {
                aVar.g(2, this.pQt);
            }
            aVar.al(3, this.pQu);
            aVar.al(4, this.pQl);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.pQs) + 0;
            if (this.pQt != null) {
                r0 += e.a.a.b.b.a.h(2, this.pQt);
            }
            return (r0 + (e.a.a.b.b.a.dX(3) + 1)) + (e.a.a.b.b.a.dX(4) + 1);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.pQt != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Value");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.pQs = aVar3.Avy.ry();
                    return 0;
                case 2:
                    cVar.pQt = aVar3.Avy.readString();
                    return 0;
                case 3:
                    cVar.pQu = aVar3.cJC();
                    return 0;
                case 4:
                    cVar.pQl = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
