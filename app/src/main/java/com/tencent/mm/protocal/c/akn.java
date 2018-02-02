package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class akn extends a {
    public String njX;
    public float vOa;
    public float vOb;
    public float wrM;
    public String wrN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.m(1, this.vOa);
            aVar.m(2, this.vOb);
            aVar.m(3, this.wrM);
            if (this.njX != null) {
                aVar.g(4, this.njX);
            }
            if (this.wrN != null) {
                aVar.g(5, this.wrN);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((e.a.a.b.b.a.dX(1) + 4) + 0) + (e.a.a.b.b.a.dX(2) + 4)) + (e.a.a.b.b.a.dX(3) + 4);
            if (this.njX != null) {
                r0 += e.a.a.b.b.a.h(4, this.njX);
            }
            if (this.wrN != null) {
                return r0 + e.a.a.b.b.a.h(5, this.wrN);
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
            akn com_tencent_mm_protocal_c_akn = (akn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_akn.vOa = aVar3.Avy.readFloat();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_akn.vOb = aVar3.Avy.readFloat();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_akn.wrM = aVar3.Avy.readFloat();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_akn.njX = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_akn.wrN = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
