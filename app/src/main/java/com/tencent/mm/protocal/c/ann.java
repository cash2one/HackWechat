package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ann extends a {
    public String vOf;
    public String vOg;
    public String vOh;
    public String vOi;
    public String vOj;
    public int wuB;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vOf != null) {
                aVar.g(1, this.vOf);
            }
            if (this.vOg != null) {
                aVar.g(2, this.vOg);
            }
            if (this.vOh != null) {
                aVar.g(3, this.vOh);
            }
            if (this.vOi != null) {
                aVar.g(4, this.vOi);
            }
            if (this.vOj != null) {
                aVar.g(5, this.vOj);
            }
            aVar.fU(6, this.wuB);
            return 0;
        } else if (i == 1) {
            if (this.vOf != null) {
                r0 = e.a.a.b.b.a.h(1, this.vOf) + 0;
            } else {
                r0 = 0;
            }
            if (this.vOg != null) {
                r0 += e.a.a.b.b.a.h(2, this.vOg);
            }
            if (this.vOh != null) {
                r0 += e.a.a.b.b.a.h(3, this.vOh);
            }
            if (this.vOi != null) {
                r0 += e.a.a.b.b.a.h(4, this.vOi);
            }
            if (this.vOj != null) {
                r0 += e.a.a.b.b.a.h(5, this.vOj);
            }
            return r0 + e.a.a.a.fR(6, this.wuB);
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
            ann com_tencent_mm_protocal_c_ann = (ann) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ann.vOf = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ann.vOg = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ann.vOh = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ann.vOi = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ann.vOj = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ann.wuB = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
