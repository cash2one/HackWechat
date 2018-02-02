package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class at extends a {
    public int ktN;
    public String nfX;
    public int rYW;
    public String vFF;
    public String vFG;
    public String vFH;
    public ar vFI;
    public String vFJ;
    public cp vFK;
    public cw vFL;
    public cv vFM;
    public cv vFN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.ktN);
            if (this.nfX != null) {
                aVar.g(2, this.nfX);
            }
            aVar.fU(3, this.rYW);
            if (this.vFF != null) {
                aVar.g(4, this.vFF);
            }
            if (this.vFG != null) {
                aVar.g(5, this.vFG);
            }
            if (this.vFH != null) {
                aVar.g(6, this.vFH);
            }
            if (this.vFI != null) {
                aVar.fW(7, this.vFI.bke());
                this.vFI.a(aVar);
            }
            if (this.vFJ != null) {
                aVar.g(8, this.vFJ);
            }
            if (this.vFK != null) {
                aVar.fW(9, this.vFK.bke());
                this.vFK.a(aVar);
            }
            if (this.vFL != null) {
                aVar.fW(10, this.vFL.bke());
                this.vFL.a(aVar);
            }
            if (this.vFM != null) {
                aVar.fW(11, this.vFM.bke());
                this.vFM.a(aVar);
            }
            if (this.vFN != null) {
                aVar.fW(12, this.vFN.bke());
                this.vFN.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.ktN) + 0;
            if (this.nfX != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfX);
            }
            r0 += e.a.a.a.fR(3, this.rYW);
            if (this.vFF != null) {
                r0 += e.a.a.b.b.a.h(4, this.vFF);
            }
            if (this.vFG != null) {
                r0 += e.a.a.b.b.a.h(5, this.vFG);
            }
            if (this.vFH != null) {
                r0 += e.a.a.b.b.a.h(6, this.vFH);
            }
            if (this.vFI != null) {
                r0 += e.a.a.a.fT(7, this.vFI.bke());
            }
            if (this.vFJ != null) {
                r0 += e.a.a.b.b.a.h(8, this.vFJ);
            }
            if (this.vFK != null) {
                r0 += e.a.a.a.fT(9, this.vFK.bke());
            }
            if (this.vFL != null) {
                r0 += e.a.a.a.fT(10, this.vFL.bke());
            }
            if (this.vFM != null) {
                r0 += e.a.a.a.fT(11, this.vFM.bke());
            }
            if (this.vFN != null) {
                return r0 + e.a.a.a.fT(12, this.vFN.bke());
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
            at atVar = (at) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a arVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    atVar.ktN = aVar3.Avy.ry();
                    return 0;
                case 2:
                    atVar.nfX = aVar3.Avy.readString();
                    return 0;
                case 3:
                    atVar.rYW = aVar3.Avy.ry();
                    return 0;
                case 4:
                    atVar.vFF = aVar3.Avy.readString();
                    return 0;
                case 5:
                    atVar.vFG = aVar3.Avy.readString();
                    return 0;
                case 6:
                    atVar.vFH = aVar3.Avy.readString();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        arVar = new ar();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = arVar.a(aVar4, arVar, a.a(aVar4))) {
                        }
                        atVar.vFI = arVar;
                    }
                    return 0;
                case 8:
                    atVar.vFJ = aVar3.Avy.readString();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        arVar = new cp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = arVar.a(aVar4, arVar, a.a(aVar4))) {
                        }
                        atVar.vFK = arVar;
                    }
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        arVar = new cw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = arVar.a(aVar4, arVar, a.a(aVar4))) {
                        }
                        atVar.vFL = arVar;
                    }
                    return 0;
                case 11:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        arVar = new cv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = arVar.a(aVar4, arVar, a.a(aVar4))) {
                        }
                        atVar.vFM = arVar;
                    }
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        arVar = new cv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = arVar.a(aVar4, arVar, a.a(aVar4))) {
                        }
                        atVar.vFN = arVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
