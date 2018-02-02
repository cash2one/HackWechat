package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bq.a;

public final class h extends a {
    public String id;
    public String name;
    public boolean peP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.g(1, this.id);
            }
            if (this.name != null) {
                aVar.g(2, this.name);
            }
            aVar.al(3, this.peP);
            return 0;
        } else if (i == 1) {
            if (this.id != null) {
                r0 = e.a.a.b.b.a.h(1, this.id) + 0;
            } else {
                r0 = 0;
            }
            if (this.name != null) {
                r0 += e.a.a.b.b.a.h(2, this.name);
            }
            return r0 + (e.a.a.b.b.a.dX(3) + 1);
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
            h hVar = (h) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hVar.id = aVar3.Avy.readString();
                    return 0;
                case 2:
                    hVar.name = aVar3.Avy.readString();
                    return 0;
                case 3:
                    hVar.peP = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
