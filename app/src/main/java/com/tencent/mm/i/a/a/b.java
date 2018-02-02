package com.tencent.mm.i.a.a;

import com.tencent.mm.bq.a;

public final class b extends a {
    public String gBL;
    public int gBM;
    public String gBN;
    public String userName;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.userName != null) {
                aVar.g(1, this.userName);
            }
            if (this.gBL != null) {
                aVar.g(2, this.gBL);
            }
            aVar.fU(3, this.gBM);
            if (this.gBN == null) {
                return 0;
            }
            aVar.g(4, this.gBN);
            return 0;
        } else if (i == 1) {
            if (this.userName != null) {
                r0 = e.a.a.b.b.a.h(1, this.userName) + 0;
            } else {
                r0 = 0;
            }
            if (this.gBL != null) {
                r0 += e.a.a.b.b.a.h(2, this.gBL);
            }
            r0 += e.a.a.a.fR(3, this.gBM);
            if (this.gBN != null) {
                r0 += e.a.a.b.b.a.h(4, this.gBN);
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
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.userName = aVar3.Avy.readString();
                    return 0;
                case 2:
                    bVar.gBL = aVar3.Avy.readString();
                    return 0;
                case 3:
                    bVar.gBM = aVar3.Avy.ry();
                    return 0;
                case 4:
                    bVar.gBN = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
