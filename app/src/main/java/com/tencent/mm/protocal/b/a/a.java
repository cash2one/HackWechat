package com.tencent.mm.protocal.b.a;

import e.a.a.b;

public final class a extends com.tencent.mm.bq.a {
    public int actionType;
    public int id;
    public String vCQ;
    public String vCR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vCQ == null) {
                throw new b("Not all required fields were included: btnStr");
            }
            aVar.fU(1, this.id);
            aVar.fU(2, this.actionType);
            if (this.vCQ != null) {
                aVar.g(3, this.vCQ);
            }
            if (this.vCR != null) {
                aVar.g(4, this.vCR);
            }
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.fR(1, this.id) + 0) + e.a.a.a.fR(2, this.actionType);
            if (this.vCQ != null) {
                r0 += e.a.a.b.b.a.h(3, this.vCQ);
            }
            if (this.vCR != null) {
                return r0 + e.a.a.b.b.a.h(4, this.vCR);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vCQ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: btnStr");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.id = aVar3.Avy.ry();
                    return 0;
                case 2:
                    aVar4.actionType = aVar3.Avy.ry();
                    return 0;
                case 3:
                    aVar4.vCQ = aVar3.Avy.readString();
                    return 0;
                case 4:
                    aVar4.vCR = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
