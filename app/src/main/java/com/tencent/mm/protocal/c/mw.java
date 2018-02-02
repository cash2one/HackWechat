package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class mw extends bdf {
    public can vVA;
    public boolean vVB;
    public String vVC;
    public String vVD;
    public boolean vVE;
    public String vVF;
    public String vVG;
    public String vVH;

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
            if (this.vVA != null) {
                aVar.fW(2, this.vVA.bke());
                this.vVA.a(aVar);
            }
            aVar.al(3, this.vVB);
            if (this.vVC != null) {
                aVar.g(4, this.vVC);
            }
            if (this.vVD != null) {
                aVar.g(5, this.vVD);
            }
            aVar.al(6, this.vVE);
            if (this.vVF != null) {
                aVar.g(7, this.vVF);
            }
            if (this.vVG != null) {
                aVar.g(8, this.vVG);
            }
            if (this.vVH == null) {
                return 0;
            }
            aVar.g(9, this.vVH);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vVA != null) {
                r0 += e.a.a.a.fT(2, this.vVA.bke());
            }
            r0 += e.a.a.b.b.a.dX(3) + 1;
            if (this.vVC != null) {
                r0 += e.a.a.b.b.a.h(4, this.vVC);
            }
            if (this.vVD != null) {
                r0 += e.a.a.b.b.a.h(5, this.vVD);
            }
            r0 += e.a.a.b.b.a.dX(6) + 1;
            if (this.vVF != null) {
                r0 += e.a.a.b.b.a.h(7, this.vVF);
            }
            if (this.vVG != null) {
                r0 += e.a.a.b.b.a.h(8, this.vVG);
            }
            if (this.vVH != null) {
                r0 += e.a.a.b.b.a.h(9, this.vVH);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
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
            mw mwVar = (mw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        mwVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new can();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        mwVar.vVA = feVar;
                    }
                    return 0;
                case 3:
                    mwVar.vVB = aVar3.cJC();
                    return 0;
                case 4:
                    mwVar.vVC = aVar3.Avy.readString();
                    return 0;
                case 5:
                    mwVar.vVD = aVar3.Avy.readString();
                    return 0;
                case 6:
                    mwVar.vVE = aVar3.cJC();
                    return 0;
                case 7:
                    mwVar.vVF = aVar3.Avy.readString();
                    return 0;
                case 8:
                    mwVar.vVG = aVar3.Avy.readString();
                    return 0;
                case 9:
                    mwVar.vVH = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
