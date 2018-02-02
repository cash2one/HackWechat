package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class if extends bcv {
    public int vDY;
    public String vDZ;
    public String vNg;
    public aoz vOq;
    public bdx vOr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vNg != null) {
                aVar.g(2, this.vNg);
            }
            if (this.vOq != null) {
                aVar.fW(3, this.vOq.bke());
                this.vOq.a(aVar);
            }
            if (this.vOr != null) {
                aVar.fW(4, this.vOr.bke());
                this.vOr.a(aVar);
            }
            aVar.fU(5, this.vDY);
            if (this.vDZ == null) {
                return 0;
            }
            aVar.g(6, this.vDZ);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vNg != null) {
                r0 += e.a.a.b.b.a.h(2, this.vNg);
            }
            if (this.vOq != null) {
                r0 += e.a.a.a.fT(3, this.vOq.bke());
            }
            if (this.vOr != null) {
                r0 += e.a.a.a.fT(4, this.vOr.bke());
            }
            r0 += e.a.a.a.fR(5, this.vDY);
            if (this.vDZ != null) {
                r0 += e.a.a.b.b.a.h(6, this.vDZ);
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
            if ifVar = (if) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        ifVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    ifVar.vNg = aVar3.Avy.readString();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new aoz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        ifVar.vOq = fdVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        ifVar.vOr = fdVar;
                    }
                    return 0;
                case 5:
                    ifVar.vDY = aVar3.Avy.ry();
                    return 0;
                case 6:
                    ifVar.vDZ = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
