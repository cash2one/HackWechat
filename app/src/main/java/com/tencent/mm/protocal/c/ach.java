package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ach extends bdf {
    public long ktl;
    public long vGU;
    public int wla;
    public int wlb;
    public int wlc;

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
            aVar.S(2, this.vGU);
            aVar.S(3, this.ktl);
            aVar.fU(4, this.wla);
            aVar.fU(5, this.wlb);
            aVar.fU(6, this.wlc);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            return ((((r0 + e.a.a.a.R(2, this.vGU)) + e.a.a.a.R(3, this.ktl)) + e.a.a.a.fR(4, this.wla)) + e.a.a.a.fR(5, this.wlb)) + e.a.a.a.fR(6, this.wlc);
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
            ach com_tencent_mm_protocal_c_ach = (ach) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ach.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ach.vGU = aVar3.Avy.rz();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ach.ktl = aVar3.Avy.rz();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ach.wla = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ach.wlb = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ach.wlc = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
