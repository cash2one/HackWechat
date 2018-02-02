package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class hj extends a {
    public String name;
    public int type;
    public String vNk;
    public String vNl;
    public int vNm;
    public int vNn;
    public String vNo;
    public String vNp;
    public int ver;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNk != null) {
                aVar.g(1, this.vNk);
            }
            aVar.fU(2, this.type);
            if (this.vNl != null) {
                aVar.g(3, this.vNl);
            }
            if (this.name != null) {
                aVar.g(4, this.name);
            }
            aVar.fU(5, this.ver);
            aVar.fU(6, this.vNm);
            aVar.fU(7, this.vNn);
            if (this.vNo != null) {
                aVar.g(8, this.vNo);
            }
            if (this.vNp == null) {
                return 0;
            }
            aVar.g(9, this.vNp);
            return 0;
        } else if (i == 1) {
            if (this.vNk != null) {
                r0 = e.a.a.b.b.a.h(1, this.vNk) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.type);
            if (this.vNl != null) {
                r0 += e.a.a.b.b.a.h(3, this.vNl);
            }
            if (this.name != null) {
                r0 += e.a.a.b.b.a.h(4, this.name);
            }
            r0 = ((r0 + e.a.a.a.fR(5, this.ver)) + e.a.a.a.fR(6, this.vNm)) + e.a.a.a.fR(7, this.vNn);
            if (this.vNo != null) {
                r0 += e.a.a.b.b.a.h(8, this.vNo);
            }
            if (this.vNp != null) {
                r0 += e.a.a.b.b.a.h(9, this.vNp);
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
            hj hjVar = (hj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hjVar.vNk = aVar3.Avy.readString();
                    return 0;
                case 2:
                    hjVar.type = aVar3.Avy.ry();
                    return 0;
                case 3:
                    hjVar.vNl = aVar3.Avy.readString();
                    return 0;
                case 4:
                    hjVar.name = aVar3.Avy.readString();
                    return 0;
                case 5:
                    hjVar.ver = aVar3.Avy.ry();
                    return 0;
                case 6:
                    hjVar.vNm = aVar3.Avy.ry();
                    return 0;
                case 7:
                    hjVar.vNn = aVar3.Avy.ry();
                    return 0;
                case 8:
                    hjVar.vNo = aVar3.Avy.readString();
                    return 0;
                case 9:
                    hjVar.vNp = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
