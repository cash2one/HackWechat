package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ary extends a {
    public ajr vLR;
    public ajs vLS;
    public int wzG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vLR == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.vLS == null) {
                throw new b("Not all required fields were included: HardDeviceAttr");
            } else {
                if (this.vLR != null) {
                    aVar.fW(1, this.vLR.bke());
                    this.vLR.a(aVar);
                }
                if (this.vLS != null) {
                    aVar.fW(2, this.vLS.bke());
                    this.vLS.a(aVar);
                }
                aVar.fU(3, this.wzG);
                return 0;
            }
        } else if (i == 1) {
            if (this.vLR != null) {
                r0 = e.a.a.a.fT(1, this.vLR.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vLS != null) {
                r0 += e.a.a.a.fT(2, this.vLS.bke());
            }
            return r0 + e.a.a.a.fR(3, this.wzG);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vLR == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.vLS != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: HardDeviceAttr");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ary com_tencent_mm_protocal_c_ary = (ary) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_ajr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_ajr = new ajr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ajr.a(aVar4, com_tencent_mm_protocal_c_ajr, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ary.vLR = com_tencent_mm_protocal_c_ajr;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_ajr = new ajs();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ajr.a(aVar4, com_tencent_mm_protocal_c_ajr, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ary.vLS = com_tencent_mm_protocal_c_ajr;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ary.wzG = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
