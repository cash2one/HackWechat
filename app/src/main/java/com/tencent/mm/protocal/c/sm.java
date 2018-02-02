package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class sm extends a {
    public String njX;
    public String waO;
    public String waP;
    public String waQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.njX == null) {
                throw new b("Not all required fields were included: Label");
            } else if (this.waO == null) {
                throw new b("Not all required fields were included: Number");
            } else if (this.waP == null) {
                throw new b("Not all required fields were included: Type");
            } else {
                if (this.njX != null) {
                    aVar.g(1, this.njX);
                }
                if (this.waO != null) {
                    aVar.g(2, this.waO);
                }
                if (this.waP != null) {
                    aVar.g(3, this.waP);
                }
                if (this.waQ == null) {
                    return 0;
                }
                aVar.g(4, this.waQ);
                return 0;
            }
        } else if (i == 1) {
            if (this.njX != null) {
                r0 = e.a.a.b.b.a.h(1, this.njX) + 0;
            } else {
                r0 = 0;
            }
            if (this.waO != null) {
                r0 += e.a.a.b.b.a.h(2, this.waO);
            }
            if (this.waP != null) {
                r0 += e.a.a.b.b.a.h(3, this.waP);
            }
            if (this.waQ != null) {
                r0 += e.a.a.b.b.a.h(4, this.waQ);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.njX == null) {
                throw new b("Not all required fields were included: Label");
            } else if (this.waO == null) {
                throw new b("Not all required fields were included: Number");
            } else if (this.waP != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Type");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sm smVar = (sm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    smVar.njX = aVar3.Avy.readString();
                    return 0;
                case 2:
                    smVar.waO = aVar3.Avy.readString();
                    return 0;
                case 3:
                    smVar.waP = aVar3.Avy.readString();
                    return 0;
                case 4:
                    smVar.waQ = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
