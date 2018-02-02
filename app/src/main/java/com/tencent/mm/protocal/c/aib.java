package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aib extends bdf {
    public int wkM;
    public LinkedList<bwl> wkN = new LinkedList();
    public String wpi;
    public String wpk;
    public int wpl;
    public String wpm;
    public String wpn;
    public String wpo;

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
            aVar.fU(2, this.wkM);
            aVar.d(3, 8, this.wkN);
            if (this.wpk != null) {
                aVar.g(4, this.wpk);
            }
            if (this.wpi != null) {
                aVar.g(5, this.wpi);
            }
            aVar.fU(6, this.wpl);
            if (this.wpm != null) {
                aVar.g(7, this.wpm);
            }
            if (this.wpn != null) {
                aVar.g(8, this.wpn);
            }
            if (this.wpo == null) {
                return 0;
            }
            aVar.g(9, this.wpo);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.wkM)) + e.a.a.a.c(3, 8, this.wkN);
            if (this.wpk != null) {
                r0 += e.a.a.b.b.a.h(4, this.wpk);
            }
            if (this.wpi != null) {
                r0 += e.a.a.b.b.a.h(5, this.wpi);
            }
            r0 += e.a.a.a.fR(6, this.wpl);
            if (this.wpm != null) {
                r0 += e.a.a.b.b.a.h(7, this.wpm);
            }
            if (this.wpn != null) {
                r0 += e.a.a.b.b.a.h(8, this.wpn);
            }
            if (this.wpo != null) {
                r0 += e.a.a.b.b.a.h(9, this.wpo);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wkN.clear();
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
            aib com_tencent_mm_protocal_c_aib = (aib) objArr[1];
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
                        com_tencent_mm_protocal_c_aib.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aib.wkM = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bwl();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aib.wkN.add(feVar);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aib.wpk = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aib.wpi = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aib.wpl = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aib.wpm = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aib.wpn = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aib.wpo = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
