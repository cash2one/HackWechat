package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ayb extends a {
    public String fyY;
    public String url;
    public String wFn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fyY != null) {
                aVar.g(1, this.fyY);
            }
            if (this.url != null) {
                aVar.g(2, this.url);
            }
            if (this.wFn == null) {
                return 0;
            }
            aVar.g(3, this.wFn);
            return 0;
        } else if (i == 1) {
            if (this.fyY != null) {
                r0 = e.a.a.b.b.a.h(1, this.fyY) + 0;
            } else {
                r0 = 0;
            }
            if (this.url != null) {
                r0 += e.a.a.b.b.a.h(2, this.url);
            }
            if (this.wFn != null) {
                r0 += e.a.a.b.b.a.h(3, this.wFn);
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
            ayb com_tencent_mm_protocal_c_ayb = (ayb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ayb.fyY = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ayb.url = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ayb.wFn = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
