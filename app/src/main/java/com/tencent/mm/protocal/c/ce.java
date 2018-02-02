package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ce extends a {
    public String title;
    public String vHw;
    public LinkedList<blz> vHx = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vHw != null) {
                aVar.g(1, this.vHw);
            }
            aVar.d(2, 8, this.vHx);
            if (this.title == null) {
                return 0;
            }
            aVar.g(3, this.title);
            return 0;
        } else if (i == 1) {
            if (this.vHw != null) {
                r0 = e.a.a.b.b.a.h(1, this.vHw) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.c(2, 8, this.vHx);
            if (this.title != null) {
                r0 += e.a.a.b.b.a.h(3, this.title);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vHx.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ce ceVar = (ce) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ceVar.vHw = aVar3.Avy.readString();
                    return 0;
                case 2:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_blz = new blz();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_blz.a(aVar4, com_tencent_mm_protocal_c_blz, a.a(aVar4))) {
                        }
                        ceVar.vHx.add(com_tencent_mm_protocal_c_blz);
                    }
                    return 0;
                case 3:
                    ceVar.title = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
