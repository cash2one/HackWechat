package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class fb extends a {
    public bdn vJf;
    public bdn vJg;
    public String vJl;
    public bdn vKR;
    public bwv vKS;
    public cak vKT;
    public int vKU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vKR != null) {
                aVar.fW(1, this.vKR.bke());
                this.vKR.a(aVar);
            }
            if (this.vKS != null) {
                aVar.fW(2, this.vKS.bke());
                this.vKS.a(aVar);
            }
            if (this.vKT != null) {
                aVar.fW(3, this.vKT.bke());
                this.vKT.a(aVar);
            }
            if (this.vJf != null) {
                aVar.fW(4, this.vJf.bke());
                this.vJf.a(aVar);
            }
            if (this.vJg != null) {
                aVar.fW(5, this.vJg.bke());
                this.vJg.a(aVar);
            }
            aVar.fU(6, this.vKU);
            if (this.vJl == null) {
                return 0;
            }
            aVar.g(7, this.vJl);
            return 0;
        } else if (i == 1) {
            if (this.vKR != null) {
                r0 = e.a.a.a.fT(1, this.vKR.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vKS != null) {
                r0 += e.a.a.a.fT(2, this.vKS.bke());
            }
            if (this.vKT != null) {
                r0 += e.a.a.a.fT(3, this.vKT.bke());
            }
            if (this.vJf != null) {
                r0 += e.a.a.a.fT(4, this.vJf.bke());
            }
            if (this.vJg != null) {
                r0 += e.a.a.a.fT(5, this.vJg.bke());
            }
            r0 += e.a.a.a.fR(6, this.vKU);
            if (this.vJl != null) {
                r0 += e.a.a.b.b.a.h(7, this.vJl);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            fb fbVar = (fb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bdn;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        fbVar.vKR = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bwv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        fbVar.vKS = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new cak();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        fbVar.vKT = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        fbVar.vJf = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        fbVar.vJg = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 6:
                    fbVar.vKU = aVar3.Avy.ry();
                    return 0;
                case 7:
                    fbVar.vJl = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
