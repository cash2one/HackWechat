package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bs extends bcv {
    public int ktN;
    public String vGQ;
    public int vGR;
    public String vGS;
    public String vGT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vGQ != null) {
                aVar.g(2, this.vGQ);
            }
            aVar.fU(3, this.ktN);
            aVar.fU(4, this.vGR);
            if (this.vGS != null) {
                aVar.g(5, this.vGS);
            }
            if (this.vGT == null) {
                return 0;
            }
            aVar.g(6, this.vGT);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vGQ != null) {
                r0 += e.a.a.b.b.a.h(2, this.vGQ);
            }
            r0 = (r0 + e.a.a.a.fR(3, this.ktN)) + e.a.a.a.fR(4, this.vGR);
            if (this.vGS != null) {
                r0 += e.a.a.b.b.a.h(5, this.vGS);
            }
            if (this.vGT != null) {
                r0 += e.a.a.b.b.a.h(6, this.vGT);
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
            bs bsVar = (bs) objArr[1];
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
                        bsVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    bsVar.vGQ = aVar3.Avy.readString();
                    return 0;
                case 3:
                    bsVar.ktN = aVar3.Avy.ry();
                    return 0;
                case 4:
                    bsVar.vGR = aVar3.Avy.ry();
                    return 0;
                case 5:
                    bsVar.vGS = aVar3.Avy.readString();
                    return 0;
                case 6:
                    bsVar.vGT = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
