package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ayt extends bdf {
    public int lOr;
    public String lOs;
    public int nDD;
    public String nDE;
    public int nDS;
    public int wFN;
    public int wFP;
    public int wFQ;
    public int wbh;
    public long wbi;

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
            aVar.fU(3, this.wbh);
            aVar.S(4, this.wbi);
            aVar.fU(5, this.wFP);
            aVar.fU(6, this.wFN);
            aVar.fU(7, this.nDS);
            aVar.fU(8, this.wFQ);
            aVar.fU(9, this.lOr);
            if (this.lOs != null) {
                aVar.g(10, this.lOs);
            }
            aVar.fU(11, this.nDD);
            if (this.nDE == null) {
                return 0;
            }
            aVar.g(12, this.nDE);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((((r0 + e.a.a.a.fR(3, this.wbh)) + e.a.a.a.R(4, this.wbi)) + e.a.a.a.fR(5, this.wFP)) + e.a.a.a.fR(6, this.wFN)) + e.a.a.a.fR(7, this.nDS)) + e.a.a.a.fR(8, this.wFQ)) + e.a.a.a.fR(9, this.lOr);
            if (this.lOs != null) {
                r0 += e.a.a.b.b.a.h(10, this.lOs);
            }
            r0 += e.a.a.a.fR(11, this.nDD);
            if (this.nDE != null) {
                r0 += e.a.a.b.b.a.h(12, this.nDE);
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
            ayt com_tencent_mm_protocal_c_ayt = (ayt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ayt.wJr = feVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ayt.wbh = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ayt.wbi = aVar3.Avy.rz();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ayt.wFP = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ayt.wFN = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ayt.nDS = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ayt.wFQ = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ayt.lOr = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ayt.lOs = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ayt.nDD = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_ayt.nDE = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
