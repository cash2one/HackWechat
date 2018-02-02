package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bbn extends a {
    public String fyY;
    public int number;
    public String type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.type != null) {
                aVar.g(1, this.type);
            }
            if (this.fyY != null) {
                aVar.g(2, this.fyY);
            }
            aVar.fU(3, this.number);
            return 0;
        } else if (i == 1) {
            if (this.type != null) {
                r0 = e.a.a.b.b.a.h(1, this.type) + 0;
            } else {
                r0 = 0;
            }
            if (this.fyY != null) {
                r0 += e.a.a.b.b.a.h(2, this.fyY);
            }
            return r0 + e.a.a.a.fR(3, this.number);
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
            bbn com_tencent_mm_protocal_c_bbn = (bbn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bbn.type = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bbn.fyY = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bbn.number = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
