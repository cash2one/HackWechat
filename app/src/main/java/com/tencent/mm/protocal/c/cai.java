package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class cai extends a {
    public String nfZ;
    public String wZT;
    public String wvW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wZT != null) {
                aVar.g(1, this.wZT);
            }
            if (this.nfZ != null) {
                aVar.g(2, this.nfZ);
            }
            if (this.wvW == null) {
                return 0;
            }
            aVar.g(3, this.wvW);
            return 0;
        } else if (i == 1) {
            if (this.wZT != null) {
                r0 = e.a.a.b.b.a.h(1, this.wZT) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfZ != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfZ);
            }
            if (this.wvW != null) {
                r0 += e.a.a.b.b.a.h(3, this.wvW);
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
            cai com_tencent_mm_protocal_c_cai = (cai) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_cai.wZT = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_cai.nfZ = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_cai.wvW = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
