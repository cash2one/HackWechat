package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aip extends bdf {
    public String fyY;
    public int kkv;
    public can vVA;
    public String wpP;
    public String wpR;
    public int wpS;
    public LinkedList<asw> wpT = new LinkedList();
    public int wpU;
    public String wpV;
    public String wpW;
    public int wpX;
    public String wpY;
    public String wpZ;
    public String wqa;
    public int wqb;
    public int wqc;
    public asw wqd;

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
            if (this.wpR != null) {
                aVar.g(3, this.wpR);
            }
            aVar.fU(4, this.wpS);
            aVar.fU(5, this.kkv);
            if (this.wpP != null) {
                aVar.g(6, this.wpP);
            }
            aVar.d(7, 8, this.wpT);
            aVar.fU(8, this.wpU);
            if (this.wpV != null) {
                aVar.g(9, this.wpV);
            }
            if (this.wpW != null) {
                aVar.g(10, this.wpW);
            }
            aVar.fU(11, this.wpX);
            if (this.fyY != null) {
                aVar.g(12, this.fyY);
            }
            if (this.wpY != null) {
                aVar.g(13, this.wpY);
            }
            if (this.wpZ != null) {
                aVar.g(14, this.wpZ);
            }
            if (this.wqa != null) {
                aVar.g(15, this.wqa);
            }
            aVar.fU(16, this.wqb);
            aVar.fU(17, this.wqc);
            if (this.wqd == null) {
                return 0;
            }
            aVar.fW(18, this.wqd.bke());
            this.wqd.a(aVar);
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
            if (this.wpR != null) {
                r0 += e.a.a.b.b.a.h(3, this.wpR);
            }
            r0 = (r0 + e.a.a.a.fR(4, this.wpS)) + e.a.a.a.fR(5, this.kkv);
            if (this.wpP != null) {
                r0 += e.a.a.b.b.a.h(6, this.wpP);
            }
            r0 = (r0 + e.a.a.a.c(7, 8, this.wpT)) + e.a.a.a.fR(8, this.wpU);
            if (this.wpV != null) {
                r0 += e.a.a.b.b.a.h(9, this.wpV);
            }
            if (this.wpW != null) {
                r0 += e.a.a.b.b.a.h(10, this.wpW);
            }
            r0 += e.a.a.a.fR(11, this.wpX);
            if (this.fyY != null) {
                r0 += e.a.a.b.b.a.h(12, this.fyY);
            }
            if (this.wpY != null) {
                r0 += e.a.a.b.b.a.h(13, this.wpY);
            }
            if (this.wpZ != null) {
                r0 += e.a.a.b.b.a.h(14, this.wpZ);
            }
            if (this.wqa != null) {
                r0 += e.a.a.b.b.a.h(15, this.wqa);
            }
            r0 = (r0 + e.a.a.a.fR(16, this.wqb)) + e.a.a.a.fR(17, this.wqc);
            if (this.wqd != null) {
                r0 += e.a.a.a.fT(18, this.wqd.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wpT.clear();
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
            aip com_tencent_mm_protocal_c_aip = (aip) objArr[1];
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
                        com_tencent_mm_protocal_c_aip.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new can();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aip.vVA = feVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aip.wpR = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aip.wpS = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aip.kkv = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aip.wpP = aVar3.Avy.readString();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new asw();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aip.wpT.add(feVar);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aip.wpU = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aip.wpV = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aip.wpW = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aip.wpX = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aip.fyY = aVar3.Avy.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aip.wpY = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aip.wpZ = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_aip.wqa = aVar3.Avy.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_aip.wqb = aVar3.Avy.ry();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_aip.wqc = aVar3.Avy.ry();
                    return 0;
                case 18:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new asw();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aip.wqd = feVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
