package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class blt extends a {
    public blu wPl;
    public bls wPm;
    public blr wPn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wPl != null) {
                aVar.fW(1, this.wPl.bke());
                this.wPl.a(aVar);
            }
            if (this.wPm != null) {
                aVar.fW(2, this.wPm.bke());
                this.wPm.a(aVar);
            }
            if (this.wPn == null) {
                return 0;
            }
            aVar.fW(3, this.wPn.bke());
            this.wPn.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wPl != null) {
                r0 = e.a.a.a.fT(1, this.wPl.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wPm != null) {
                r0 += e.a.a.a.fT(2, this.wPm.bke());
            }
            if (this.wPn != null) {
                r0 += e.a.a.a.fT(3, this.wPn.bke());
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
            blt com_tencent_mm_protocal_c_blt = (blt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_blu;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_blu = new blu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_blu.a(aVar4, com_tencent_mm_protocal_c_blu, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blt.wPl = com_tencent_mm_protocal_c_blu;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_blu = new bls();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_blu.a(aVar4, com_tencent_mm_protocal_c_blu, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blt.wPm = com_tencent_mm_protocal_c_blu;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_blu = new blr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_blu.a(aVar4, com_tencent_mm_protocal_c_blu, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_blt.wPn = com_tencent_mm_protocal_c_blu;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
