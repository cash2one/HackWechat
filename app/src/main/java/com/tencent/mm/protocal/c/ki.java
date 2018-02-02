package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ki extends a {
    public int bZN;
    public int qox;
    public String text;
    public int type;
    public String url;
    public String vRv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.type);
            if (this.text != null) {
                aVar.g(2, this.text);
            }
            if (this.url != null) {
                aVar.g(3, this.url);
            }
            aVar.fU(4, this.qox);
            aVar.fU(5, this.bZN);
            if (this.vRv != null) {
                aVar.g(6, this.vRv);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.type) + 0;
            if (this.text != null) {
                r0 += e.a.a.b.b.a.h(2, this.text);
            }
            if (this.url != null) {
                r0 += e.a.a.b.b.a.h(3, this.url);
            }
            r0 = (r0 + e.a.a.a.fR(4, this.qox)) + e.a.a.a.fR(5, this.bZN);
            if (this.vRv != null) {
                return r0 + e.a.a.b.b.a.h(6, this.vRv);
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
            ki kiVar = (ki) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kiVar.type = aVar3.Avy.ry();
                    return 0;
                case 2:
                    kiVar.text = aVar3.Avy.readString();
                    return 0;
                case 3:
                    kiVar.url = aVar3.Avy.readString();
                    return 0;
                case 4:
                    kiVar.qox = aVar3.Avy.ry();
                    return 0;
                case 5:
                    kiVar.bZN = aVar3.Avy.ry();
                    return 0;
                case 6:
                    kiVar.vRv = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
