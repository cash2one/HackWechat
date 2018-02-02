package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class brh extends bdf {
    public String nko;
    public String nkp;
    public int pbl;
    public int vGW;
    public String vHU;
    public long vHe;
    public int vLj;
    public int vNW;
    public int vZw;
    public int vZy;
    public int vZz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.nkp != null) {
                aVar.g(1, this.nkp);
            }
            if (this.nko != null) {
                aVar.g(2, this.nko);
            }
            aVar.fU(3, this.vNW);
            aVar.fU(4, this.vZw);
            aVar.fU(5, this.pbl);
            if (this.vHU != null) {
                aVar.g(6, this.vHU);
            }
            aVar.fU(7, this.vGW);
            aVar.fU(8, this.vZy);
            aVar.fU(9, this.vLj);
            if (this.wJr != null) {
                aVar.fW(10, this.wJr.bke());
                this.wJr.a(aVar);
            }
            aVar.fU(11, this.vZz);
            aVar.S(12, this.vHe);
            return 0;
        } else if (i == 1) {
            if (this.nkp != null) {
                r0 = e.a.a.b.b.a.h(1, this.nkp) + 0;
            } else {
                r0 = 0;
            }
            if (this.nko != null) {
                r0 += e.a.a.b.b.a.h(2, this.nko);
            }
            r0 = ((r0 + e.a.a.a.fR(3, this.vNW)) + e.a.a.a.fR(4, this.vZw)) + e.a.a.a.fR(5, this.pbl);
            if (this.vHU != null) {
                r0 += e.a.a.b.b.a.h(6, this.vHU);
            }
            r0 = ((r0 + e.a.a.a.fR(7, this.vGW)) + e.a.a.a.fR(8, this.vZy)) + e.a.a.a.fR(9, this.vLj);
            if (this.wJr != null) {
                r0 += e.a.a.a.fT(10, this.wJr.bke());
            }
            return (r0 + e.a.a.a.fR(11, this.vZz)) + e.a.a.a.R(12, this.vHe);
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
            brh com_tencent_mm_protocal_c_brh = (brh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_brh.nkp = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_brh.nko = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_brh.vNW = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_brh.vZw = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_brh.pbl = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_brh.vHU = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_brh.vGW = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_brh.vZy = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_brh.vLj = aVar3.Avy.ry();
                    return 0;
                case 10:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_brh.wJr = feVar;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_brh.vZz = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_brh.vHe = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
