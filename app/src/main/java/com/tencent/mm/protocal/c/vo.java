package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class vo extends a {
    public int bkq;
    public String tCr;
    public String wfe;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.tCr == null) {
                throw new b("Not all required fields were included: tagName");
            } else if (this.wfe == null) {
                throw new b("Not all required fields were included: tagPinYin");
            } else {
                if (this.tCr != null) {
                    aVar.g(1, this.tCr);
                }
                if (this.wfe != null) {
                    aVar.g(2, this.wfe);
                }
                aVar.fU(3, this.bkq);
                return 0;
            }
        } else if (i == 1) {
            if (this.tCr != null) {
                r0 = e.a.a.b.b.a.h(1, this.tCr) + 0;
            } else {
                r0 = 0;
            }
            if (this.wfe != null) {
                r0 += e.a.a.b.b.a.h(2, this.wfe);
            }
            return r0 + e.a.a.a.fR(3, this.bkq);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.tCr == null) {
                throw new b("Not all required fields were included: tagName");
            } else if (this.wfe != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: tagPinYin");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            vo voVar = (vo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    voVar.tCr = aVar3.Avy.readString();
                    return 0;
                case 2:
                    voVar.wfe = aVar3.Avy.readString();
                    return 0;
                case 3:
                    voVar.bkq = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
