package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class an extends a {
    public String nfK;
    public String nfO;
    public int nfS;
    public String ngW;
    public int ngX;
    public cm ngY;
    public cl ngZ;
    public cn nha;
    public eg nhb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfO != null) {
                aVar.g(1, this.nfO);
            }
            if (this.ngW != null) {
                aVar.g(2, this.ngW);
            }
            aVar.fU(3, this.ngX);
            if (this.nfK != null) {
                aVar.g(4, this.nfK);
            }
            aVar.fU(5, this.nfS);
            if (this.ngY != null) {
                aVar.fW(6, this.ngY.bke());
                this.ngY.a(aVar);
            }
            if (this.ngZ != null) {
                aVar.fW(7, this.ngZ.bke());
                this.ngZ.a(aVar);
            }
            if (this.nha != null) {
                aVar.fW(9, this.nha.bke());
                this.nha.a(aVar);
            }
            if (this.nhb == null) {
                return 0;
            }
            aVar.fW(10, this.nhb.bke());
            this.nhb.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.nfO != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfO) + 0;
            } else {
                r0 = 0;
            }
            if (this.ngW != null) {
                r0 += e.a.a.b.b.a.h(2, this.ngW);
            }
            r0 += e.a.a.a.fR(3, this.ngX);
            if (this.nfK != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfK);
            }
            r0 += e.a.a.a.fR(5, this.nfS);
            if (this.ngY != null) {
                r0 += e.a.a.a.fT(6, this.ngY.bke());
            }
            if (this.ngZ != null) {
                r0 += e.a.a.a.fT(7, this.ngZ.bke());
            }
            if (this.nha != null) {
                r0 += e.a.a.a.fT(9, this.nha.bke());
            }
            if (this.nhb != null) {
                r0 += e.a.a.a.fT(10, this.nhb.bke());
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
            an anVar = (an) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a cmVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    anVar.nfO = aVar3.Avy.readString();
                    return 0;
                case 2:
                    anVar.ngW = aVar3.Avy.readString();
                    return 0;
                case 3:
                    anVar.ngX = aVar3.Avy.ry();
                    return 0;
                case 4:
                    anVar.nfK = aVar3.Avy.readString();
                    return 0;
                case 5:
                    anVar.nfS = aVar3.Avy.ry();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        cmVar = new cm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmVar.a(aVar4, cmVar, a.a(aVar4))) {
                        }
                        anVar.ngY = cmVar;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        cmVar = new cl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmVar.a(aVar4, cmVar, a.a(aVar4))) {
                        }
                        anVar.ngZ = cmVar;
                    }
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        cmVar = new cn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmVar.a(aVar4, cmVar, a.a(aVar4))) {
                        }
                        anVar.nha = cmVar;
                    }
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        cmVar = new eg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmVar.a(aVar4, cmVar, a.a(aVar4))) {
                        }
                        anVar.nhb = cmVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
