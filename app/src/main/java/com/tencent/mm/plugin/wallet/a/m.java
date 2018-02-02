package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bq.a;

public final class m extends a {
    public int id;
    public String name;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.id);
            if (this.name != null) {
                aVar.g(2, this.name);
            }
            if (this.url != null) {
                aVar.g(3, this.url);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.id) + 0;
            if (this.name != null) {
                r0 += e.a.a.b.b.a.h(2, this.name);
            }
            if (this.url != null) {
                return r0 + e.a.a.b.b.a.h(3, this.url);
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
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.id = aVar3.Avy.ry();
                    return 0;
                case 2:
                    mVar.name = aVar3.Avy.readString();
                    return 0;
                case 3:
                    mVar.url = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
