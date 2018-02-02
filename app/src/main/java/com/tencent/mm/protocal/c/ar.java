package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ar extends a {
    public String ngo;
    public String vFC;
    public String vFD;
    public String vFE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ngo != null) {
                aVar.g(1, this.ngo);
            }
            if (this.vFC != null) {
                aVar.g(2, this.vFC);
            }
            if (this.vFD != null) {
                aVar.g(3, this.vFD);
            }
            if (this.vFE == null) {
                return 0;
            }
            aVar.g(4, this.vFE);
            return 0;
        } else if (i == 1) {
            if (this.ngo != null) {
                r0 = e.a.a.b.b.a.h(1, this.ngo) + 0;
            } else {
                r0 = 0;
            }
            if (this.vFC != null) {
                r0 += e.a.a.b.b.a.h(2, this.vFC);
            }
            if (this.vFD != null) {
                r0 += e.a.a.b.b.a.h(3, this.vFD);
            }
            if (this.vFE != null) {
                r0 += e.a.a.b.b.a.h(4, this.vFE);
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
            ar arVar = (ar) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    arVar.ngo = aVar3.Avy.readString();
                    return 0;
                case 2:
                    arVar.vFC = aVar3.Avy.readString();
                    return 0;
                case 3:
                    arVar.vFD = aVar3.Avy.readString();
                    return 0;
                case 4:
                    arVar.vFE = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
