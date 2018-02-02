package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bav extends bdf {
    public baw wHu;
    public int wHw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wHu == null) {
                throw new b("Not all required fields were included: rcptinfolist");
            } else if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else {
                if (this.wHu != null) {
                    aVar.fW(1, this.wHu.bke());
                    this.wHu.a(aVar);
                }
                aVar.fU(2, this.wHw);
                if (this.wJr == null) {
                    return 0;
                }
                aVar.fW(3, this.wJr.bke());
                this.wJr.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wHu != null) {
                r0 = e.a.a.a.fT(1, this.wHu.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.wHw);
            if (this.wJr != null) {
                r0 += e.a.a.a.fT(3, this.wJr.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wHu == null) {
                throw new b("Not all required fields were included: rcptinfolist");
            } else if (this.wJr != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BaseResponse");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bav com_tencent_mm_protocal_c_bav = (bav) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a com_tencent_mm_protocal_c_baw;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_baw = new baw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_baw.a(aVar4, com_tencent_mm_protocal_c_baw, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bav.wHu = com_tencent_mm_protocal_c_baw;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bav.wHw = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_baw = new fe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_baw.a(aVar4, com_tencent_mm_protocal_c_baw, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bav.wJr = com_tencent_mm_protocal_c_baw;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
