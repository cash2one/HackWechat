package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class rn extends bdf {
    public int vGW;
    public String vHU;
    public long vHe;
    public int vLj;
    public int vNW;
    public bdn vXz;
    public int vZw;
    public int vZy;
    public int vZz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vXz == null) {
                throw new b("Not all required fields were included: Data");
            } else if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else {
                aVar.fU(1, this.vGW);
                aVar.fU(2, this.vNW);
                aVar.fU(3, this.vZw);
                aVar.fU(5, this.vZy);
                if (this.vHU != null) {
                    aVar.g(6, this.vHU);
                }
                if (this.vXz != null) {
                    aVar.fW(7, this.vXz.bke());
                    this.vXz.a(aVar);
                }
                aVar.fU(8, this.vLj);
                if (this.wJr != null) {
                    aVar.fW(9, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                aVar.fU(10, this.vZz);
                aVar.S(11, this.vHe);
                return 0;
            }
        } else if (i == 1) {
            r0 = (((e.a.a.a.fR(1, this.vGW) + 0) + e.a.a.a.fR(2, this.vNW)) + e.a.a.a.fR(3, this.vZw)) + e.a.a.a.fR(5, this.vZy);
            if (this.vHU != null) {
                r0 += e.a.a.b.b.a.h(6, this.vHU);
            }
            if (this.vXz != null) {
                r0 += e.a.a.a.fT(7, this.vXz.bke());
            }
            r0 += e.a.a.a.fR(8, this.vLj);
            if (this.wJr != null) {
                r0 += e.a.a.a.fT(9, this.wJr.bke());
            }
            return (r0 + e.a.a.a.fR(10, this.vZz)) + e.a.a.a.R(11, this.vHe);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vXz == null) {
                throw new b("Not all required fields were included: Data");
            } else if (this.wJr != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BaseResponse");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rn rnVar = (rn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a com_tencent_mm_protocal_c_bdn;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    rnVar.vGW = aVar3.Avy.ry();
                    return 0;
                case 2:
                    rnVar.vNW = aVar3.Avy.ry();
                    return 0;
                case 3:
                    rnVar.vZw = aVar3.Avy.ry();
                    return 0;
                case 5:
                    rnVar.vZy = aVar3.Avy.ry();
                    return 0;
                case 6:
                    rnVar.vHU = aVar3.Avy.readString();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, bdf.a(aVar4))) {
                        }
                        rnVar.vXz = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 8:
                    rnVar.vLj = aVar3.Avy.ry();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new fe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, bdf.a(aVar4))) {
                        }
                        rnVar.wJr = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 10:
                    rnVar.vZz = aVar3.Avy.ry();
                    return 0;
                case 11:
                    rnVar.vHe = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
