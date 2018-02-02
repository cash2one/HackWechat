package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bq.a;

public final class e extends a {
    public String sDk;
    public String sDl;
    public String sDm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.sDk != null) {
                aVar.g(1, this.sDk);
            }
            if (this.sDl != null) {
                aVar.g(2, this.sDl);
            }
            if (this.sDm == null) {
                return 0;
            }
            aVar.g(3, this.sDm);
            return 0;
        } else if (i == 1) {
            if (this.sDk != null) {
                r0 = e.a.a.b.b.a.h(1, this.sDk) + 0;
            } else {
                r0 = 0;
            }
            if (this.sDl != null) {
                r0 += e.a.a.b.b.a.h(2, this.sDl);
            }
            if (this.sDm != null) {
                r0 += e.a.a.b.b.a.h(3, this.sDm);
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
            e eVar = (e) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eVar.sDk = aVar3.Avy.readString();
                    return 0;
                case 2:
                    eVar.sDl = aVar3.Avy.readString();
                    return 0;
                case 3:
                    eVar.sDm = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
