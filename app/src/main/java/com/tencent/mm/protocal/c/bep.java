package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bep extends a {
    public int vLh;
    public bdn wkp;
    public String wkq;
    public long wks;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wkq == null) {
                throw new b("Not all required fields were included: KeyWord");
            }
            aVar.fU(1, this.vLh);
            if (this.wkq != null) {
                aVar.g(2, this.wkq);
            }
            if (this.wkp != null) {
                aVar.fW(3, this.wkp.bke());
                this.wkp.a(aVar);
            }
            aVar.S(4, this.wks);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vLh) + 0;
            if (this.wkq != null) {
                r0 += e.a.a.b.b.a.h(2, this.wkq);
            }
            if (this.wkp != null) {
                r0 += e.a.a.a.fT(3, this.wkp.bke());
            }
            return r0 + e.a.a.a.R(4, this.wks);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wkq != null) {
                return 0;
            }
            throw new b("Not all required fields were included: KeyWord");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bep com_tencent_mm_protocal_c_bep = (bep) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bep.vLh = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bep.wkq = aVar3.Avy.readString();
                    return 0;
                case 3:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bdn = new bdn();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bep.wkp = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bep.wks = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
