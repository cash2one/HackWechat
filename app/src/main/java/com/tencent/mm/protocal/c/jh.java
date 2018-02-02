package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class jh extends a {
    public String fon;
    public String nfX;
    public String vPv;
    public String vPw;
    public int vPx;
    public String vPy;
    public int vPz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nfX == null) {
                throw new b("Not all required fields were included: Url");
            } else if (this.vPv == null) {
                throw new b("Not all required fields were included: Position");
            } else if (this.vPw == null) {
                throw new b("Not all required fields were included: DetailInfo");
            } else {
                if (this.fon != null) {
                    aVar.g(1, this.fon);
                }
                if (this.nfX != null) {
                    aVar.g(2, this.nfX);
                }
                if (this.vPv != null) {
                    aVar.g(3, this.vPv);
                }
                if (this.vPw != null) {
                    aVar.g(4, this.vPw);
                }
                aVar.fU(5, this.vPx);
                if (this.vPy != null) {
                    aVar.g(6, this.vPy);
                }
                aVar.fU(7, this.vPz);
                return 0;
            }
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfX != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfX);
            }
            if (this.vPv != null) {
                r0 += e.a.a.b.b.a.h(3, this.vPv);
            }
            if (this.vPw != null) {
                r0 += e.a.a.b.b.a.h(4, this.vPw);
            }
            r0 += e.a.a.a.fR(5, this.vPx);
            if (this.vPy != null) {
                r0 += e.a.a.b.b.a.h(6, this.vPy);
            }
            return r0 + e.a.a.a.fR(7, this.vPz);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nfX == null) {
                throw new b("Not all required fields were included: Url");
            } else if (this.vPv == null) {
                throw new b("Not all required fields were included: Position");
            } else if (this.vPw != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DetailInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jh jhVar = (jh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jhVar.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    jhVar.nfX = aVar3.Avy.readString();
                    return 0;
                case 3:
                    jhVar.vPv = aVar3.Avy.readString();
                    return 0;
                case 4:
                    jhVar.vPw = aVar3.Avy.readString();
                    return 0;
                case 5:
                    jhVar.vPx = aVar3.Avy.ry();
                    return 0;
                case 6:
                    jhVar.vPy = aVar3.Avy.readString();
                    return 0;
                case 7:
                    jhVar.vPz = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
