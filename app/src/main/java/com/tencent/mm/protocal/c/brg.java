package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class brg extends bcv {
    public String nko;
    public String nkp;
    public int vGW;
    public String vHU;
    public String vHc;
    public long vHe;
    public int vLj;
    public int vNW;
    public bdn vXz;
    public int vZw;
    public int vZy;
    public int vZz;
    public int wSL;
    public int wSM;
    public int wac;
    public int wxw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vXz == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.nkp != null) {
                aVar.g(1, this.nkp);
            }
            if (this.nko != null) {
                aVar.g(2, this.nko);
            }
            aVar.fU(3, this.vNW);
            aVar.fU(4, this.vZw);
            if (this.vHU != null) {
                aVar.g(5, this.vHU);
            }
            aVar.fU(6, this.vGW);
            aVar.fU(7, this.vZy);
            if (this.vXz != null) {
                aVar.fW(8, this.vXz.bke());
                this.vXz.a(aVar);
            }
            aVar.fU(9, this.vLj);
            if (this.wIV != null) {
                aVar.fW(10, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(11, this.vZz);
            if (this.vHc != null) {
                aVar.g(12, this.vHc);
            }
            aVar.fU(13, this.wxw);
            aVar.fU(14, this.wSL);
            aVar.fU(15, this.wSM);
            aVar.S(16, this.vHe);
            aVar.fU(17, this.wac);
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
            r0 = (r0 + e.a.a.a.fR(3, this.vNW)) + e.a.a.a.fR(4, this.vZw);
            if (this.vHU != null) {
                r0 += e.a.a.b.b.a.h(5, this.vHU);
            }
            r0 = (r0 + e.a.a.a.fR(6, this.vGW)) + e.a.a.a.fR(7, this.vZy);
            if (this.vXz != null) {
                r0 += e.a.a.a.fT(8, this.vXz.bke());
            }
            r0 += e.a.a.a.fR(9, this.vLj);
            if (this.wIV != null) {
                r0 += e.a.a.a.fT(10, this.wIV.bke());
            }
            r0 += e.a.a.a.fR(11, this.vZz);
            if (this.vHc != null) {
                r0 += e.a.a.b.b.a.h(12, this.vHc);
            }
            return ((((r0 + e.a.a.a.fR(13, this.wxw)) + e.a.a.a.fR(14, this.wSL)) + e.a.a.a.fR(15, this.wSM)) + e.a.a.a.R(16, this.vHe)) + e.a.a.a.fR(17, this.wac);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vXz != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            brg com_tencent_mm_protocal_c_brg = (brg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a com_tencent_mm_protocal_c_bdn;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_brg.nkp = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_brg.nko = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_brg.vNW = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_brg.vZw = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_brg.vHU = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_brg.vGW = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_brg.vZy = aVar3.Avy.ry();
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_brg.vXz = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_brg.vLj = aVar3.Avy.ry();
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new fd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_brg.wIV = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_brg.vZz = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_brg.vHc = aVar3.Avy.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_brg.wxw = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_brg.wSL = aVar3.Avy.ry();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_brg.wSM = aVar3.Avy.ry();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_brg.vHe = aVar3.Avy.rz();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_brg.wac = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
