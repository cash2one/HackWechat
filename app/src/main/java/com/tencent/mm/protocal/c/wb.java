package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class wb extends a {
    public int index;
    public int jer;
    public String username;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.index);
            if (this.username != null) {
                aVar.g(2, this.username);
            }
            aVar.fU(3, this.jer);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.index) + 0;
            if (this.username != null) {
                r0 += e.a.a.b.b.a.h(2, this.username);
            }
            return r0 + e.a.a.a.fR(3, this.jer);
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
            wb wbVar = (wb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wbVar.index = aVar3.Avy.ry();
                    return 0;
                case 2:
                    wbVar.username = aVar3.Avy.readString();
                    return 0;
                case 3:
                    wbVar.jer = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
