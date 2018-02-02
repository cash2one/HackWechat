package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class brk extends a {
    public String qgh;
    public int qgi;
    public String scope;
    public int state;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.scope != null) {
                aVar.g(1, this.scope);
            }
            if (this.qgh != null) {
                aVar.g(2, this.qgh);
            }
            aVar.fU(3, this.state);
            aVar.fU(4, this.qgi);
            return 0;
        } else if (i == 1) {
            if (this.scope != null) {
                r0 = e.a.a.b.b.a.h(1, this.scope) + 0;
            } else {
                r0 = 0;
            }
            if (this.qgh != null) {
                r0 += e.a.a.b.b.a.h(2, this.qgh);
            }
            return (r0 + e.a.a.a.fR(3, this.state)) + e.a.a.a.fR(4, this.qgi);
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
            brk com_tencent_mm_protocal_c_brk = (brk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_brk.scope = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_brk.qgh = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_brk.state = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_brk.qgi = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
