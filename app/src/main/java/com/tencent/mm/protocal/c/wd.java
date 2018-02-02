package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class wd extends a {
    public String username;
    public boolean wgB;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.g(1, this.username);
            }
            aVar.al(2, this.wgB);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                r0 = e.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                r0 = 0;
            }
            return r0 + (e.a.a.b.b.a.dX(2) + 1);
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
            wd wdVar = (wd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wdVar.username = aVar3.Avy.readString();
                    return 0;
                case 2:
                    wdVar.wgB = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
