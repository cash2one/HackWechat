package com.tencent.mm.protocal.c;

import d.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class iw extends bdf {
    public int kLO;
    public String kLP;
    public b sOJ;
    public long sOL;
    public long vPf;
    public LinkedList<String> vPg = new LinkedList();
    public int vPh;
    public int vPi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new e.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            aVar.fU(2, this.kLO);
            if (this.kLP != null) {
                aVar.g(3, this.kLP);
            }
            aVar.S(4, this.sOL);
            if (this.sOJ != null) {
                aVar.fW(5, this.sOJ.bke());
                this.sOJ.a(aVar);
            }
            aVar.S(6, this.vPf);
            aVar.d(7, 1, this.vPg);
            aVar.fU(8, this.vPh);
            aVar.fU(9, this.vPi);
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
            r0 += e.a.a.a.R(4, this.sOL);
            if (this.sOJ != null) {
                r0 += e.a.a.a.fT(5, this.sOJ.bke());
            }
            return (((r0 + e.a.a.a.R(6, this.vPf)) + e.a.a.a.c(7, 1, this.vPg)) + e.a.a.a.fR(8, this.vPh)) + e.a.a.a.fR(9, this.vPi);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vPg.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            iw iwVar = (iw) objArr[1];
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
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        iwVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    iwVar.kLO = aVar3.Avy.ry();
                    return 0;
                case 3:
                    iwVar.kLP = aVar3.Avy.readString();
                    return 0;
                case 4:
                    iwVar.sOL = aVar3.Avy.rz();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new b();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        iwVar.sOJ = feVar;
                    }
                    return 0;
                case 6:
                    iwVar.vPf = aVar3.Avy.rz();
                    return 0;
                case 7:
                    iwVar.vPg.add(aVar3.Avy.readString());
                    return 0;
                case 8:
                    iwVar.vPh = aVar3.Avy.ry();
                    return 0;
                case 9:
                    iwVar.vPi = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
