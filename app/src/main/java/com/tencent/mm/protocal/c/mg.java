package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class mg extends bcv {
    public String nBM;
    public String oZz;
    public String vUY;
    public String vUZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vUY != null) {
                aVar.g(2, this.vUY);
            }
            if (this.vUZ != null) {
                aVar.g(3, this.vUZ);
            }
            if (this.nBM != null) {
                aVar.g(4, this.nBM);
            }
            if (this.oZz == null) {
                return 0;
            }
            aVar.g(5, this.oZz);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vUY != null) {
                r0 += e.a.a.b.b.a.h(2, this.vUY);
            }
            if (this.vUZ != null) {
                r0 += e.a.a.b.b.a.h(3, this.vUZ);
            }
            if (this.nBM != null) {
                r0 += e.a.a.b.b.a.h(4, this.nBM);
            }
            if (this.oZz != null) {
                r0 += e.a.a.b.b.a.h(5, this.oZz);
            }
            return r0;
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
            mg mgVar = (mg) objArr[1];
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
                        mgVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    mgVar.vUY = aVar3.Avy.readString();
                    return 0;
                case 3:
                    mgVar.vUZ = aVar3.Avy.readString();
                    return 0;
                case 4:
                    mgVar.nBM = aVar3.Avy.readString();
                    return 0;
                case 5:
                    mgVar.oZz = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
