package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class mh extends bdf {
    public int liH;
    public String liI;
    public String pHK;
    public String pHL;
    public String pHM;
    public String vIK;

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
            aVar.fU(2, this.liH);
            if (this.liI != null) {
                aVar.g(3, this.liI);
            }
            if (this.pHK != null) {
                aVar.g(4, this.pHK);
            }
            if (this.pHL != null) {
                aVar.g(5, this.pHL);
            }
            if (this.pHM != null) {
                aVar.g(6, this.pHM);
            }
            if (this.vIK == null) {
                return 0;
            }
            aVar.g(7, this.vIK);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.liH);
            if (this.liI != null) {
                r0 += e.a.a.b.b.a.h(3, this.liI);
            }
            if (this.pHK != null) {
                r0 += e.a.a.b.b.a.h(4, this.pHK);
            }
            if (this.pHL != null) {
                r0 += e.a.a.b.b.a.h(5, this.pHL);
            }
            if (this.pHM != null) {
                r0 += e.a.a.b.b.a.h(6, this.pHM);
            }
            if (this.vIK != null) {
                r0 += e.a.a.b.b.a.h(7, this.vIK);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            mh mhVar = (mh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        mhVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    mhVar.liH = aVar3.Avy.ry();
                    return 0;
                case 3:
                    mhVar.liI = aVar3.Avy.readString();
                    return 0;
                case 4:
                    mhVar.pHK = aVar3.Avy.readString();
                    return 0;
                case 5:
                    mhVar.pHL = aVar3.Avy.readString();
                    return 0;
                case 6:
                    mhVar.pHM = aVar3.Avy.readString();
                    return 0;
                case 7:
                    mhVar.vIK = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
