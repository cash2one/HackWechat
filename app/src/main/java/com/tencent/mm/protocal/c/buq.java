package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class buq extends a {
    public String mBX;
    public String userName;
    public int wWd;
    public int wWe;
    public int wWf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wWd);
            aVar.fU(2, this.wWe);
            aVar.fU(3, this.wWf);
            if (this.userName != null) {
                aVar.g(4, this.userName);
            }
            if (this.mBX != null) {
                aVar.g(5, this.mBX);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((e.a.a.a.fR(1, this.wWd) + 0) + e.a.a.a.fR(2, this.wWe)) + e.a.a.a.fR(3, this.wWf);
            if (this.userName != null) {
                r0 += e.a.a.b.b.a.h(4, this.userName);
            }
            if (this.mBX != null) {
                return r0 + e.a.a.b.b.a.h(5, this.mBX);
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
            buq com_tencent_mm_protocal_c_buq = (buq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_buq.wWd = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_buq.wWe = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_buq.wWf = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_buq.userName = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_buq.mBX = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
