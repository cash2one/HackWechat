package com.tencent.mm.c;

import com.tencent.mm.bq.a;

public final class b extends a {
    public String apkMd5;
    public int fdS;
    public String fdT;
    public int fdU;
    public String fdV;
    public String fdW;
    public boolean fdX;
    public int fdY;
    public boolean fdZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.apkMd5 == null) {
                throw new e.a.a.b("Not all required fields were included: apkMd5");
            }
            if (this.apkMd5 != null) {
                aVar.g(1, this.apkMd5);
            }
            aVar.fV(2, this.fdS);
            if (this.fdT != null) {
                aVar.g(3, this.fdT);
            }
            aVar.fV(4, this.fdU);
            if (this.fdV != null) {
                aVar.g(5, this.fdV);
            }
            if (this.fdW != null) {
                aVar.g(6, this.fdW);
            }
            aVar.al(7, this.fdX);
            aVar.fV(8, this.fdY);
            aVar.al(9, this.fdZ);
            return 0;
        } else if (i == 1) {
            if (this.apkMd5 != null) {
                r0 = e.a.a.a.h(1, this.apkMd5) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fS(2, this.fdS);
            if (this.fdT != null) {
                r0 += e.a.a.a.h(3, this.fdT);
            }
            r0 += e.a.a.a.fS(4, this.fdU);
            if (this.fdV != null) {
                r0 += e.a.a.a.h(5, this.fdV);
            }
            if (this.fdW != null) {
                r0 += e.a.a.a.h(6, this.fdW);
            }
            return ((r0 + e.a.a.a.Jk(7)) + e.a.a.a.fS(8, this.fdY)) + e.a.a.a.Jk(9);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.apkMd5 != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: apkMd5");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.apkMd5 = aVar3.cJB();
                    return 0;
                case 2:
                    bVar.fdS = aVar3.cJz();
                    return 0;
                case 3:
                    bVar.fdT = aVar3.cJB();
                    return 0;
                case 4:
                    bVar.fdU = aVar3.cJz();
                    return 0;
                case 5:
                    bVar.fdV = aVar3.cJB();
                    return 0;
                case 6:
                    bVar.fdW = aVar3.cJB();
                    return 0;
                case 7:
                    bVar.fdX = aVar3.cJC();
                    return 0;
                case 8:
                    bVar.fdY = aVar3.cJz();
                    return 0;
                case 9:
                    bVar.fdZ = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
