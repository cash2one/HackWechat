package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bta extends a {
    public int vLj;
    public String vWC;
    public bdn wRU;
    public int wUd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wRU == null) {
                throw new b("Not all required fields were included: Text");
            }
            if (this.wRU != null) {
                aVar.fW(1, this.wRU.bke());
                this.wRU.a(aVar);
            }
            if (this.vWC != null) {
                aVar.g(2, this.vWC);
            }
            aVar.fU(3, this.vLj);
            aVar.fU(4, this.wUd);
            return 0;
        } else if (i == 1) {
            if (this.wRU != null) {
                r0 = e.a.a.a.fT(1, this.wRU.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vWC != null) {
                r0 += e.a.a.b.b.a.h(2, this.vWC);
            }
            return (r0 + e.a.a.a.fR(3, this.vLj)) + e.a.a.a.fR(4, this.wUd);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wRU != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Text");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bta com_tencent_mm_protocal_c_bta = (bta) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bdn = new bdn();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bta.wRU = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bta.vWC = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bta.vLj = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bta.wUd = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
