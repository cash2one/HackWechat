package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class buc extends a {
    public String nkp;
    public int vXp;
    public bdn vXq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vXq == null) {
                throw new b("Not all required fields were included: CmdBuf");
            }
            aVar.fU(1, this.vXp);
            if (this.vXq != null) {
                aVar.fW(2, this.vXq.bke());
                this.vXq.a(aVar);
            }
            if (this.nkp != null) {
                aVar.g(3, this.nkp);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vXp) + 0;
            if (this.vXq != null) {
                r0 += e.a.a.a.fT(2, this.vXq.bke());
            }
            if (this.nkp != null) {
                return r0 + e.a.a.b.b.a.h(3, this.nkp);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vXq != null) {
                return 0;
            }
            throw new b("Not all required fields were included: CmdBuf");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            buc com_tencent_mm_protocal_c_buc = (buc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_buc.vXp = aVar3.Avy.ry();
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
                        com_tencent_mm_protocal_c_buc.vXq = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_buc.nkp = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
