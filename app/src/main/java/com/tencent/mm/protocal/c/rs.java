package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class rs extends a {
    public boolean vZD;
    public boolean vZE;
    public String vZF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.al(1, this.vZD);
            aVar.al(2, this.vZE);
            if (this.vZF != null) {
                aVar.g(3, this.vZF);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((e.a.a.b.b.a.dX(1) + 1) + 0) + (e.a.a.b.b.a.dX(2) + 1);
            if (this.vZF != null) {
                return r0 + e.a.a.b.b.a.h(3, this.vZF);
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
            rs rsVar = (rs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rsVar.vZD = aVar3.cJC();
                    return 0;
                case 2:
                    rsVar.vZE = aVar3.cJC();
                    return 0;
                case 3:
                    rsVar.vZF = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
