package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class iu extends bdf {
    public String fwY;
    public int kLO;
    public String kLP;
    public String vHq;
    public String vHr;
    public String vHs;
    public String vOV;
    public String vPa;
    public bil vPb;
    public String vPc;
    public String vPd;
    public int vPe;

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
            aVar.fU(2, this.kLO);
            if (this.kLP != null) {
                aVar.g(3, this.kLP);
            }
            if (this.fwY != null) {
                aVar.g(4, this.fwY);
            }
            if (this.vPa != null) {
                aVar.g(5, this.vPa);
            }
            if (this.vPb != null) {
                aVar.fW(6, this.vPb.bke());
                this.vPb.a(aVar);
            }
            if (this.vHq != null) {
                aVar.g(7, this.vHq);
            }
            if (this.vHs != null) {
                aVar.g(8, this.vHs);
            }
            if (this.vPc != null) {
                aVar.g(9, this.vPc);
            }
            if (this.vPd != null) {
                aVar.g(10, this.vPd);
            }
            aVar.fU(11, this.vPe);
            if (this.vHr != null) {
                aVar.g(12, this.vHr);
            }
            if (this.vOV == null) {
                return 0;
            }
            aVar.g(13, this.vOV);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.kLO);
            if (this.kLP != null) {
                r0 += e.a.a.b.b.a.h(3, this.kLP);
            }
            if (this.fwY != null) {
                r0 += e.a.a.b.b.a.h(4, this.fwY);
            }
            if (this.vPa != null) {
                r0 += e.a.a.b.b.a.h(5, this.vPa);
            }
            if (this.vPb != null) {
                r0 += e.a.a.a.fT(6, this.vPb.bke());
            }
            if (this.vHq != null) {
                r0 += e.a.a.b.b.a.h(7, this.vHq);
            }
            if (this.vHs != null) {
                r0 += e.a.a.b.b.a.h(8, this.vHs);
            }
            if (this.vPc != null) {
                r0 += e.a.a.b.b.a.h(9, this.vPc);
            }
            if (this.vPd != null) {
                r0 += e.a.a.b.b.a.h(10, this.vPd);
            }
            r0 += e.a.a.a.fR(11, this.vPe);
            if (this.vHr != null) {
                r0 += e.a.a.b.b.a.h(12, this.vHr);
            }
            if (this.vOV != null) {
                r0 += e.a.a.b.b.a.h(13, this.vOV);
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
            iu iuVar = (iu) objArr[1];
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
                        iuVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    iuVar.kLO = aVar3.Avy.ry();
                    return 0;
                case 3:
                    iuVar.kLP = aVar3.Avy.readString();
                    return 0;
                case 4:
                    iuVar.fwY = aVar3.Avy.readString();
                    return 0;
                case 5:
                    iuVar.vPa = aVar3.Avy.readString();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bil();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        iuVar.vPb = feVar;
                    }
                    return 0;
                case 7:
                    iuVar.vHq = aVar3.Avy.readString();
                    return 0;
                case 8:
                    iuVar.vHs = aVar3.Avy.readString();
                    return 0;
                case 9:
                    iuVar.vPc = aVar3.Avy.readString();
                    return 0;
                case 10:
                    iuVar.vPd = aVar3.Avy.readString();
                    return 0;
                case 11:
                    iuVar.vPe = aVar3.Avy.ry();
                    return 0;
                case 12:
                    iuVar.vHr = aVar3.Avy.readString();
                    return 0;
                case 13:
                    iuVar.vOV = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
