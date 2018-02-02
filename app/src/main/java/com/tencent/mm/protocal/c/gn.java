package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class gn extends bcv {
    public int fCy;
    public String sPk;
    public String vLI;
    public String vLJ;
    public String vLK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vLI != null) {
                aVar.g(2, this.vLI);
            }
            if (this.vLJ != null) {
                aVar.g(3, this.vLJ);
            }
            if (this.sPk != null) {
                aVar.g(4, this.sPk);
            }
            if (this.vLK != null) {
                aVar.g(5, this.vLK);
            }
            aVar.fU(7, this.fCy);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vLI != null) {
                r0 += e.a.a.b.b.a.h(2, this.vLI);
            }
            if (this.vLJ != null) {
                r0 += e.a.a.b.b.a.h(3, this.vLJ);
            }
            if (this.sPk != null) {
                r0 += e.a.a.b.b.a.h(4, this.sPk);
            }
            if (this.vLK != null) {
                r0 += e.a.a.b.b.a.h(5, this.vLK);
            }
            return r0 + e.a.a.a.fR(7, this.fCy);
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
            gn gnVar = (gn) objArr[1];
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
                        gnVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    gnVar.vLI = aVar3.Avy.readString();
                    return 0;
                case 3:
                    gnVar.vLJ = aVar3.Avy.readString();
                    return 0;
                case 4:
                    gnVar.sPk = aVar3.Avy.readString();
                    return 0;
                case 5:
                    gnVar.vLK = aVar3.Avy.readString();
                    return 0;
                case 7:
                    gnVar.fCy = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
