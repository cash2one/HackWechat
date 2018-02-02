package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class fa extends a {
    public String vKO;
    public String vKP;
    public String vKQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vKO != null) {
                aVar.g(1, this.vKO);
            }
            if (this.vKP != null) {
                aVar.g(2, this.vKP);
            }
            if (this.vKQ == null) {
                return 0;
            }
            aVar.g(3, this.vKQ);
            return 0;
        } else if (i == 1) {
            if (this.vKO != null) {
                r0 = e.a.a.b.b.a.h(1, this.vKO) + 0;
            } else {
                r0 = 0;
            }
            if (this.vKP != null) {
                r0 += e.a.a.b.b.a.h(2, this.vKP);
            }
            if (this.vKQ != null) {
                r0 += e.a.a.b.b.a.h(3, this.vKQ);
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
            fa faVar = (fa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    faVar.vKO = aVar3.Avy.readString();
                    return 0;
                case 2:
                    faVar.vKP = aVar3.Avy.readString();
                    return 0;
                case 3:
                    faVar.vKQ = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
