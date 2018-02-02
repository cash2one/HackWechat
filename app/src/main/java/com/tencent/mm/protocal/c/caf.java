package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class caf extends a {
    public String fqR;
    public String url;
    public int vOu;
    public int wZQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wZQ);
            aVar.fU(2, this.vOu);
            if (this.url != null) {
                aVar.g(3, this.url);
            }
            if (this.fqR != null) {
                aVar.g(4, this.fqR);
            }
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.fR(1, this.wZQ) + 0) + e.a.a.a.fR(2, this.vOu);
            if (this.url != null) {
                r0 += e.a.a.b.b.a.h(3, this.url);
            }
            if (this.fqR != null) {
                return r0 + e.a.a.b.b.a.h(4, this.fqR);
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
            caf com_tencent_mm_protocal_c_caf = (caf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_caf.wZQ = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_caf.vOu = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_caf.url = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_caf.fqR = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
