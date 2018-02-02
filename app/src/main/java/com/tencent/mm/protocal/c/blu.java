package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class blu extends a {
    public int cOY;
    public int hOz;
    public String rou;
    public String wPo;
    public String wPp;
    public int wPq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.hOz);
            if (this.wPo != null) {
                aVar.g(2, this.wPo);
            }
            if (this.wPp != null) {
                aVar.g(3, this.wPp);
            }
            aVar.fU(4, this.cOY);
            if (this.rou != null) {
                aVar.g(5, this.rou);
            }
            aVar.fU(6, this.wPq);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.hOz) + 0;
            if (this.wPo != null) {
                r0 += e.a.a.b.b.a.h(2, this.wPo);
            }
            if (this.wPp != null) {
                r0 += e.a.a.b.b.a.h(3, this.wPp);
            }
            r0 += e.a.a.a.fR(4, this.cOY);
            if (this.rou != null) {
                r0 += e.a.a.b.b.a.h(5, this.rou);
            }
            return r0 + e.a.a.a.fR(6, this.wPq);
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
            blu com_tencent_mm_protocal_c_blu = (blu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_blu.hOz = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_blu.wPo = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_blu.wPp = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_blu.cOY = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_blu.rou = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_blu.wPq = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
