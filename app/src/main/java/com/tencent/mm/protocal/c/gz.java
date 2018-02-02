package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class gz extends bcv {
    public bdn vKR;
    public int vMA;
    public String vMB;
    public String vMC;
    public String vMD;
    public int vME;
    public bdo vMF;
    public bdn vMG;
    public int vMH;
    public String vMg;
    public String vMh;
    public String vMp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.vMA);
            if (this.vMp != null) {
                aVar.g(3, this.vMp);
            }
            if (this.vMB != null) {
                aVar.g(4, this.vMB);
            }
            if (this.vMC != null) {
                aVar.g(5, this.vMC);
            }
            if (this.vMD != null) {
                aVar.g(6, this.vMD);
            }
            aVar.fU(7, this.vME);
            if (this.vMF != null) {
                aVar.fW(8, this.vMF.bke());
                this.vMF.a(aVar);
            }
            if (this.vMG != null) {
                aVar.fW(9, this.vMG.bke());
                this.vMG.a(aVar);
            }
            aVar.fU(10, this.vMH);
            if (this.vMg != null) {
                aVar.g(11, this.vMg);
            }
            if (this.vMh != null) {
                aVar.g(12, this.vMh);
            }
            if (this.vKR == null) {
                return 0;
            }
            aVar.fW(13, this.vKR.bke());
            this.vKR.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.vMA);
            if (this.vMp != null) {
                r0 += e.a.a.b.b.a.h(3, this.vMp);
            }
            if (this.vMB != null) {
                r0 += e.a.a.b.b.a.h(4, this.vMB);
            }
            if (this.vMC != null) {
                r0 += e.a.a.b.b.a.h(5, this.vMC);
            }
            if (this.vMD != null) {
                r0 += e.a.a.b.b.a.h(6, this.vMD);
            }
            r0 += e.a.a.a.fR(7, this.vME);
            if (this.vMF != null) {
                r0 += e.a.a.a.fT(8, this.vMF.bke());
            }
            if (this.vMG != null) {
                r0 += e.a.a.a.fT(9, this.vMG.bke());
            }
            r0 += e.a.a.a.fR(10, this.vMH);
            if (this.vMg != null) {
                r0 += e.a.a.b.b.a.h(11, this.vMg);
            }
            if (this.vMh != null) {
                r0 += e.a.a.b.b.a.h(12, this.vMh);
            }
            if (this.vKR != null) {
                r0 += e.a.a.a.fT(13, this.vKR.bke());
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
            gz gzVar = (gz) objArr[1];
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
                        gzVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    gzVar.vMA = aVar3.Avy.ry();
                    return 0;
                case 3:
                    gzVar.vMp = aVar3.Avy.readString();
                    return 0;
                case 4:
                    gzVar.vMB = aVar3.Avy.readString();
                    return 0;
                case 5:
                    gzVar.vMC = aVar3.Avy.readString();
                    return 0;
                case 6:
                    gzVar.vMD = aVar3.Avy.readString();
                    return 0;
                case 7:
                    gzVar.vME = aVar3.Avy.ry();
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        gzVar.vMF = fdVar;
                    }
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        gzVar.vMG = fdVar;
                    }
                    return 0;
                case 10:
                    gzVar.vMH = aVar3.Avy.ry();
                    return 0;
                case 11:
                    gzVar.vMg = aVar3.Avy.readString();
                    return 0;
                case 12:
                    gzVar.vMh = aVar3.Avy.readString();
                    return 0;
                case 13:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        gzVar.vKR = fdVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
