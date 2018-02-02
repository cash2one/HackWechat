package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class js extends bdf {
    public String nko;
    public String nkp;
    public int pbl;
    public long vHe;
    public String vQA;
    public String vQE;
    public String vQp;

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
            if (this.vQp != null) {
                aVar.g(3, this.vQp);
            }
            if (this.nkp != null) {
                aVar.g(4, this.nkp);
            }
            if (this.nko != null) {
                aVar.g(5, this.nko);
            }
            aVar.fU(9, this.pbl);
            aVar.S(10, this.vHe);
            if (this.vQA != null) {
                aVar.g(11, this.vQA);
            }
            if (this.vQE == null) {
                return 0;
            }
            aVar.g(12, this.vQE);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vQp != null) {
                r0 += e.a.a.b.b.a.h(3, this.vQp);
            }
            if (this.nkp != null) {
                r0 += e.a.a.b.b.a.h(4, this.nkp);
            }
            if (this.nko != null) {
                r0 += e.a.a.b.b.a.h(5, this.nko);
            }
            r0 = (r0 + e.a.a.a.fR(9, this.pbl)) + e.a.a.a.R(10, this.vHe);
            if (this.vQA != null) {
                r0 += e.a.a.b.b.a.h(11, this.vQA);
            }
            if (this.vQE != null) {
                r0 += e.a.a.b.b.a.h(12, this.vQE);
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
            js jsVar = (js) objArr[1];
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
                        jsVar.wJr = feVar;
                    }
                    return 0;
                case 3:
                    jsVar.vQp = aVar3.Avy.readString();
                    return 0;
                case 4:
                    jsVar.nkp = aVar3.Avy.readString();
                    return 0;
                case 5:
                    jsVar.nko = aVar3.Avy.readString();
                    return 0;
                case 9:
                    jsVar.pbl = aVar3.Avy.ry();
                    return 0;
                case 10:
                    jsVar.vHe = aVar3.Avy.rz();
                    return 0;
                case 11:
                    jsVar.vQA = aVar3.Avy.readString();
                    return 0;
                case 12:
                    jsVar.vQE = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
