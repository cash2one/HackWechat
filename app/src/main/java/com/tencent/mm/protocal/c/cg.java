package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class cg extends a {
    public int fDt;
    public String fyY;
    public String liO;
    public String odw;
    public String odx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.fDt);
            if (this.fyY != null) {
                aVar.g(2, this.fyY);
            }
            if (this.odw != null) {
                aVar.g(3, this.odw);
            }
            if (this.odx != null) {
                aVar.g(4, this.odx);
            }
            if (this.liO != null) {
                aVar.g(5, this.liO);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.fDt) + 0;
            if (this.fyY != null) {
                r0 += e.a.a.b.b.a.h(2, this.fyY);
            }
            if (this.odw != null) {
                r0 += e.a.a.b.b.a.h(3, this.odw);
            }
            if (this.odx != null) {
                r0 += e.a.a.b.b.a.h(4, this.odx);
            }
            if (this.liO != null) {
                return r0 + e.a.a.b.b.a.h(5, this.liO);
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
            cg cgVar = (cg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cgVar.fDt = aVar3.Avy.ry();
                    return 0;
                case 2:
                    cgVar.fyY = aVar3.Avy.readString();
                    return 0;
                case 3:
                    cgVar.odw = aVar3.Avy.readString();
                    return 0;
                case 4:
                    cgVar.odx = aVar3.Avy.readString();
                    return 0;
                case 5:
                    cgVar.liO = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
