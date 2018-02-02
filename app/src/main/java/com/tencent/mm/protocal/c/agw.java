package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class agw extends bdf {
    public int wog;
    public String woh;
    public int woi;
    public String woj;
    public int wok;
    public LinkedList<bdo> wol = new LinkedList();
    public String wom;
    public int won;
    public String woo;
    public int wop;
    public bdn woq;

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
            aVar.fU(2, this.wog);
            if (this.woh != null) {
                aVar.g(3, this.woh);
            }
            aVar.fU(4, this.woi);
            if (this.woj != null) {
                aVar.g(5, this.woj);
            }
            aVar.fU(6, this.wok);
            aVar.d(7, 8, this.wol);
            if (this.wom != null) {
                aVar.g(8, this.wom);
            }
            aVar.fU(9, this.won);
            if (this.woo != null) {
                aVar.g(10, this.woo);
            }
            aVar.fU(11, this.wop);
            if (this.woq == null) {
                return 0;
            }
            aVar.fW(12, this.woq.bke());
            this.woq.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.wog);
            if (this.woh != null) {
                r0 += e.a.a.b.b.a.h(3, this.woh);
            }
            r0 += e.a.a.a.fR(4, this.woi);
            if (this.woj != null) {
                r0 += e.a.a.b.b.a.h(5, this.woj);
            }
            r0 = (r0 + e.a.a.a.fR(6, this.wok)) + e.a.a.a.c(7, 8, this.wol);
            if (this.wom != null) {
                r0 += e.a.a.b.b.a.h(8, this.wom);
            }
            r0 += e.a.a.a.fR(9, this.won);
            if (this.woo != null) {
                r0 += e.a.a.b.b.a.h(10, this.woo);
            }
            r0 += e.a.a.a.fR(11, this.wop);
            if (this.woq != null) {
                r0 += e.a.a.a.fT(12, this.woq.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wol.clear();
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
            agw com_tencent_mm_protocal_c_agw = (agw) objArr[1];
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
                        com_tencent_mm_protocal_c_agw.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_agw.wog = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_agw.woh = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_agw.woi = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_agw.woj = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_agw.wok = aVar3.Avy.ry();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_agw.wol.add(feVar);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_agw.wom = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_agw.won = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_agw.woo = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_agw.wop = aVar3.Avy.ry();
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_agw.woq = feVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
