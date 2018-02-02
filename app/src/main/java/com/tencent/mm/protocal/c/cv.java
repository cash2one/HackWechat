package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class cv extends a {
    public String vHO;
    public String vHP;
    public String vHQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vHO != null) {
                aVar.g(1, this.vHO);
            }
            if (this.vHP != null) {
                aVar.g(2, this.vHP);
            }
            if (this.vHQ == null) {
                return 0;
            }
            aVar.g(3, this.vHQ);
            return 0;
        } else if (i == 1) {
            if (this.vHO != null) {
                r0 = e.a.a.b.b.a.h(1, this.vHO) + 0;
            } else {
                r0 = 0;
            }
            if (this.vHP != null) {
                r0 += e.a.a.b.b.a.h(2, this.vHP);
            }
            if (this.vHQ != null) {
                r0 += e.a.a.b.b.a.h(3, this.vHQ);
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
            cv cvVar = (cv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cvVar.vHO = aVar3.Avy.readString();
                    return 0;
                case 2:
                    cvVar.vHP = aVar3.Avy.readString();
                    return 0;
                case 3:
                    cvVar.vHQ = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
