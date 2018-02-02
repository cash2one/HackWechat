package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bq.a;

public final class k extends a {
    public String oZC;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.oZC != null) {
                aVar.g(1, this.oZC);
            }
            if (this.url == null) {
                return 0;
            }
            aVar.g(2, this.url);
            return 0;
        } else if (i == 1) {
            if (this.oZC != null) {
                r0 = e.a.a.b.b.a.h(1, this.oZC) + 0;
            } else {
                r0 = 0;
            }
            if (this.url != null) {
                r0 += e.a.a.b.b.a.h(2, this.url);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            k kVar = (k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kVar.oZC = aVar3.Avy.readString();
                    return 0;
                case 2:
                    kVar.url = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
