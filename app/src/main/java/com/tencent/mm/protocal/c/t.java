package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class t extends a {
    public long vDf;
    public String vDs;
    public long vDt;
    public int vDu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vDs != null) {
                aVar.g(1, this.vDs);
            }
            aVar.S(2, this.vDf);
            aVar.S(3, this.vDt);
            aVar.fU(4, this.vDu);
            return 0;
        } else if (i == 1) {
            if (this.vDs != null) {
                r0 = e.a.a.b.b.a.h(1, this.vDs) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + e.a.a.a.R(2, this.vDf)) + e.a.a.a.R(3, this.vDt)) + e.a.a.a.fR(4, this.vDu);
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
            t tVar = (t) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tVar.vDs = aVar3.Avy.readString();
                    return 0;
                case 2:
                    tVar.vDf = aVar3.Avy.rz();
                    return 0;
                case 3:
                    tVar.vDt = aVar3.Avy.rz();
                    return 0;
                case 4:
                    tVar.vDu = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
