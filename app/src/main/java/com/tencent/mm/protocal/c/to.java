package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class to extends a {
    public String wbA;
    public String wbB;
    public int wby;
    public String wbz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wby);
            if (this.wbz != null) {
                aVar.g(2, this.wbz);
            }
            if (this.wbB != null) {
                aVar.g(3, this.wbB);
            }
            if (this.wbA != null) {
                aVar.g(4, this.wbA);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wby) + 0;
            if (this.wbz != null) {
                r0 += e.a.a.b.b.a.h(2, this.wbz);
            }
            if (this.wbB != null) {
                r0 += e.a.a.b.b.a.h(3, this.wbB);
            }
            if (this.wbA != null) {
                return r0 + e.a.a.b.b.a.h(4, this.wbA);
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
            to toVar = (to) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    toVar.wby = aVar3.Avy.ry();
                    return 0;
                case 2:
                    toVar.wbz = aVar3.Avy.readString();
                    return 0;
                case 3:
                    toVar.wbB = aVar3.Avy.readString();
                    return 0;
                case 4:
                    toVar.wbA = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
