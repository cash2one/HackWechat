package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cal extends a {
    public String wnK;
    public bdn wnN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wnN == null) {
                throw new b("Not all required fields were included: VerifyBuff");
            }
            if (this.wnK != null) {
                aVar.g(1, this.wnK);
            }
            if (this.wnN == null) {
                return 0;
            }
            aVar.fW(2, this.wnN.bke());
            this.wnN.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wnK != null) {
                r0 = e.a.a.b.b.a.h(1, this.wnK) + 0;
            } else {
                r0 = 0;
            }
            if (this.wnN != null) {
                r0 += e.a.a.a.fT(2, this.wnN.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wnN != null) {
                return 0;
            }
            throw new b("Not all required fields were included: VerifyBuff");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cal com_tencent_mm_protocal_c_cal = (cal) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_cal.wnK = aVar3.Avy.readString();
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
                        com_tencent_mm_protocal_c_cal.wnN = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
