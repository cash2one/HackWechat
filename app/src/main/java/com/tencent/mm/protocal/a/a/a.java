package com.tencent.mm.protocal.a.a;

public final class a extends com.tencent.mm.bq.a {
    public int count;
    public int vCa;
    public int value;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vCa);
            aVar.fU(2, this.value);
            aVar.fU(3, this.count);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.fR(1, this.vCa) + 0) + e.a.a.a.fR(2, this.value)) + e.a.a.a.fR(3, this.count);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = com.tencent.mm.bq.a.a(aVar2); a > 0; a = com.tencent.mm.bq.a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
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
                        aVar4.vCa = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        aVar4.value = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        aVar4.count = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
