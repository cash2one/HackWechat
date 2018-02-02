package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class og extends a {
    public int vXg;
    public bdn vXh;
    public int vXi;
    public bdn vXj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vXh == null) {
                throw new b("Not all required fields were included: OperationInfo");
            }
            aVar.fU(1, this.vXg);
            if (this.vXh != null) {
                aVar.fW(2, this.vXh.bke());
                this.vXh.a(aVar);
            }
            aVar.fU(3, this.vXi);
            if (this.vXj != null) {
                aVar.fW(4, this.vXj.bke());
                this.vXj.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vXg) + 0;
            if (this.vXh != null) {
                r0 += e.a.a.a.fT(2, this.vXh.bke());
            }
            r0 += e.a.a.a.fR(3, this.vXi);
            if (this.vXj != null) {
                return r0 + e.a.a.a.fT(4, this.vXj.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vXh != null) {
                return 0;
            }
            throw new b("Not all required fields were included: OperationInfo");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            og ogVar = (og) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bdn;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    ogVar.vXg = aVar3.Avy.ry();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        ogVar.vXh = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 3:
                    ogVar.vXi = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdn = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        ogVar.vXj = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
