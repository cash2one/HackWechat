package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class sh extends a {
    public String nfT;
    public int vLh;
    public String wal;
    public String wam;
    public int wan;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wam != null) {
                aVar.g(1, this.wam);
            }
            aVar.fU(2, this.vLh);
            aVar.fU(3, this.wan);
            if (this.nfT != null) {
                aVar.g(4, this.nfT);
            }
            if (this.wal == null) {
                return 0;
            }
            aVar.g(5, this.wal);
            return 0;
        } else if (i == 1) {
            if (this.wam != null) {
                r0 = e.a.a.b.b.a.h(1, this.wam) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.vLh)) + e.a.a.a.fR(3, this.wan);
            if (this.nfT != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfT);
            }
            if (this.wal != null) {
                r0 += e.a.a.b.b.a.h(5, this.wal);
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
            sh shVar = (sh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    shVar.wam = aVar3.Avy.readString();
                    return 0;
                case 2:
                    shVar.vLh = aVar3.Avy.ry();
                    return 0;
                case 3:
                    shVar.wan = aVar3.Avy.ry();
                    return 0;
                case 4:
                    shVar.nfT = aVar3.Avy.readString();
                    return 0;
                case 5:
                    shVar.wal = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
