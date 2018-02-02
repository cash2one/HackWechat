package com.tencent.mm.plugin.luckymoney.b;

public final class a extends com.tencent.mm.bq.a {
    public int gEx;
    public String obv;
    public String obw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.gEx);
            if (this.obv != null) {
                aVar.g(2, this.obv);
            }
            if (this.obw != null) {
                aVar.g(3, this.obw);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.gEx) + 0;
            if (this.obv != null) {
                r0 += e.a.a.b.b.a.h(2, this.obv);
            }
            if (this.obw != null) {
                return r0 + e.a.a.b.b.a.h(3, this.obw);
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
                    aVar4.gEx = aVar3.Avy.ry();
                    return 0;
                case 2:
                    aVar4.obv = aVar3.Avy.readString();
                    return 0;
                case 3:
                    aVar4.obw = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
