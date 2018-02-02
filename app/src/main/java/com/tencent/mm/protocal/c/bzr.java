package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bzr extends a {
    public long wZn;
    public ii wZo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.wZn);
            if (this.wZo != null) {
                aVar.fW(2, this.wZo.bke());
                this.wZo.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.R(1, this.wZn) + 0;
            if (this.wZo != null) {
                return r0 + e.a.a.a.fT(2, this.wZo.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            bzr com_tencent_mm_protocal_c_bzr = (bzr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bzr.wZn = aVar3.Avy.rz();
                    return 0;
                case 2:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a iiVar = new ii();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = iiVar.a(aVar4, iiVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bzr.wZo = iiVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
