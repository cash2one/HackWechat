package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class ub extends bcv {
    public double latitude;
    public int liB;
    public double longitude;
    public int obK;
    public int pgd;
    public int wca;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.liB);
            aVar.fU(3, this.pgd);
            aVar.fU(4, this.obK);
            aVar.fU(5, this.wca);
            aVar.b(6, this.latitude);
            aVar.b(7, this.longitude);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            return (((((r0 + e.a.a.a.fR(2, this.liB)) + e.a.a.a.fR(3, this.pgd)) + e.a.a.a.fR(4, this.obK)) + e.a.a.a.fR(5, this.wca)) + (e.a.a.b.b.a.dX(6) + 8)) + (e.a.a.b.b.a.dX(7) + 8);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ub ubVar = (ub) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        ubVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    ubVar.liB = aVar3.Avy.ry();
                    return 0;
                case 3:
                    ubVar.pgd = aVar3.Avy.ry();
                    return 0;
                case 4:
                    ubVar.obK = aVar3.Avy.ry();
                    return 0;
                case 5:
                    ubVar.wca = aVar3.Avy.ry();
                    return 0;
                case 6:
                    ubVar.latitude = aVar3.Avy.readDouble();
                    return 0;
                case 7:
                    ubVar.longitude = aVar3.Avy.readDouble();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
