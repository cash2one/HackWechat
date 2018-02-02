package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ats extends a {
    public String desc;
    public String jgw;
    public String scope;
    public int wBO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.scope != null) {
                aVar.g(1, this.scope);
            }
            if (this.desc != null) {
                aVar.g(2, this.desc);
            }
            aVar.fU(3, this.wBO);
            if (this.jgw == null) {
                return 0;
            }
            aVar.g(4, this.jgw);
            return 0;
        } else if (i == 1) {
            if (this.scope != null) {
                r0 = e.a.a.b.b.a.h(1, this.scope) + 0;
            } else {
                r0 = 0;
            }
            if (this.desc != null) {
                r0 += e.a.a.b.b.a.h(2, this.desc);
            }
            r0 += e.a.a.a.fR(3, this.wBO);
            if (this.jgw != null) {
                r0 += e.a.a.b.b.a.h(4, this.jgw);
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
            ats com_tencent_mm_protocal_c_ats = (ats) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ats.scope = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ats.desc = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ats.wBO = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ats.jgw = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
