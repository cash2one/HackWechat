package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bds extends a {
    public int ksO;
    public String wFh;
    public String wFi;
    public String wmH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wmH != null) {
                aVar.g(1, this.wmH);
            }
            if (this.wFi != null) {
                aVar.g(2, this.wFi);
            }
            aVar.fU(3, this.ksO);
            if (this.wFh == null) {
                return 0;
            }
            aVar.g(4, this.wFh);
            return 0;
        } else if (i == 1) {
            if (this.wmH != null) {
                r0 = e.a.a.b.b.a.h(1, this.wmH) + 0;
            } else {
                r0 = 0;
            }
            if (this.wFi != null) {
                r0 += e.a.a.b.b.a.h(2, this.wFi);
            }
            r0 += e.a.a.a.fR(3, this.ksO);
            if (this.wFh != null) {
                r0 += e.a.a.b.b.a.h(4, this.wFh);
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
            bds com_tencent_mm_protocal_c_bds = (bds) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bds.wmH = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bds.wFi = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bds.ksO = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bds.wFh = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
