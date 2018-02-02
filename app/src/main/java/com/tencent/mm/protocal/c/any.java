package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class any extends a {
    public int vEe;
    public String wpn;
    public String wuL;
    public boolean wuM;
    public String wuN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vEe);
            if (this.wuL != null) {
                aVar.g(2, this.wuL);
            }
            aVar.al(3, this.wuM);
            if (this.wuN != null) {
                aVar.g(4, this.wuN);
            }
            if (this.wpn != null) {
                aVar.g(5, this.wpn);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vEe) + 0;
            if (this.wuL != null) {
                r0 += e.a.a.b.b.a.h(2, this.wuL);
            }
            r0 += e.a.a.b.b.a.dX(3) + 1;
            if (this.wuN != null) {
                r0 += e.a.a.b.b.a.h(4, this.wuN);
            }
            if (this.wpn != null) {
                return r0 + e.a.a.b.b.a.h(5, this.wpn);
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
            any com_tencent_mm_protocal_c_any = (any) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_any.vEe = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_any.wuL = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_any.wuM = aVar3.cJC();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_any.wuN = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_any.wpn = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
