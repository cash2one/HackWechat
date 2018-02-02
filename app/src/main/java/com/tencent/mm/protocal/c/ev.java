package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ev extends a {
    public String sAa;
    public String sAb;
    public String sAc;
    public int szZ;
    public String title;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            aVar.fU(2, this.szZ);
            if (this.sAa != null) {
                aVar.g(3, this.sAa);
            }
            if (this.sAb != null) {
                aVar.g(4, this.sAb);
            }
            if (this.sAc == null) {
                return 0;
            }
            aVar.g(5, this.sAc);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.szZ);
            if (this.sAa != null) {
                r0 += e.a.a.b.b.a.h(3, this.sAa);
            }
            if (this.sAb != null) {
                r0 += e.a.a.b.b.a.h(4, this.sAb);
            }
            if (this.sAc != null) {
                r0 += e.a.a.b.b.a.h(5, this.sAc);
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
            ev evVar = (ev) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    evVar.title = aVar3.Avy.readString();
                    return 0;
                case 2:
                    evVar.szZ = aVar3.Avy.ry();
                    return 0;
                case 3:
                    evVar.sAa = aVar3.Avy.readString();
                    return 0;
                case 4:
                    evVar.sAb = aVar3.Avy.readString();
                    return 0;
                case 5:
                    evVar.sAc = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
