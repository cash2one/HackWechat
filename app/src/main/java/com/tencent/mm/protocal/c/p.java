package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class p extends bcv {
    public String pLr;
    public int scene;
    public String vCW;
    public String vCX;
    public long vDp;
    public String vDr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vCW != null) {
                aVar.g(2, this.vCW);
            }
            aVar.S(3, this.vDp);
            aVar.fU(4, this.scene);
            if (this.vCX != null) {
                aVar.g(5, this.vCX);
            }
            if (this.vDr != null) {
                aVar.g(6, this.vDr);
            }
            if (this.pLr == null) {
                return 0;
            }
            aVar.g(7, this.pLr);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vCW != null) {
                r0 += e.a.a.b.b.a.h(2, this.vCW);
            }
            r0 = (r0 + e.a.a.a.R(3, this.vDp)) + e.a.a.a.fR(4, this.scene);
            if (this.vCX != null) {
                r0 += e.a.a.b.b.a.h(5, this.vCX);
            }
            if (this.vDr != null) {
                r0 += e.a.a.b.b.a.h(6, this.vDr);
            }
            if (this.pLr != null) {
                r0 += e.a.a.b.b.a.h(7, this.pLr);
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
            p pVar = (p) objArr[1];
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
                        pVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    pVar.vCW = aVar3.Avy.readString();
                    return 0;
                case 3:
                    pVar.vDp = aVar3.Avy.rz();
                    return 0;
                case 4:
                    pVar.scene = aVar3.Avy.ry();
                    return 0;
                case 5:
                    pVar.vCX = aVar3.Avy.readString();
                    return 0;
                case 6:
                    pVar.vDr = aVar3.Avy.readString();
                    return 0;
                case 7:
                    pVar.pLr = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
