package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ag extends a {
    public String nfK;
    public int nfP;
    public int nfS;
    public String nfg;
    public cj ngE;
    public eh ngF;
    public cx ngG;
    public cy ngH;
    public bd ngI;
    public dk ngJ;
    public ax ngK;
    public p ngL;
    public dc ngM;
    public dq ngN;
    public o ngO;
    public o ngP;
    public String ngo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.nfS);
            aVar.fU(2, this.nfP);
            if (this.nfK != null) {
                aVar.g(3, this.nfK);
            }
            if (this.ngo != null) {
                aVar.g(4, this.ngo);
            }
            if (this.nfg != null) {
                aVar.g(17, this.nfg);
            }
            if (this.ngE != null) {
                aVar.fW(5, this.ngE.bke());
                this.ngE.a(aVar);
            }
            if (this.ngF != null) {
                aVar.fW(6, this.ngF.bke());
                this.ngF.a(aVar);
            }
            if (this.ngG != null) {
                aVar.fW(7, this.ngG.bke());
                this.ngG.a(aVar);
            }
            if (this.ngH != null) {
                aVar.fW(8, this.ngH.bke());
                this.ngH.a(aVar);
            }
            if (this.ngI != null) {
                aVar.fW(9, this.ngI.bke());
                this.ngI.a(aVar);
            }
            if (this.ngJ != null) {
                aVar.fW(10, this.ngJ.bke());
                this.ngJ.a(aVar);
            }
            if (this.ngK != null) {
                aVar.fW(11, this.ngK.bke());
                this.ngK.a(aVar);
            }
            if (this.ngL != null) {
                aVar.fW(12, this.ngL.bke());
                this.ngL.a(aVar);
            }
            if (this.ngM != null) {
                aVar.fW(13, this.ngM.bke());
                this.ngM.a(aVar);
            }
            if (this.ngN != null) {
                aVar.fW(14, this.ngN.bke());
                this.ngN.a(aVar);
            }
            if (this.ngO != null) {
                aVar.fW(15, this.ngO.bke());
                this.ngO.a(aVar);
            }
            if (this.ngP != null) {
                aVar.fW(16, this.ngP.bke());
                this.ngP.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.fR(1, this.nfS) + 0) + e.a.a.a.fR(2, this.nfP);
            if (this.nfK != null) {
                r0 += e.a.a.b.b.a.h(3, this.nfK);
            }
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(4, this.ngo);
            }
            if (this.nfg != null) {
                r0 += e.a.a.b.b.a.h(17, this.nfg);
            }
            if (this.ngE != null) {
                r0 += e.a.a.a.fT(5, this.ngE.bke());
            }
            if (this.ngF != null) {
                r0 += e.a.a.a.fT(6, this.ngF.bke());
            }
            if (this.ngG != null) {
                r0 += e.a.a.a.fT(7, this.ngG.bke());
            }
            if (this.ngH != null) {
                r0 += e.a.a.a.fT(8, this.ngH.bke());
            }
            if (this.ngI != null) {
                r0 += e.a.a.a.fT(9, this.ngI.bke());
            }
            if (this.ngJ != null) {
                r0 += e.a.a.a.fT(10, this.ngJ.bke());
            }
            if (this.ngK != null) {
                r0 += e.a.a.a.fT(11, this.ngK.bke());
            }
            if (this.ngL != null) {
                r0 += e.a.a.a.fT(12, this.ngL.bke());
            }
            if (this.ngM != null) {
                r0 += e.a.a.a.fT(13, this.ngM.bke());
            }
            if (this.ngN != null) {
                r0 += e.a.a.a.fT(14, this.ngN.bke());
            }
            if (this.ngO != null) {
                r0 += e.a.a.a.fT(15, this.ngO.bke());
            }
            if (this.ngP != null) {
                return r0 + e.a.a.a.fT(16, this.ngP.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ag agVar = (ag) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a cjVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    agVar.nfS = aVar3.Avy.ry();
                    return 0;
                case 2:
                    agVar.nfP = aVar3.Avy.ry();
                    return 0;
                case 3:
                    agVar.nfK = aVar3.Avy.readString();
                    return 0;
                case 4:
                    agVar.ngo = aVar3.Avy.readString();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        cjVar = new cj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.ngE = cjVar;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        cjVar = new eh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.ngF = cjVar;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        cjVar = new cx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.ngG = cjVar;
                    }
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        cjVar = new cy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.ngH = cjVar;
                    }
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        cjVar = new bd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.ngI = cjVar;
                    }
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        cjVar = new dk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.ngJ = cjVar;
                    }
                    return 0;
                case 11:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        cjVar = new ax();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.ngK = cjVar;
                    }
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        cjVar = new p();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.ngL = cjVar;
                    }
                    return 0;
                case 13:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        cjVar = new dc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.ngM = cjVar;
                    }
                    return 0;
                case 14:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        cjVar = new dq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.ngN = cjVar;
                    }
                    return 0;
                case 15:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        cjVar = new o();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.ngO = cjVar;
                    }
                    return 0;
                case 16:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        cjVar = new o();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.ngP = cjVar;
                    }
                    return 0;
                case 17:
                    agVar.nfg = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
