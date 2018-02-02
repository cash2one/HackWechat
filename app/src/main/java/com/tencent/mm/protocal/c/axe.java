package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class axe extends a {
    public String vXf;
    public cac wEt;
    public cae wEu;
    public bzy wEv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vXf == null) {
                throw new b("Not all required fields were included: PkgId");
            }
            if (this.vXf != null) {
                aVar.g(1, this.vXf);
            }
            if (this.wEt != null) {
                aVar.fW(2, this.wEt.bke());
                this.wEt.a(aVar);
            }
            if (this.wEu != null) {
                aVar.fW(3, this.wEu.bke());
                this.wEu.a(aVar);
            }
            if (this.wEv == null) {
                return 0;
            }
            aVar.fW(4, this.wEv.bke());
            this.wEv.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.vXf != null) {
                r0 = e.a.a.b.b.a.h(1, this.vXf) + 0;
            } else {
                r0 = 0;
            }
            if (this.wEt != null) {
                r0 += e.a.a.a.fT(2, this.wEt.bke());
            }
            if (this.wEu != null) {
                r0 += e.a.a.a.fT(3, this.wEu.bke());
            }
            if (this.wEv != null) {
                r0 += e.a.a.a.fT(4, this.wEv.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vXf != null) {
                return 0;
            }
            throw new b("Not all required fields were included: PkgId");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            axe com_tencent_mm_protocal_c_axe = (axe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_cac;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_axe.vXf = aVar3.Avy.readString();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_cac = new cac();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_cac.a(aVar4, com_tencent_mm_protocal_c_cac, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axe.wEt = com_tencent_mm_protocal_c_cac;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_cac = new cae();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_cac.a(aVar4, com_tencent_mm_protocal_c_cac, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axe.wEu = com_tencent_mm_protocal_c_cac;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_cac = new bzy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_cac.a(aVar4, com_tencent_mm_protocal_c_cac, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axe.wEv = com_tencent_mm_protocal_c_cac;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
