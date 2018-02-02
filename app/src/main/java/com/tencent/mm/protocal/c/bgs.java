package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bgs extends a {
    public String fpL;
    public String username;
    public boolean wKW;
    public String wKX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.g(1, this.username);
            }
            aVar.al(2, this.wKW);
            if (this.fpL != null) {
                aVar.g(3, this.fpL);
            }
            if (this.wKX == null) {
                return 0;
            }
            aVar.g(4, this.wKX);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                r0 = e.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.b.b.a.dX(2) + 1;
            if (this.fpL != null) {
                r0 += e.a.a.b.b.a.h(3, this.fpL);
            }
            if (this.wKX != null) {
                r0 += e.a.a.b.b.a.h(4, this.wKX);
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
            bgs com_tencent_mm_protocal_c_bgs = (bgs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bgs.username = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bgs.wKW = aVar3.cJC();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bgs.fpL = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bgs.wKX = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
