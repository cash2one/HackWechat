package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class axk extends a {
    public String sEp;
    public String vZl;
    public String wEC;
    public String wED;
    public int wqk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wEC != null) {
                aVar.g(1, this.wEC);
            }
            if (this.wED != null) {
                aVar.g(2, this.wED);
            }
            if (this.sEp != null) {
                aVar.g(3, this.sEp);
            }
            if (this.vZl != null) {
                aVar.g(4, this.vZl);
            }
            aVar.fU(5, this.wqk);
            return 0;
        } else if (i == 1) {
            if (this.wEC != null) {
                r0 = e.a.a.b.b.a.h(1, this.wEC) + 0;
            } else {
                r0 = 0;
            }
            if (this.wED != null) {
                r0 += e.a.a.b.b.a.h(2, this.wED);
            }
            if (this.sEp != null) {
                r0 += e.a.a.b.b.a.h(3, this.sEp);
            }
            if (this.vZl != null) {
                r0 += e.a.a.b.b.a.h(4, this.vZl);
            }
            return r0 + e.a.a.a.fR(5, this.wqk);
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
            axk com_tencent_mm_protocal_c_axk = (axk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_axk.wEC = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axk.wED = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axk.sEp = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axk.vZl = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_axk.wqk = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
