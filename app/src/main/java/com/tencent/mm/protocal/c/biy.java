package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class biy extends a {
    public int vHW;
    public bdo wMi;
    public bdo wMk;
    public int wMl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wMi != null) {
                aVar.fW(1, this.wMi.bke());
                this.wMi.a(aVar);
            }
            aVar.fU(2, this.vHW);
            if (this.wMk != null) {
                aVar.fW(3, this.wMk.bke());
                this.wMk.a(aVar);
            }
            aVar.fU(4, this.wMl);
            return 0;
        } else if (i == 1) {
            if (this.wMi != null) {
                r0 = e.a.a.a.fT(1, this.wMi.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.vHW);
            if (this.wMk != null) {
                r0 += e.a.a.a.fT(3, this.wMk.bke());
            }
            return r0 + e.a.a.a.fR(4, this.wMl);
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
            biy com_tencent_mm_protocal_c_biy = (biy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bdo;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_biy.wMi = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_biy.vHW = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_biy.wMk = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_biy.wMl = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
