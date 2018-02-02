package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class ip extends bcv {
    public int fCR;
    public int nZd;
    public int pKd;
    public String pKe;
    public String pKf;
    public String pLk;
    public String pLn;
    public String vHu;
    public String vOS;
    public int vOT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.nZd);
            aVar.fU(3, this.fCR);
            aVar.fU(4, this.pKd);
            if (this.vOS != null) {
                aVar.g(5, this.vOS);
            }
            if (this.pLk != null) {
                aVar.g(6, this.pLk);
            }
            if (this.pKe != null) {
                aVar.g(7, this.pKe);
            }
            if (this.pLn != null) {
                aVar.g(8, this.pLn);
            }
            if (this.vHu != null) {
                aVar.g(9, this.vHu);
            }
            if (this.pKf != null) {
                aVar.g(10, this.pKf);
            }
            aVar.fU(11, this.vOT);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + e.a.a.a.fR(2, this.nZd)) + e.a.a.a.fR(3, this.fCR)) + e.a.a.a.fR(4, this.pKd);
            if (this.vOS != null) {
                r0 += e.a.a.b.b.a.h(5, this.vOS);
            }
            if (this.pLk != null) {
                r0 += e.a.a.b.b.a.h(6, this.pLk);
            }
            if (this.pKe != null) {
                r0 += e.a.a.b.b.a.h(7, this.pKe);
            }
            if (this.pLn != null) {
                r0 += e.a.a.b.b.a.h(8, this.pLn);
            }
            if (this.vHu != null) {
                r0 += e.a.a.b.b.a.h(9, this.vHu);
            }
            if (this.pKf != null) {
                r0 += e.a.a.b.b.a.h(10, this.pKf);
            }
            return r0 + e.a.a.a.fR(11, this.vOT);
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
            ip ipVar = (ip) objArr[1];
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
                        ipVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    ipVar.nZd = aVar3.Avy.ry();
                    return 0;
                case 3:
                    ipVar.fCR = aVar3.Avy.ry();
                    return 0;
                case 4:
                    ipVar.pKd = aVar3.Avy.ry();
                    return 0;
                case 5:
                    ipVar.vOS = aVar3.Avy.readString();
                    return 0;
                case 6:
                    ipVar.pLk = aVar3.Avy.readString();
                    return 0;
                case 7:
                    ipVar.pKe = aVar3.Avy.readString();
                    return 0;
                case 8:
                    ipVar.pLn = aVar3.Avy.readString();
                    return 0;
                case 9:
                    ipVar.vHu = aVar3.Avy.readString();
                    return 0;
                case 10:
                    ipVar.pKf = aVar3.Avy.readString();
                    return 0;
                case 11:
                    ipVar.vOT = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
