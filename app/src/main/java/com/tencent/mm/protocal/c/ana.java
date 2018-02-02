package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ana extends a {
    public ann vGB;
    public LinkedList<ano> vGC = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vGB == null) {
                throw new b("Not all required fields were included: LogHead");
            }
            if (this.vGB != null) {
                aVar.fW(1, this.vGB.bke());
                this.vGB.a(aVar);
            }
            aVar.d(2, 8, this.vGC);
            return 0;
        } else if (i == 1) {
            if (this.vGB != null) {
                r0 = e.a.a.a.fT(1, this.vGB.bke()) + 0;
            } else {
                r0 = 0;
            }
            return r0 + e.a.a.a.c(2, 8, this.vGC);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vGC.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vGB != null) {
                return 0;
            }
            throw new b("Not all required fields were included: LogHead");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ana com_tencent_mm_protocal_c_ana = (ana) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a com_tencent_mm_protocal_c_ann;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_ann = new ann();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ann.a(aVar4, com_tencent_mm_protocal_c_ann, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ana.vGB = com_tencent_mm_protocal_c_ann;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_ann = new ano();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ann.a(aVar4, com_tencent_mm_protocal_c_ann, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ana.vGC.add(com_tencent_mm_protocal_c_ann);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
