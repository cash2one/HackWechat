package com.tencent.mm.protocal.c;

public final class a extends com.tencent.mm.bq.a {
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
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.fDt = aVar3.Avy.ry();
                    return 0;
                case 2:
                    aVar4.fyY = aVar3.Avy.readString();
                    return 0;
                case 3:
                    aVar4.odw = aVar3.Avy.readString();
                    return 0;
                case 4:
                    aVar4.odx = aVar3.Avy.readString();
                    return 0;
                case 5:
                    aVar4.liO = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
