package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class btf extends bdf {
    public int wUl;
    public int wUr;
    public buo wUs;
    public int wUt;
    public int wUu;
    public int wUv;
    public int wUw;
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
            aVar.fU(2, this.wbh);
            aVar.S(3, this.wbi);
            aVar.fU(4, this.wUr);
            if (this.wUs != null) {
                aVar.fW(5, this.wUs.bke());
                this.wUs.a(aVar);
            }
            aVar.fU(6, this.wUl);
            aVar.fU(7, this.wUt);
            aVar.fU(8, this.wUu);
            aVar.fU(9, this.wUv);
            aVar.fU(10, this.wUw);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + e.a.a.a.fR(2, this.wbh)) + e.a.a.a.R(3, this.wbi)) + e.a.a.a.fR(4, this.wUr);
            if (this.wUs != null) {
                r0 += e.a.a.a.fT(5, this.wUs.bke());
            }
            return ((((r0 + e.a.a.a.fR(6, this.wUl)) + e.a.a.a.fR(7, this.wUt)) + e.a.a.a.fR(8, this.wUu)) + e.a.a.a.fR(9, this.wUv)) + e.a.a.a.fR(10, this.wUw);
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
            btf com_tencent_mm_protocal_c_btf = (btf) objArr[1];
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
                        com_tencent_mm_protocal_c_btf.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_btf.wbh = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_btf.wbi = aVar3.Avy.rz();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_btf.wUr = aVar3.Avy.ry();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new buo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_btf.wUs = feVar;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_btf.wUl = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_btf.wUt = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_btf.wUu = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_btf.wUv = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_btf.wUw = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
