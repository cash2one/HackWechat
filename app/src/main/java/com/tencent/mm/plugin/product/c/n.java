package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bq.a;

public final class n extends a {
    public int fDt;
    public String fFm;
    public String name;
    public String peY;
    public String username;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fFm != null) {
                aVar.g(1, this.fFm);
            }
            if (this.name != null) {
                aVar.g(2, this.name);
            }
            if (this.peY != null) {
                aVar.g(3, this.peY);
            }
            if (this.username != null) {
                aVar.g(4, this.username);
            }
            aVar.fU(5, this.fDt);
            return 0;
        } else if (i == 1) {
            if (this.fFm != null) {
                r0 = e.a.a.b.b.a.h(1, this.fFm) + 0;
            } else {
                r0 = 0;
            }
            if (this.name != null) {
                r0 += e.a.a.b.b.a.h(2, this.name);
            }
            if (this.peY != null) {
                r0 += e.a.a.b.b.a.h(3, this.peY);
            }
            if (this.username != null) {
                r0 += e.a.a.b.b.a.h(4, this.username);
            }
            return r0 + e.a.a.a.fR(5, this.fDt);
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
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.fFm = aVar3.Avy.readString();
                    return 0;
                case 2:
                    nVar.name = aVar3.Avy.readString();
                    return 0;
                case 3:
                    nVar.peY = aVar3.Avy.readString();
                    return 0;
                case 4:
                    nVar.username = aVar3.Avy.readString();
                    return 0;
                case 5:
                    nVar.fDt = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
