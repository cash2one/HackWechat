package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class axn extends a {
    public bos wEF;
    public int wlx;
    public String wly;
    public String wlz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wlx);
            if (this.wly != null) {
                aVar.g(2, this.wly);
            }
            if (this.wlz != null) {
                aVar.g(3, this.wlz);
            }
            if (this.wEF != null) {
                aVar.fW(4, this.wEF.bke());
                this.wEF.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wlx) + 0;
            if (this.wly != null) {
                r0 += e.a.a.b.b.a.h(2, this.wly);
            }
            if (this.wlz != null) {
                r0 += e.a.a.b.b.a.h(3, this.wlz);
            }
            if (this.wEF != null) {
                return r0 + e.a.a.a.fT(4, this.wEF.bke());
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
            axn com_tencent_mm_protocal_c_axn = (axn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_axn.wlx = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axn.wly = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axn.wlz = aVar3.Avy.readString();
                    return 0;
                case 4:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bos = new bos();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bos.a(aVar4, com_tencent_mm_protocal_c_bos, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axn.wEF = com_tencent_mm_protocal_c_bos;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
