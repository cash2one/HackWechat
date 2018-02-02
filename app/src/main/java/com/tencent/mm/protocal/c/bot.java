package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class bot extends a {
    public int uin;
    public b wRg;
    public String wRh;
    public b wRi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wRg != null) {
                aVar.b(1, this.wRg);
            }
            if (this.wRh != null) {
                aVar.g(2, this.wRh);
            }
            if (this.wRi != null) {
                aVar.b(3, this.wRi);
            }
            aVar.fU(4, this.uin);
            return 0;
        } else if (i == 1) {
            if (this.wRg != null) {
                r0 = e.a.a.a.a(1, this.wRg) + 0;
            } else {
                r0 = 0;
            }
            if (this.wRh != null) {
                r0 += e.a.a.b.b.a.h(2, this.wRh);
            }
            if (this.wRi != null) {
                r0 += e.a.a.a.a(3, this.wRi);
            }
            return r0 + e.a.a.a.fR(4, this.uin);
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
            bot com_tencent_mm_protocal_c_bot = (bot) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bot.wRg = aVar3.cJD();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bot.wRh = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bot.wRi = aVar3.cJD();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bot.uin = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
