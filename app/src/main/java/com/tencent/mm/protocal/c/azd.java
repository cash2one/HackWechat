package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class azd extends a {
    public String vZU;
    public int wGg;
    public int wbk;
    public String wgG;
    public int wmO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wmO);
            if (this.wgG != null) {
                aVar.g(2, this.wgG);
            }
            if (this.vZU != null) {
                aVar.g(3, this.vZU);
            }
            aVar.fU(4, this.wbk);
            aVar.fU(5, this.wGg);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wmO) + 0;
            if (this.wgG != null) {
                r0 += e.a.a.b.b.a.h(2, this.wgG);
            }
            if (this.vZU != null) {
                r0 += e.a.a.b.b.a.h(3, this.vZU);
            }
            return (r0 + e.a.a.a.fR(4, this.wbk)) + e.a.a.a.fR(5, this.wGg);
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
            azd com_tencent_mm_protocal_c_azd = (azd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_azd.wmO = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_azd.wgG = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_azd.vZU = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_azd.wbk = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_azd.wGg = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
