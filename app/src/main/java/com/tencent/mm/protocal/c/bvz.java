package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bvz extends a {
    public LinkedList<bvn> wWZ = new LinkedList();
    public bvh wXj;
    public int wXk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wXj == null) {
                throw new b("Not all required fields were included: base_request");
            }
            if (this.wXj != null) {
                aVar.fW(1, this.wXj.bke());
                this.wXj.a(aVar);
            }
            aVar.d(2, 8, this.wWZ);
            aVar.fU(3, this.wXk);
            return 0;
        } else if (i == 1) {
            if (this.wXj != null) {
                r0 = e.a.a.a.fT(1, this.wXj.bke()) + 0;
            } else {
                r0 = 0;
            }
            return (r0 + e.a.a.a.c(2, 8, this.wWZ)) + e.a.a.a.fR(3, this.wXk);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wWZ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wXj != null) {
                return 0;
            }
            throw new b("Not all required fields were included: base_request");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bvz com_tencent_mm_protocal_c_bvz = (bvz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a com_tencent_mm_protocal_c_bvh;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bvh = new bvh();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bvh.a(aVar4, com_tencent_mm_protocal_c_bvh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bvz.wXj = com_tencent_mm_protocal_c_bvh;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bvh = new bvn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bvh.a(aVar4, com_tencent_mm_protocal_c_bvh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bvz.wWZ.add(com_tencent_mm_protocal_c_bvh);
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bvz.wXk = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
