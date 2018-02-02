package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bkd extends a {
    public bad wNA;
    public qp wNB;
    public axw wNC;
    public int wNy;
    public ble wNz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wNy);
            if (this.wNz != null) {
                aVar.fW(2, this.wNz.bke());
                this.wNz.a(aVar);
            }
            if (this.wNA != null) {
                aVar.fW(3, this.wNA.bke());
                this.wNA.a(aVar);
            }
            if (this.wNB != null) {
                aVar.fW(4, this.wNB.bke());
                this.wNB.a(aVar);
            }
            if (this.wNC != null) {
                aVar.fW(5, this.wNC.bke());
                this.wNC.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wNy) + 0;
            if (this.wNz != null) {
                r0 += e.a.a.a.fT(2, this.wNz.bke());
            }
            if (this.wNA != null) {
                r0 += e.a.a.a.fT(3, this.wNA.bke());
            }
            if (this.wNB != null) {
                r0 += e.a.a.a.fT(4, this.wNB.bke());
            }
            if (this.wNC != null) {
                return r0 + e.a.a.a.fT(5, this.wNC.bke());
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
            bkd com_tencent_mm_protocal_c_bkd = (bkd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_ble;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bkd.wNy = aVar3.Avy.ry();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_ble = new ble();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ble.a(aVar4, com_tencent_mm_protocal_c_ble, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkd.wNz = com_tencent_mm_protocal_c_ble;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_ble = new bad();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ble.a(aVar4, com_tencent_mm_protocal_c_ble, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkd.wNA = com_tencent_mm_protocal_c_ble;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_ble = new qp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ble.a(aVar4, com_tencent_mm_protocal_c_ble, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkd.wNB = com_tencent_mm_protocal_c_ble;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_ble = new axw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ble.a(aVar4, com_tencent_mm_protocal_c_ble, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkd.wNC = com_tencent_mm_protocal_c_ble;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
