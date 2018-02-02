package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class azk extends bdf {
    public String kJP;
    public int kLO;
    public String kLP;
    public String oZA;
    public String oZz;
    public String wGr;
    public String wGs;
    public ju wGt;
    public String wGu;
    public String wGv;
    public boe wGw;

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
            if (this.wGr != null) {
                aVar.g(4, this.wGr);
            }
            if (this.kJP != null) {
                aVar.g(5, this.kJP);
            }
            if (this.wGs != null) {
                aVar.g(6, this.wGs);
            }
            if (this.wGt != null) {
                aVar.fW(7, this.wGt.bke());
                this.wGt.a(aVar);
            }
            if (this.wGu != null) {
                aVar.g(8, this.wGu);
            }
            if (this.oZA != null) {
                aVar.g(9, this.oZA);
            }
            if (this.oZz != null) {
                aVar.g(10, this.oZz);
            }
            if (this.wGv != null) {
                aVar.g(11, this.wGv);
            }
            if (this.wGw == null) {
                return 0;
            }
            aVar.fW(12, this.wGw.bke());
            this.wGw.a(aVar);
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
            if (this.wGr != null) {
                r0 += e.a.a.b.b.a.h(4, this.wGr);
            }
            if (this.kJP != null) {
                r0 += e.a.a.b.b.a.h(5, this.kJP);
            }
            if (this.wGs != null) {
                r0 += e.a.a.b.b.a.h(6, this.wGs);
            }
            if (this.wGt != null) {
                r0 += e.a.a.a.fT(7, this.wGt.bke());
            }
            if (this.wGu != null) {
                r0 += e.a.a.b.b.a.h(8, this.wGu);
            }
            if (this.oZA != null) {
                r0 += e.a.a.b.b.a.h(9, this.oZA);
            }
            if (this.oZz != null) {
                r0 += e.a.a.b.b.a.h(10, this.oZz);
            }
            if (this.wGv != null) {
                r0 += e.a.a.b.b.a.h(11, this.wGv);
            }
            if (this.wGw != null) {
                r0 += e.a.a.a.fT(12, this.wGw.bke());
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
            azk com_tencent_mm_protocal_c_azk = (azk) objArr[1];
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
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azk.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_azk.kLO = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_azk.kLP = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_azk.wGr = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_azk.kJP = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_azk.wGs = aVar3.Avy.readString();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new ju();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azk.wGt = feVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_azk.wGu = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_azk.oZA = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_azk.oZz = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_azk.wGv = aVar3.Avy.readString();
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new boe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azk.wGw = feVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
