package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bfn extends bcv {
    public String hvw;
    public int vIE;
    public int vQC;
    public String vZL;
    public int wKA;
    public cx wKx;
    public String wKy;
    public String wKz;
    public int wac;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wKx == null) {
                throw new b("Not all required fields were included: Msg");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.wKx != null) {
                aVar.fW(2, this.wKx.bke());
                this.wKx.a(aVar);
            }
            if (this.wKy != null) {
                aVar.g(3, this.wKy);
            }
            aVar.fU(4, this.wac);
            if (this.vZL != null) {
                aVar.g(5, this.vZL);
            }
            aVar.fU(6, this.vIE);
            if (this.hvw != null) {
                aVar.g(7, this.hvw);
            }
            if (this.wKz != null) {
                aVar.g(8, this.wKz);
            }
            aVar.fU(9, this.wKA);
            aVar.fU(10, this.vQC);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wKx != null) {
                r0 += e.a.a.a.fT(2, this.wKx.bke());
            }
            if (this.wKy != null) {
                r0 += e.a.a.b.b.a.h(3, this.wKy);
            }
            r0 += e.a.a.a.fR(4, this.wac);
            if (this.vZL != null) {
                r0 += e.a.a.b.b.a.h(5, this.vZL);
            }
            r0 += e.a.a.a.fR(6, this.vIE);
            if (this.hvw != null) {
                r0 += e.a.a.b.b.a.h(7, this.hvw);
            }
            if (this.wKz != null) {
                r0 += e.a.a.b.b.a.h(8, this.wKz);
            }
            return (r0 + e.a.a.a.fR(9, this.wKA)) + e.a.a.a.fR(10, this.vQC);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wKx != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Msg");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfn com_tencent_mm_protocal_c_bfn = (bfn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfn.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new cx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfn.wKx = fdVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bfn.wKy = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bfn.wac = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bfn.vZL = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bfn.vIE = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bfn.hvw = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bfn.wKz = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bfn.wKA = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bfn.vQC = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
