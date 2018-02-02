package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class xh extends bdf {
    public String SSID;
    public String fon;
    public String ksU;
    public String nGK;
    public String nje;
    public String vDT;
    public int vEe;
    public bdn whJ;
    public String whK;
    public String whL;
    public alz whM;
    public xd whN;
    public String whO;
    public int whP;
    public LinkedList<ie> whQ = new LinkedList();
    public String whR;
    public pt whS;
    public bdn whT;
    public int whU;
    public LinkedList<akj> whV = new LinkedList();
    public String whW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            if (this.whK != null) {
                aVar.g(2, this.whK);
            }
            if (this.whL != null) {
                aVar.g(3, this.whL);
            }
            aVar.fU(4, this.vEe);
            if (this.fon != null) {
                aVar.g(5, this.fon);
            }
            if (this.nje != null) {
                aVar.g(6, this.nje);
            }
            if (this.whM != null) {
                aVar.fW(7, this.whM.bke());
                this.whM.a(aVar);
            }
            if (this.whN != null) {
                aVar.fW(8, this.whN.bke());
                this.whN.a(aVar);
            }
            if (this.ksU != null) {
                aVar.g(9, this.ksU);
            }
            if (this.whO != null) {
                aVar.g(15, this.whO);
            }
            aVar.fU(16, this.whP);
            aVar.d(17, 8, this.whQ);
            if (this.whR != null) {
                aVar.g(18, this.whR);
            }
            if (this.SSID != null) {
                aVar.g(20, this.SSID);
            }
            if (this.vDT != null) {
                aVar.g(21, this.vDT);
            }
            if (this.whS != null) {
                aVar.fW(22, this.whS.bke());
                this.whS.a(aVar);
            }
            if (this.whT != null) {
                aVar.fW(23, this.whT.bke());
                this.whT.a(aVar);
            }
            aVar.fU(24, this.whU);
            aVar.d(25, 8, this.whV);
            if (this.nGK != null) {
                aVar.g(26, this.nGK);
            }
            if (this.whW != null) {
                aVar.g(27, this.whW);
            }
            if (this.whJ == null) {
                return 0;
            }
            aVar.fW(28, this.whJ.bke());
            this.whJ.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.whK != null) {
                r0 += e.a.a.b.b.a.h(2, this.whK);
            }
            if (this.whL != null) {
                r0 += e.a.a.b.b.a.h(3, this.whL);
            }
            r0 += e.a.a.a.fR(4, this.vEe);
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(5, this.fon);
            }
            if (this.nje != null) {
                r0 += e.a.a.b.b.a.h(6, this.nje);
            }
            if (this.whM != null) {
                r0 += e.a.a.a.fT(7, this.whM.bke());
            }
            if (this.whN != null) {
                r0 += e.a.a.a.fT(8, this.whN.bke());
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(9, this.ksU);
            }
            if (this.whO != null) {
                r0 += e.a.a.b.b.a.h(15, this.whO);
            }
            r0 = (r0 + e.a.a.a.fR(16, this.whP)) + e.a.a.a.c(17, 8, this.whQ);
            if (this.whR != null) {
                r0 += e.a.a.b.b.a.h(18, this.whR);
            }
            if (this.SSID != null) {
                r0 += e.a.a.b.b.a.h(20, this.SSID);
            }
            if (this.vDT != null) {
                r0 += e.a.a.b.b.a.h(21, this.vDT);
            }
            if (this.whS != null) {
                r0 += e.a.a.a.fT(22, this.whS.bke());
            }
            if (this.whT != null) {
                r0 += e.a.a.a.fT(23, this.whT.bke());
            }
            r0 = (r0 + e.a.a.a.fR(24, this.whU)) + e.a.a.a.c(25, 8, this.whV);
            if (this.nGK != null) {
                r0 += e.a.a.b.b.a.h(26, this.nGK);
            }
            if (this.whW != null) {
                r0 += e.a.a.b.b.a.h(27, this.whW);
            }
            if (this.whJ != null) {
                r0 += e.a.a.a.fT(28, this.whJ.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.whQ.clear();
            this.whV.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            xh xhVar = (xh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        xhVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    xhVar.whK = aVar3.Avy.readString();
                    return 0;
                case 3:
                    xhVar.whL = aVar3.Avy.readString();
                    return 0;
                case 4:
                    xhVar.vEe = aVar3.Avy.ry();
                    return 0;
                case 5:
                    xhVar.fon = aVar3.Avy.readString();
                    return 0;
                case 6:
                    xhVar.nje = aVar3.Avy.readString();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new alz();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        xhVar.whM = feVar;
                    }
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new xd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        xhVar.whN = feVar;
                    }
                    return 0;
                case 9:
                    xhVar.ksU = aVar3.Avy.readString();
                    return 0;
                case 15:
                    xhVar.whO = aVar3.Avy.readString();
                    return 0;
                case 16:
                    xhVar.whP = aVar3.Avy.ry();
                    return 0;
                case 17:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new ie();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        xhVar.whQ.add(feVar);
                    }
                    return 0;
                case 18:
                    xhVar.whR = aVar3.Avy.readString();
                    return 0;
                case 20:
                    xhVar.SSID = aVar3.Avy.readString();
                    return 0;
                case 21:
                    xhVar.vDT = aVar3.Avy.readString();
                    return 0;
                case 22:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new pt();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        xhVar.whS = feVar;
                    }
                    return 0;
                case 23:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        xhVar.whT = feVar;
                    }
                    return 0;
                case 24:
                    xhVar.whU = aVar3.Avy.ry();
                    return 0;
                case 25:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new akj();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        xhVar.whV.add(feVar);
                    }
                    return 0;
                case 26:
                    xhVar.nGK = aVar3.Avy.readString();
                    return 0;
                case 27:
                    xhVar.whW = aVar3.Avy.readString();
                    return 0;
                case 28:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        xhVar.whJ = feVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
