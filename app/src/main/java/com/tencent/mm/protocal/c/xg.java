package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class xg extends bcv {
    public String ksU;
    public int rYW;
    public int vDW;
    public int vGN;
    public bdn vJi;
    public int vVn;
    public int vVo;
    public int whA;
    public String whB;
    public bdn whC;
    public int whD;
    public int whE;
    public String whF;
    public int whG;
    public String whH;
    public int whI;
    public bdn whJ;
    public bdo whv;
    public bdo whw;
    public bdo whx;
    public bdo why;
    public String whz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.vDW);
            if (this.vJi != null) {
                aVar.fW(3, this.vJi.bke());
                this.vJi.a(aVar);
            }
            if (this.whv != null) {
                aVar.fW(4, this.whv.bke());
                this.whv.a(aVar);
            }
            if (this.whw != null) {
                aVar.fW(5, this.whw.bke());
                this.whw.a(aVar);
            }
            if (this.whx != null) {
                aVar.fW(6, this.whx.bke());
                this.whx.a(aVar);
            }
            if (this.why != null) {
                aVar.fW(7, this.why.bke());
                this.why.a(aVar);
            }
            if (this.whz != null) {
                aVar.g(8, this.whz);
            }
            aVar.fU(9, this.whA);
            aVar.fU(10, this.rYW);
            if (this.ksU != null) {
                aVar.g(11, this.ksU);
            }
            if (this.whB != null) {
                aVar.g(12, this.whB);
            }
            if (this.whC != null) {
                aVar.fW(13, this.whC.bke());
                this.whC.a(aVar);
            }
            aVar.fU(14, this.whD);
            aVar.fU(15, this.whE);
            aVar.fU(16, this.vGN);
            if (this.whF != null) {
                aVar.g(17, this.whF);
            }
            aVar.fU(18, this.vVn);
            aVar.fU(19, this.vVo);
            aVar.fU(20, this.whG);
            if (this.whH != null) {
                aVar.g(21, this.whH);
            }
            aVar.fU(22, this.whI);
            if (this.whJ == null) {
                return 0;
            }
            aVar.fW(23, this.whJ.bke());
            this.whJ.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.vDW);
            if (this.vJi != null) {
                r0 += e.a.a.a.fT(3, this.vJi.bke());
            }
            if (this.whv != null) {
                r0 += e.a.a.a.fT(4, this.whv.bke());
            }
            if (this.whw != null) {
                r0 += e.a.a.a.fT(5, this.whw.bke());
            }
            if (this.whx != null) {
                r0 += e.a.a.a.fT(6, this.whx.bke());
            }
            if (this.why != null) {
                r0 += e.a.a.a.fT(7, this.why.bke());
            }
            if (this.whz != null) {
                r0 += e.a.a.b.b.a.h(8, this.whz);
            }
            r0 = (r0 + e.a.a.a.fR(9, this.whA)) + e.a.a.a.fR(10, this.rYW);
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(11, this.ksU);
            }
            if (this.whB != null) {
                r0 += e.a.a.b.b.a.h(12, this.whB);
            }
            if (this.whC != null) {
                r0 += e.a.a.a.fT(13, this.whC.bke());
            }
            r0 = ((r0 + e.a.a.a.fR(14, this.whD)) + e.a.a.a.fR(15, this.whE)) + e.a.a.a.fR(16, this.vGN);
            if (this.whF != null) {
                r0 += e.a.a.b.b.a.h(17, this.whF);
            }
            r0 = ((r0 + e.a.a.a.fR(18, this.vVn)) + e.a.a.a.fR(19, this.vVo)) + e.a.a.a.fR(20, this.whG);
            if (this.whH != null) {
                r0 += e.a.a.b.b.a.h(21, this.whH);
            }
            r0 += e.a.a.a.fR(22, this.whI);
            if (this.whJ != null) {
                r0 += e.a.a.a.fT(23, this.whJ.bke());
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
            xg xgVar = (xg) objArr[1];
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
                        xgVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    xgVar.vDW = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        xgVar.vJi = fdVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        xgVar.whv = fdVar;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        xgVar.whw = fdVar;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        xgVar.whx = fdVar;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        xgVar.why = fdVar;
                    }
                    return 0;
                case 8:
                    xgVar.whz = aVar3.Avy.readString();
                    return 0;
                case 9:
                    xgVar.whA = aVar3.Avy.ry();
                    return 0;
                case 10:
                    xgVar.rYW = aVar3.Avy.ry();
                    return 0;
                case 11:
                    xgVar.ksU = aVar3.Avy.readString();
                    return 0;
                case 12:
                    xgVar.whB = aVar3.Avy.readString();
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
                        xgVar.whC = fdVar;
                    }
                    return 0;
                case 14:
                    xgVar.whD = aVar3.Avy.ry();
                    return 0;
                case 15:
                    xgVar.whE = aVar3.Avy.ry();
                    return 0;
                case 16:
                    xgVar.vGN = aVar3.Avy.ry();
                    return 0;
                case 17:
                    xgVar.whF = aVar3.Avy.readString();
                    return 0;
                case 18:
                    xgVar.vVn = aVar3.Avy.ry();
                    return 0;
                case 19:
                    xgVar.vVo = aVar3.Avy.ry();
                    return 0;
                case 20:
                    xgVar.whG = aVar3.Avy.ry();
                    return 0;
                case 21:
                    xgVar.whH = aVar3.Avy.readString();
                    return 0;
                case 22:
                    xgVar.whI = aVar3.Avy.ry();
                    return 0;
                case 23:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        xgVar.whJ = fdVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
