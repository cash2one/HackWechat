package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class gm extends a {
    public String fpL;
    public String oZC;
    public String username;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.g(1, this.username);
            }
            if (this.oZC != null) {
                aVar.g(2, this.oZC);
            }
            if (this.fpL == null) {
                return 0;
            }
            aVar.g(3, this.fpL);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                r0 = e.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                r0 = 0;
            }
            if (this.oZC != null) {
                r0 += e.a.a.b.b.a.h(2, this.oZC);
            }
            if (this.fpL != null) {
                r0 += e.a.a.b.b.a.h(3, this.fpL);
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
            gm gmVar = (gm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gmVar.username = aVar3.Avy.readString();
                    return 0;
                case 2:
                    gmVar.oZC = aVar3.Avy.readString();
                    return 0;
                case 3:
                    gmVar.fpL = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
