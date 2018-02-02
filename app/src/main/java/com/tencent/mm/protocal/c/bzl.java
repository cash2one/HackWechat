package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class bzl extends a {
    public b vIA;
    public int vZw;
    public String wYG;
    public boolean wZi;
    public boolean wZj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wYG == null) {
                throw new e.a.a.b("Not all required fields were included: Talker");
            }
            if (this.wYG != null) {
                aVar.g(1, this.wYG);
            }
            aVar.fU(2, this.vZw);
            if (this.vIA != null) {
                aVar.b(3, this.vIA);
            }
            aVar.al(4, this.wZi);
            aVar.al(5, this.wZj);
            return 0;
        } else if (i == 1) {
            if (this.wYG != null) {
                r0 = e.a.a.b.b.a.h(1, this.wYG) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.vZw);
            if (this.vIA != null) {
                r0 += e.a.a.a.a(3, this.vIA);
            }
            return (r0 + (e.a.a.b.b.a.dX(4) + 1)) + (e.a.a.b.b.a.dX(5) + 1);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wYG != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: Talker");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzl com_tencent_mm_protocal_c_bzl = (bzl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bzl.wYG = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bzl.vZw = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bzl.vIA = aVar3.cJD();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bzl.wZi = aVar3.cJC();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bzl.wZj = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
