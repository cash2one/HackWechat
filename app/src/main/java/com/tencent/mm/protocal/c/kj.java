package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class kj extends a {
    public String country;
    public String descriptor;
    public float fBc;
    public String fWp;
    public String fWq;
    public float fzt;
    public String hxu;
    public String kKe;
    public String kLB;
    public String name;
    public float vRw;
    public String vRx;
    public String vRy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.g(1, this.name);
            }
            if (this.descriptor != null) {
                aVar.g(2, this.descriptor);
            }
            if (this.kKe != null) {
                aVar.g(3, this.kKe);
            }
            if (this.country != null) {
                aVar.g(4, this.country);
            }
            if (this.fWp != null) {
                aVar.g(5, this.fWp);
            }
            if (this.fWq != null) {
                aVar.g(6, this.fWq);
            }
            if (this.hxu != null) {
                aVar.g(7, this.hxu);
            }
            aVar.m(8, this.vRw);
            aVar.m(9, this.fBc);
            aVar.m(10, this.fzt);
            if (this.kLB != null) {
                aVar.g(11, this.kLB);
            }
            if (this.vRx != null) {
                aVar.g(12, this.vRx);
            }
            if (this.vRy == null) {
                return 0;
            }
            aVar.g(13, this.vRy);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                r0 = e.a.a.b.b.a.h(1, this.name) + 0;
            } else {
                r0 = 0;
            }
            if (this.descriptor != null) {
                r0 += e.a.a.b.b.a.h(2, this.descriptor);
            }
            if (this.kKe != null) {
                r0 += e.a.a.b.b.a.h(3, this.kKe);
            }
            if (this.country != null) {
                r0 += e.a.a.b.b.a.h(4, this.country);
            }
            if (this.fWp != null) {
                r0 += e.a.a.b.b.a.h(5, this.fWp);
            }
            if (this.fWq != null) {
                r0 += e.a.a.b.b.a.h(6, this.fWq);
            }
            if (this.hxu != null) {
                r0 += e.a.a.b.b.a.h(7, this.hxu);
            }
            r0 = ((r0 + (e.a.a.b.b.a.dX(8) + 4)) + (e.a.a.b.b.a.dX(9) + 4)) + (e.a.a.b.b.a.dX(10) + 4);
            if (this.kLB != null) {
                r0 += e.a.a.b.b.a.h(11, this.kLB);
            }
            if (this.vRx != null) {
                r0 += e.a.a.b.b.a.h(12, this.vRx);
            }
            if (this.vRy != null) {
                r0 += e.a.a.b.b.a.h(13, this.vRy);
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
            kj kjVar = (kj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kjVar.name = aVar3.Avy.readString();
                    return 0;
                case 2:
                    kjVar.descriptor = aVar3.Avy.readString();
                    return 0;
                case 3:
                    kjVar.kKe = aVar3.Avy.readString();
                    return 0;
                case 4:
                    kjVar.country = aVar3.Avy.readString();
                    return 0;
                case 5:
                    kjVar.fWp = aVar3.Avy.readString();
                    return 0;
                case 6:
                    kjVar.fWq = aVar3.Avy.readString();
                    return 0;
                case 7:
                    kjVar.hxu = aVar3.Avy.readString();
                    return 0;
                case 8:
                    kjVar.vRw = aVar3.Avy.readFloat();
                    return 0;
                case 9:
                    kjVar.fBc = aVar3.Avy.readFloat();
                    return 0;
                case 10:
                    kjVar.fzt = aVar3.Avy.readFloat();
                    return 0;
                case 11:
                    kjVar.kLB = aVar3.Avy.readString();
                    return 0;
                case 12:
                    kjVar.vRx = aVar3.Avy.readString();
                    return 0;
                case 13:
                    kjVar.vRy = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
