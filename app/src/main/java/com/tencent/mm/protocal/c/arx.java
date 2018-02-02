package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class arx extends a {
    public int ktN;
    public String niX;
    public String pQt;
    public String wzF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.niX != null) {
                aVar.g(1, this.niX);
            }
            if (this.wzF != null) {
                aVar.g(2, this.wzF);
            }
            if (this.pQt != null) {
                aVar.g(3, this.pQt);
            }
            aVar.fU(4, this.ktN);
            return 0;
        } else if (i == 1) {
            if (this.niX != null) {
                r0 = e.a.a.b.b.a.h(1, this.niX) + 0;
            } else {
                r0 = 0;
            }
            if (this.wzF != null) {
                r0 += e.a.a.b.b.a.h(2, this.wzF);
            }
            if (this.pQt != null) {
                r0 += e.a.a.b.b.a.h(3, this.pQt);
            }
            return r0 + e.a.a.a.fR(4, this.ktN);
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
            arx com_tencent_mm_protocal_c_arx = (arx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_arx.niX = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_arx.wzF = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_arx.pQt = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_arx.ktN = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
