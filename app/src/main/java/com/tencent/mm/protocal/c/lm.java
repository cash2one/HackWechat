package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class lm extends bcv {
    public String fwY;
    public int nZd;
    public String vHr;
    public String vUk;
    public String vUl;
    public String vUn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.fwY != null) {
                aVar.g(2, this.fwY);
            }
            if (this.vUn != null) {
                aVar.g(3, this.vUn);
            }
            if (this.vHr != null) {
                aVar.g(4, this.vHr);
            }
            aVar.fU(5, this.nZd);
            if (this.vUl != null) {
                aVar.g(6, this.vUl);
            }
            if (this.vUk == null) {
                return 0;
            }
            aVar.g(7, this.vUk);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fwY != null) {
                r0 += e.a.a.b.b.a.h(2, this.fwY);
            }
            if (this.vUn != null) {
                r0 += e.a.a.b.b.a.h(3, this.vUn);
            }
            if (this.vHr != null) {
                r0 += e.a.a.b.b.a.h(4, this.vHr);
            }
            r0 += e.a.a.a.fR(5, this.nZd);
            if (this.vUl != null) {
                r0 += e.a.a.b.b.a.h(6, this.vUl);
            }
            if (this.vUk != null) {
                r0 += e.a.a.b.b.a.h(7, this.vUk);
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
            lm lmVar = (lm) objArr[1];
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
                        lmVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    lmVar.fwY = aVar3.Avy.readString();
                    return 0;
                case 3:
                    lmVar.vUn = aVar3.Avy.readString();
                    return 0;
                case 4:
                    lmVar.vHr = aVar3.Avy.readString();
                    return 0;
                case 5:
                    lmVar.nZd = aVar3.Avy.ry();
                    return 0;
                case 6:
                    lmVar.vUl = aVar3.Avy.readString();
                    return 0;
                case 7:
                    lmVar.vUk = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
