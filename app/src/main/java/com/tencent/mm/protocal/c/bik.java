package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bik extends bdf {
    public String frP;
    public String hcp;
    public String title;
    public String wBK;
    public dz wKN;
    public int wLO;
    public dy wLP;
    public String wLQ;
    public LinkedList<ea> wLR = new LinkedList();
    public String wLS;
    public String wLT;
    public eb wLU;
    public LinkedList<eb> wLV = new LinkedList();
    public bst wLW;

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
            if (this.wKN != null) {
                aVar.fW(2, this.wKN.bke());
                this.wKN.a(aVar);
            }
            aVar.fU(3, this.wLO);
            if (this.wLP != null) {
                aVar.fW(4, this.wLP.bke());
                this.wLP.a(aVar);
            }
            if (this.title != null) {
                aVar.g(5, this.title);
            }
            if (this.wBK != null) {
                aVar.g(6, this.wBK);
            }
            if (this.hcp != null) {
                aVar.g(7, this.hcp);
            }
            if (this.wLQ != null) {
                aVar.g(8, this.wLQ);
            }
            aVar.d(9, 8, this.wLR);
            if (this.wLS != null) {
                aVar.g(10, this.wLS);
            }
            if (this.wLT != null) {
                aVar.g(11, this.wLT);
            }
            if (this.wLU != null) {
                aVar.fW(12, this.wLU.bke());
                this.wLU.a(aVar);
            }
            aVar.d(13, 8, this.wLV);
            if (this.frP != null) {
                aVar.g(14, this.frP);
            }
            if (this.wLW == null) {
                return 0;
            }
            aVar.fW(15, this.wLW.bke());
            this.wLW.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wKN != null) {
                r0 += e.a.a.a.fT(2, this.wKN.bke());
            }
            r0 += e.a.a.a.fR(3, this.wLO);
            if (this.wLP != null) {
                r0 += e.a.a.a.fT(4, this.wLP.bke());
            }
            if (this.title != null) {
                r0 += e.a.a.b.b.a.h(5, this.title);
            }
            if (this.wBK != null) {
                r0 += e.a.a.b.b.a.h(6, this.wBK);
            }
            if (this.hcp != null) {
                r0 += e.a.a.b.b.a.h(7, this.hcp);
            }
            if (this.wLQ != null) {
                r0 += e.a.a.b.b.a.h(8, this.wLQ);
            }
            r0 += e.a.a.a.c(9, 8, this.wLR);
            if (this.wLS != null) {
                r0 += e.a.a.b.b.a.h(10, this.wLS);
            }
            if (this.wLT != null) {
                r0 += e.a.a.b.b.a.h(11, this.wLT);
            }
            if (this.wLU != null) {
                r0 += e.a.a.a.fT(12, this.wLU.bke());
            }
            r0 += e.a.a.a.c(13, 8, this.wLV);
            if (this.frP != null) {
                r0 += e.a.a.b.b.a.h(14, this.frP);
            }
            if (this.wLW != null) {
                r0 += e.a.a.a.fT(15, this.wLW.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wLR.clear();
            this.wLV.clear();
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
            bik com_tencent_mm_protocal_c_bik = (bik) objArr[1];
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
                        com_tencent_mm_protocal_c_bik.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new dz();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bik.wKN = feVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bik.wLO = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new dy();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bik.wLP = feVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bik.title = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bik.wBK = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bik.hcp = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bik.wLQ = aVar3.Avy.readString();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new ea();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bik.wLR.add(feVar);
                    }
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bik.wLS = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bik.wLT = aVar3.Avy.readString();
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new eb();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bik.wLU = feVar;
                    }
                    return 0;
                case 13:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new eb();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bik.wLV.add(feVar);
                    }
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bik.frP = aVar3.Avy.readString();
                    return 0;
                case 15:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bst();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bik.wLW = feVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
