package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class kx extends bcv {
    public int fCR;
    public int nZd;
    public int pKd;
    public String pLg;
    public String pLh;
    public String vHq;
    public String vHr;
    public String vTJ;
    public String vTK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vHq != null) {
                aVar.g(2, this.vHq);
            }
            if (this.vHr != null) {
                aVar.g(3, this.vHr);
            }
            aVar.fU(4, this.nZd);
            if (this.pLh != null) {
                aVar.g(5, this.pLh);
            }
            if (this.pLg != null) {
                aVar.g(6, this.pLg);
            }
            aVar.fU(7, this.fCR);
            aVar.fU(8, this.pKd);
            if (this.vTJ != null) {
                aVar.g(9, this.vTJ);
            }
            if (this.vTK == null) {
                return 0;
            }
            aVar.g(10, this.vTK);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vHq != null) {
                r0 += e.a.a.b.b.a.h(2, this.vHq);
            }
            if (this.vHr != null) {
                r0 += e.a.a.b.b.a.h(3, this.vHr);
            }
            r0 += e.a.a.a.fR(4, this.nZd);
            if (this.pLh != null) {
                r0 += e.a.a.b.b.a.h(5, this.pLh);
            }
            if (this.pLg != null) {
                r0 += e.a.a.b.b.a.h(6, this.pLg);
            }
            r0 = (r0 + e.a.a.a.fR(7, this.fCR)) + e.a.a.a.fR(8, this.pKd);
            if (this.vTJ != null) {
                r0 += e.a.a.b.b.a.h(9, this.vTJ);
            }
            if (this.vTK != null) {
                r0 += e.a.a.b.b.a.h(10, this.vTK);
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
            kx kxVar = (kx) objArr[1];
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
                        kxVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    kxVar.vHq = aVar3.Avy.readString();
                    return 0;
                case 3:
                    kxVar.vHr = aVar3.Avy.readString();
                    return 0;
                case 4:
                    kxVar.nZd = aVar3.Avy.ry();
                    return 0;
                case 5:
                    kxVar.pLh = aVar3.Avy.readString();
                    return 0;
                case 6:
                    kxVar.pLg = aVar3.Avy.readString();
                    return 0;
                case 7:
                    kxVar.fCR = aVar3.Avy.ry();
                    return 0;
                case 8:
                    kxVar.pKd = aVar3.Avy.ry();
                    return 0;
                case 9:
                    kxVar.vTJ = aVar3.Avy.readString();
                    return 0;
                case 10:
                    kxVar.vTK = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
