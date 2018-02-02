package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cc extends a {
    public biz vHo;
    public bdo vHp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vHo == null) {
                throw new b("Not all required fields were included: SnsADObject");
            }
            if (this.vHo != null) {
                aVar.fW(1, this.vHo.bke());
                this.vHo.a(aVar);
            }
            if (this.vHp == null) {
                return 0;
            }
            aVar.fW(2, this.vHp.bke());
            this.vHp.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.vHo != null) {
                r0 = e.a.a.a.fT(1, this.vHo.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vHp != null) {
                r0 += e.a.a.a.fT(2, this.vHp.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vHo != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SnsADObject");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cc ccVar = (cc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_biz;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_biz = new biz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_biz.a(aVar4, com_tencent_mm_protocal_c_biz, a.a(aVar4))) {
                        }
                        ccVar.vHo = com_tencent_mm_protocal_c_biz;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_biz = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_biz.a(aVar4, com_tencent_mm_protocal_c_biz, a.a(aVar4))) {
                        }
                        ccVar.vHp = com_tencent_mm_protocal_c_biz;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
