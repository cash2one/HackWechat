package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bbp extends bdf {
    public int kLO;
    public String kLP;
    public String nBM;
    public String pay;
    public int status;
    public int wEO;
    public boolean wHS;
    public boolean wHT;
    public String wHU;
    public String wHV;
    public String wHW;

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
            aVar.al(4, this.wHS);
            aVar.al(5, this.wHT);
            aVar.fU(6, this.status);
            if (this.wHU != null) {
                aVar.g(7, this.wHU);
            }
            if (this.wHV != null) {
                aVar.g(8, this.wHV);
            }
            aVar.fU(9, this.wEO);
            if (this.nBM != null) {
                aVar.g(10, this.nBM);
            }
            if (this.pay != null) {
                aVar.g(11, this.pay);
            }
            if (this.wHW == null) {
                return 0;
            }
            aVar.g(12, this.wHW);
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
            r0 = ((r0 + (e.a.a.b.b.a.dX(4) + 1)) + (e.a.a.b.b.a.dX(5) + 1)) + e.a.a.a.fR(6, this.status);
            if (this.wHU != null) {
                r0 += e.a.a.b.b.a.h(7, this.wHU);
            }
            if (this.wHV != null) {
                r0 += e.a.a.b.b.a.h(8, this.wHV);
            }
            r0 += e.a.a.a.fR(9, this.wEO);
            if (this.nBM != null) {
                r0 += e.a.a.b.b.a.h(10, this.nBM);
            }
            if (this.pay != null) {
                r0 += e.a.a.b.b.a.h(11, this.pay);
            }
            if (this.wHW != null) {
                r0 += e.a.a.b.b.a.h(12, this.wHW);
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
            bbp com_tencent_mm_protocal_c_bbp = (bbp) objArr[1];
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
                        com_tencent_mm_protocal_c_bbp.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bbp.kLO = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bbp.kLP = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bbp.wHS = aVar3.cJC();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bbp.wHT = aVar3.cJC();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bbp.status = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bbp.wHU = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bbp.wHV = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bbp.wEO = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bbp.nBM = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bbp.pay = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bbp.wHW = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
