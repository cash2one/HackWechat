package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class ik extends a {
    public int port;
    public int type;
    public b vOE;
    public b vOF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.type);
            aVar.fU(2, this.port);
            if (this.vOE != null) {
                aVar.b(3, this.vOE);
            }
            if (this.vOF != null) {
                aVar.b(4, this.vOF);
            }
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.fR(1, this.type) + 0) + e.a.a.a.fR(2, this.port);
            if (this.vOE != null) {
                r0 += e.a.a.a.a(3, this.vOE);
            }
            if (this.vOF != null) {
                return r0 + e.a.a.a.a(4, this.vOF);
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
            ik ikVar = (ik) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ikVar.type = aVar3.Avy.ry();
                    return 0;
                case 2:
                    ikVar.port = aVar3.Avy.ry();
                    return 0;
                case 3:
                    ikVar.vOE = aVar3.cJD();
                    return 0;
                case 4:
                    ikVar.vOF = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
