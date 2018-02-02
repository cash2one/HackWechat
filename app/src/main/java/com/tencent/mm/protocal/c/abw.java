package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class abw extends a {
    public bdn vHG;
    public String vIR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vIR == null) {
                throw new b("Not all required fields were included: ProductID");
            } else if (this.vHG == null) {
                throw new b("Not all required fields were included: ReqBuf");
            } else {
                if (this.vIR != null) {
                    aVar.g(1, this.vIR);
                }
                if (this.vHG == null) {
                    return 0;
                }
                aVar.fW(2, this.vHG.bke());
                this.vHG.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.vIR != null) {
                r0 = e.a.a.b.b.a.h(1, this.vIR) + 0;
            } else {
                r0 = 0;
            }
            if (this.vHG != null) {
                r0 += e.a.a.a.fT(2, this.vHG.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vIR == null) {
                throw new b("Not all required fields were included: ProductID");
            } else if (this.vHG != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ReqBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abw com_tencent_mm_protocal_c_abw = (abw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_abw.vIR = aVar3.Avy.readString();
                    return 0;
                case 2:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bdn = new bdn();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abw.vHG = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
