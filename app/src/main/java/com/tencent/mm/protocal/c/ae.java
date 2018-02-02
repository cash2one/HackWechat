package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ae extends a {
    public String vEv;
    public int vEw;
    public int vEx;
    public int vEy;
    public int vEz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vEv != null) {
                aVar.g(1, this.vEv);
            }
            aVar.fU(2, this.vEw);
            aVar.fU(3, this.vEx);
            aVar.fU(4, this.vEy);
            aVar.fU(5, this.vEz);
            return 0;
        } else if (i == 1) {
            if (this.vEv != null) {
                r0 = e.a.a.b.b.a.h(1, this.vEv) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + e.a.a.a.fR(2, this.vEw)) + e.a.a.a.fR(3, this.vEx)) + e.a.a.a.fR(4, this.vEy)) + e.a.a.a.fR(5, this.vEz);
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
            ae aeVar = (ae) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aeVar.vEv = aVar3.Avy.readString();
                    return 0;
                case 2:
                    aeVar.vEw = aVar3.Avy.ry();
                    return 0;
                case 3:
                    aeVar.vEx = aVar3.Avy.ry();
                    return 0;
                case 4:
                    aeVar.vEy = aVar3.Avy.ry();
                    return 0;
                case 5:
                    aeVar.vEz = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
