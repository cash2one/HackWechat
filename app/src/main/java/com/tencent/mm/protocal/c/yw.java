package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class yw extends bdf {
    public int liH;
    public String liI;
    public LinkedList<String> wiO = new LinkedList();
    public String wiP;

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
            aVar.d(2, 1, this.wiO);
            aVar.fU(3, this.liH);
            if (this.liI != null) {
                aVar.g(4, this.liI);
            }
            if (this.wiP == null) {
                return 0;
            }
            aVar.g(5, this.wiP);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.c(2, 1, this.wiO)) + e.a.a.a.fR(3, this.liH);
            if (this.liI != null) {
                r0 += e.a.a.b.b.a.h(4, this.liI);
            }
            if (this.wiP != null) {
                r0 += e.a.a.b.b.a.h(5, this.wiP);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wiO.clear();
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
            yw ywVar = (yw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        ywVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    ywVar.wiO.add(aVar3.Avy.readString());
                    return 0;
                case 3:
                    ywVar.liH = aVar3.Avy.ry();
                    return 0;
                case 4:
                    ywVar.liI = aVar3.Avy.readString();
                    return 0;
                case 5:
                    ywVar.wiP = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}