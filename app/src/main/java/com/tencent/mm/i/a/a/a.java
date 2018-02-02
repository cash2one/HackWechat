package com.tencent.mm.i.a.a;

import java.util.LinkedList;

public final class a extends com.tencent.mm.bq.a {
    public int fAZ;
    public int fDt;
    public LinkedList<b> gBH = new LinkedList();
    public int gBI;
    public String gBJ;
    public int gBK;
    public int status;
    public int type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.gBH);
            aVar.fU(2, this.fDt);
            aVar.fU(3, this.type);
            aVar.fU(4, this.status);
            aVar.fU(5, this.gBI);
            if (this.gBJ != null) {
                aVar.g(6, this.gBJ);
            }
            aVar.fU(7, this.fAZ);
            aVar.fU(8, this.gBK);
            return 0;
        } else if (i == 1) {
            r0 = ((((e.a.a.a.c(1, 8, this.gBH) + 0) + e.a.a.a.fR(2, this.fDt)) + e.a.a.a.fR(3, this.type)) + e.a.a.a.fR(4, this.status)) + e.a.a.a.fR(5, this.gBI);
            if (this.gBJ != null) {
                r0 += e.a.a.b.b.a.h(6, this.gBJ);
            }
            return (r0 + e.a.a.a.fR(7, this.fAZ)) + e.a.a.a.fR(8, this.gBK);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.gBH.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
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
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a bVar = new b();
                        e.a.a.a.a aVar5 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = bVar.a(aVar5, bVar, com.tencent.mm.bq.a.a(aVar5))) {
                        }
                        aVar4.gBH.add(bVar);
                    }
                    return 0;
                case 2:
                    aVar4.fDt = aVar3.Avy.ry();
                    return 0;
                case 3:
                    aVar4.type = aVar3.Avy.ry();
                    return 0;
                case 4:
                    aVar4.status = aVar3.Avy.ry();
                    return 0;
                case 5:
                    aVar4.gBI = aVar3.Avy.ry();
                    return 0;
                case 6:
                    aVar4.gBJ = aVar3.Avy.readString();
                    return 0;
                case 7:
                    aVar4.fAZ = aVar3.Avy.ry();
                    return 0;
                case 8:
                    aVar4.gBK = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
