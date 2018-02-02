package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class li extends bcv {
    public String ljh;
    public int nZd;
    public b vTQ;
    public b vTR;
    public int vTS = 4;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.nZd);
            if (this.vTQ != null) {
                aVar.b(3, this.vTQ);
            }
            if (this.vTR != null) {
                aVar.b(4, this.vTR);
            }
            if (this.ljh != null) {
                aVar.g(5, this.ljh);
            }
            aVar.fU(6, this.vTS);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.nZd);
            if (this.vTQ != null) {
                r0 += e.a.a.a.a(3, this.vTQ);
            }
            if (this.vTR != null) {
                r0 += e.a.a.a.a(4, this.vTR);
            }
            if (this.ljh != null) {
                r0 += e.a.a.b.b.a.h(5, this.ljh);
            }
            return r0 + e.a.a.a.fR(6, this.vTS);
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
            li liVar = (li) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        liVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    liVar.nZd = aVar3.Avy.ry();
                    return 0;
                case 3:
                    liVar.vTQ = aVar3.cJD();
                    return 0;
                case 4:
                    liVar.vTR = aVar3.cJD();
                    return 0;
                case 5:
                    liVar.ljh = aVar3.Avy.readString();
                    return 0;
                case 6:
                    liVar.vTS = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
