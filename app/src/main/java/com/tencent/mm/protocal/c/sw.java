package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class sw extends a {
    public String hbM;
    public int pHA;
    public int pHx;
    public String pHy;
    public String pHz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.pHx);
            if (this.pHy != null) {
                aVar.g(2, this.pHy);
            }
            if (this.pHz != null) {
                aVar.g(3, this.pHz);
            }
            aVar.fU(4, this.pHA);
            if (this.hbM != null) {
                aVar.g(5, this.hbM);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.pHx) + 0;
            if (this.pHy != null) {
                r0 += e.a.a.b.b.a.h(2, this.pHy);
            }
            if (this.pHz != null) {
                r0 += e.a.a.b.b.a.h(3, this.pHz);
            }
            r0 += e.a.a.a.fR(4, this.pHA);
            if (this.hbM != null) {
                return r0 + e.a.a.b.b.a.h(5, this.hbM);
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
            sw swVar = (sw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    swVar.pHx = aVar3.Avy.ry();
                    return 0;
                case 2:
                    swVar.pHy = aVar3.Avy.readString();
                    return 0;
                case 3:
                    swVar.pHz = aVar3.Avy.readString();
                    return 0;
                case 4:
                    swVar.pHA = aVar3.Avy.ry();
                    return 0;
                case 5:
                    swVar.hbM = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
