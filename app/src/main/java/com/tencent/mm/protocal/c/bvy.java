package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bvy extends a {
    public boolean wXd;
    public String wXe;
    public String wXf;
    public int wXg;
    public int wXh;
    public int wXi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.al(1, this.wXd);
            if (this.wXe != null) {
                aVar.g(2, this.wXe);
            }
            if (this.wXf != null) {
                aVar.g(3, this.wXf);
            }
            aVar.fU(4, this.wXg);
            aVar.fU(5, this.wXh);
            aVar.fU(6, this.wXi);
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.b.b.a.dX(1) + 1) + 0;
            if (this.wXe != null) {
                r0 += e.a.a.b.b.a.h(2, this.wXe);
            }
            if (this.wXf != null) {
                r0 += e.a.a.b.b.a.h(3, this.wXf);
            }
            return ((r0 + e.a.a.a.fR(4, this.wXg)) + e.a.a.a.fR(5, this.wXh)) + e.a.a.a.fR(6, this.wXi);
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
            bvy com_tencent_mm_protocal_c_bvy = (bvy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bvy.wXd = aVar3.cJC();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bvy.wXe = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bvy.wXf = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bvy.wXg = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bvy.wXh = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bvy.wXi = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
