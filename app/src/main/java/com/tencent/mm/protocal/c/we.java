package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class we extends a {
    public int fts;
    public String id;
    public int mFb;
    public String wgC;
    public long wgD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.g(1, this.id);
            }
            aVar.fU(2, this.mFb);
            if (this.wgC != null) {
                aVar.g(3, this.wgC);
            }
            aVar.S(4, this.wgD);
            aVar.fU(5, this.fts);
            return 0;
        } else if (i == 1) {
            if (this.id != null) {
                r0 = e.a.a.b.b.a.h(1, this.id) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.mFb);
            if (this.wgC != null) {
                r0 += e.a.a.b.b.a.h(3, this.wgC);
            }
            return (r0 + e.a.a.a.R(4, this.wgD)) + e.a.a.a.fR(5, this.fts);
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
            we weVar = (we) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    weVar.id = aVar3.Avy.readString();
                    return 0;
                case 2:
                    weVar.mFb = aVar3.Avy.ry();
                    return 0;
                case 3:
                    weVar.wgC = aVar3.Avy.readString();
                    return 0;
                case 4:
                    weVar.wgD = aVar3.Avy.rz();
                    return 0;
                case 5:
                    weVar.fts = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
