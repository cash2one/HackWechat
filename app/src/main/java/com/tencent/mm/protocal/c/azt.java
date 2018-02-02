package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class azt extends bdf {
    public int liH;
    public String liI;
    public String mPR;
    public int nZd;
    public String pHM;
    public String pHN;
    public int state;
    public String wGV;
    public int wGW;
    public String wGX;
    public String wGY;
    public String wGZ;
    public String wHa;

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
            aVar.fU(2, this.liH);
            if (this.liI != null) {
                aVar.g(3, this.liI);
            }
            aVar.fU(4, this.state);
            if (this.wGV != null) {
                aVar.g(5, this.wGV);
            }
            aVar.fU(6, this.nZd);
            aVar.fU(7, this.wGW);
            if (this.pHM != null) {
                aVar.g(8, this.pHM);
            }
            if (this.wGX != null) {
                aVar.g(9, this.wGX);
            }
            if (this.pHN != null) {
                aVar.g(10, this.pHN);
            }
            if (this.wGY != null) {
                aVar.g(11, this.wGY);
            }
            if (this.wGZ != null) {
                aVar.g(12, this.wGZ);
            }
            if (this.wHa != null) {
                aVar.g(14, this.wHa);
            }
            if (this.mPR == null) {
                return 0;
            }
            aVar.g(15, this.mPR);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.liH);
            if (this.liI != null) {
                r0 += e.a.a.b.b.a.h(3, this.liI);
            }
            r0 += e.a.a.a.fR(4, this.state);
            if (this.wGV != null) {
                r0 += e.a.a.b.b.a.h(5, this.wGV);
            }
            r0 = (r0 + e.a.a.a.fR(6, this.nZd)) + e.a.a.a.fR(7, this.wGW);
            if (this.pHM != null) {
                r0 += e.a.a.b.b.a.h(8, this.pHM);
            }
            if (this.wGX != null) {
                r0 += e.a.a.b.b.a.h(9, this.wGX);
            }
            if (this.pHN != null) {
                r0 += e.a.a.b.b.a.h(10, this.pHN);
            }
            if (this.wGY != null) {
                r0 += e.a.a.b.b.a.h(11, this.wGY);
            }
            if (this.wGZ != null) {
                r0 += e.a.a.b.b.a.h(12, this.wGZ);
            }
            if (this.wHa != null) {
                r0 += e.a.a.b.b.a.h(14, this.wHa);
            }
            if (this.mPR != null) {
                r0 += e.a.a.b.b.a.h(15, this.mPR);
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
            azt com_tencent_mm_protocal_c_azt = (azt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azt.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_azt.liH = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_azt.liI = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_azt.state = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_azt.wGV = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_azt.nZd = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_azt.wGW = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_azt.pHM = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_azt.wGX = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_azt.pHN = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_azt.wGY = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_azt.wGZ = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_azt.wHa = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_azt.mPR = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
