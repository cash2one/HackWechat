package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class awy extends a {
    public String nfp;
    public String waN;
    public int wko;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wko);
            if (this.nfp != null) {
                aVar.g(2, this.nfp);
            }
            if (this.waN != null) {
                aVar.g(3, this.waN);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wko) + 0;
            if (this.nfp != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfp);
            }
            if (this.waN != null) {
                return r0 + e.a.a.b.b.a.h(3, this.waN);
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
            awy com_tencent_mm_protocal_c_awy = (awy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_awy.wko = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_awy.nfp = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_awy.waN = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
