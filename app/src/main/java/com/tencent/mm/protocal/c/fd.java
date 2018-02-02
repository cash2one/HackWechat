package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class fd extends a {
    public int lOd;
    public int rYW;
    public b vKY;
    public b vKZ;
    public int vLa;
    public b vLb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vKY != null) {
                aVar.b(1, this.vKY);
            }
            aVar.fU(2, this.lOd);
            if (this.vKZ != null) {
                aVar.b(3, this.vKZ);
            }
            aVar.fU(4, this.vLa);
            if (this.vLb != null) {
                aVar.b(5, this.vLb);
            }
            aVar.fU(6, this.rYW);
            return 0;
        } else if (i == 1) {
            if (this.vKY != null) {
                r0 = e.a.a.a.a(1, this.vKY) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.lOd);
            if (this.vKZ != null) {
                r0 += e.a.a.a.a(3, this.vKZ);
            }
            r0 += e.a.a.a.fR(4, this.vLa);
            if (this.vLb != null) {
                r0 += e.a.a.a.a(5, this.vLb);
            }
            return r0 + e.a.a.a.fR(6, this.rYW);
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
            fd fdVar = (fd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fdVar.vKY = aVar3.cJD();
                    return 0;
                case 2:
                    fdVar.lOd = aVar3.Avy.ry();
                    return 0;
                case 3:
                    fdVar.vKZ = aVar3.cJD();
                    return 0;
                case 4:
                    fdVar.vLa = aVar3.Avy.ry();
                    return 0;
                case 5:
                    fdVar.vLb = aVar3.cJD();
                    return 0;
                case 6:
                    fdVar.rYW = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
