package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aid extends bdf {
    public String fon;
    public String nGK;
    public String nfe;
    public String wpA;
    public String wpB;
    public String wpC;
    public int wpe;
    public LinkedList<bwo> wpf = new LinkedList();
    public String wpr;
    public String wps;
    public String wpt;
    public String wpu;
    public String wpv;
    public String wpw;
    public bwu wpx;
    public String wpy;
    public String wpz;

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
            if (this.wpr != null) {
                aVar.g(2, this.wpr);
            }
            if (this.nGK != null) {
                aVar.g(3, this.nGK);
            }
            if (this.fon != null) {
                aVar.g(4, this.fon);
            }
            if (this.nfe != null) {
                aVar.g(5, this.nfe);
            }
            if (this.wps != null) {
                aVar.g(6, this.wps);
            }
            if (this.wpt != null) {
                aVar.g(7, this.wpt);
            }
            if (this.wpu != null) {
                aVar.g(8, this.wpu);
            }
            if (this.wpv != null) {
                aVar.g(9, this.wpv);
            }
            if (this.wpw != null) {
                aVar.g(10, this.wpw);
            }
            if (this.wpx != null) {
                aVar.fW(11, this.wpx.bke());
                this.wpx.a(aVar);
            }
            if (this.wpy != null) {
                aVar.g(12, this.wpy);
            }
            if (this.wpz != null) {
                aVar.g(13, this.wpz);
            }
            if (this.wpA != null) {
                aVar.g(14, this.wpA);
            }
            if (this.wpB != null) {
                aVar.g(15, this.wpB);
            }
            if (this.wpC != null) {
                aVar.g(16, this.wpC);
            }
            aVar.fU(17, this.wpe);
            aVar.d(18, 8, this.wpf);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wpr != null) {
                r0 += e.a.a.b.b.a.h(2, this.wpr);
            }
            if (this.nGK != null) {
                r0 += e.a.a.b.b.a.h(3, this.nGK);
            }
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(4, this.fon);
            }
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(5, this.nfe);
            }
            if (this.wps != null) {
                r0 += e.a.a.b.b.a.h(6, this.wps);
            }
            if (this.wpt != null) {
                r0 += e.a.a.b.b.a.h(7, this.wpt);
            }
            if (this.wpu != null) {
                r0 += e.a.a.b.b.a.h(8, this.wpu);
            }
            if (this.wpv != null) {
                r0 += e.a.a.b.b.a.h(9, this.wpv);
            }
            if (this.wpw != null) {
                r0 += e.a.a.b.b.a.h(10, this.wpw);
            }
            if (this.wpx != null) {
                r0 += e.a.a.a.fT(11, this.wpx.bke());
            }
            if (this.wpy != null) {
                r0 += e.a.a.b.b.a.h(12, this.wpy);
            }
            if (this.wpz != null) {
                r0 += e.a.a.b.b.a.h(13, this.wpz);
            }
            if (this.wpA != null) {
                r0 += e.a.a.b.b.a.h(14, this.wpA);
            }
            if (this.wpB != null) {
                r0 += e.a.a.b.b.a.h(15, this.wpB);
            }
            if (this.wpC != null) {
                r0 += e.a.a.b.b.a.h(16, this.wpC);
            }
            return (r0 + e.a.a.a.fR(17, this.wpe)) + e.a.a.a.c(18, 8, this.wpf);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wpf.clear();
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
            aid com_tencent_mm_protocal_c_aid = (aid) objArr[1];
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
                        com_tencent_mm_protocal_c_aid.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aid.wpr = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aid.nGK = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aid.fon = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aid.nfe = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aid.wps = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aid.wpt = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aid.wpu = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aid.wpv = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aid.wpw = aVar3.Avy.readString();
                    return 0;
                case 11:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bwu();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aid.wpx = feVar;
                    }
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aid.wpy = aVar3.Avy.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aid.wpz = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aid.wpA = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_aid.wpB = aVar3.Avy.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_aid.wpC = aVar3.Avy.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_aid.wpe = aVar3.Avy.ry();
                    return 0;
                case 18:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bwo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aid.wpf.add(feVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
