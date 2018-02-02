package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bq.a;

public final class d extends a {
    public String name;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.g(1, this.url);
            }
            if (this.name == null) {
                return 0;
            }
            aVar.g(2, this.name);
            return 0;
        } else if (i == 1) {
            if (this.url != null) {
                r0 = e.a.a.b.b.a.h(1, this.url) + 0;
            } else {
                r0 = 0;
            }
            if (this.name != null) {
                r0 += e.a.a.b.b.a.h(2, this.name);
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
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.url = aVar3.Avy.readString();
                    return 0;
                case 2:
                    dVar.name = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
